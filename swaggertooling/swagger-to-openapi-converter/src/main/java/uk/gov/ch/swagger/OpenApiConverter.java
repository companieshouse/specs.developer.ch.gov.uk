package uk.gov.ch.swagger;

import io.swagger.codegen.v3.CodegenArgument;
import io.swagger.codegen.v3.CodegenConfig;
import io.swagger.codegen.v3.CodegenConfigLoader;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.Argument;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.swagger.cmd.Generate;

class OpenApiConverter {

    static String GENERATE_COMMAND_NAME = "generate";
    private static Logger LOGGER = LoggerFactory.getLogger(OpenApiConverter.class);

    private static Map<String, Schema> getSchemasMap(String oas3) {
        final OpenAPI openAPI = new OpenAPIV3Parser().readContents(oas3, null, null).getOpenAPI();
        return openAPI.getComponents().getSchemas();
    }

    void codeGenUpgrade(String... args) {
        final String oas3 = CLIHelper.loadResourceOAS3File();
        if (StringUtils.isBlank(oas3)) {
            LOGGER.error("Could not load resource file.");
            return;
        }
        final Map<String, Schema> schemaMap = getSchemasMap(oas3);
        final Set<String> schemaNames = schemaMap.keySet();

        final ArgumentParser codegenParser = ArgumentParsers
                .newFor(OpenApiConverter.class.toString()).build();
        final Subparsers subparsers = codegenParser.addSubparsers()
                .title("commands")
                .help("additional help")
                .metavar("Command");

        final Map<String, Schema> commandMap = new HashMap<>();
        List<CodegenArgument> codegenArguments = null;
        for (String schemaName : schemaNames) {
            final Schema schema = schemaMap.get(schemaName);
            final String command = CLIHelper.getCommand(schemaName, schema);
            final Map<String, Schema> schemaProperties = schema.getProperties();
            final Subparser parser = subparsers.addParser(command).help(command);

            commandMap.put(command, schema);

            if (schemaProperties == null || schemaProperties.isEmpty()) {
                LOGGER.debug(String.format("there are not options for command '%s'", command));
                continue;
            }
            for (String propertyName : schemaProperties.keySet()) {
                final Schema property = schemaProperties.get(propertyName);
                final Map<String, Object> extensions = property.getExtensions();
                if (!CLIHelper.containsOptionExtensions(extensions)) {
                    LOGGER.warn(String.format("there are not option extensions for property '%s?",
                            propertyName));
                    continue;
                }
                String[] arguments = CLIHelper.getArguments(extensions);
                final Argument argument = parser.addArgument(arguments)
                        .type(CLIHelper.getClass(property))
                        .help(property.getDescription())
                        .metavar(StringUtils.EMPTY);

                if (property instanceof BooleanSchema) {
                    argument.nargs("?").setConst(true);
                } else if (property instanceof ArraySchema) {
                    argument.nargs("*");
                }
            }
            codegenArguments = getCodegenArgs(command, parser, args);
        }
        final Map<String, Object> inputArgs = new HashMap<>();
        try {
            codegenParser.parseArgs(args, inputArgs);
        } catch (ArgumentParserException e) {
            LOGGER.error(String.format("Problem: ", e.getLocalizedMessage()));
            //codegenParser.handleError(e);
            return;
        }
        final String userInputCommand = CLIHelper.detectCommand(args);
        if (userInputCommand == null) {
            LOGGER.error("No command found.");
            return;
        }
        final Schema commandSchema = commandMap.get(userInputCommand);
        if (commandSchema == null) {
            LOGGER.error(String.format("There are not schema related to command '%s'",
                    userInputCommand));
            return;
        }
        final Map<String, Object> extensions = commandSchema.getExtensions();
        if (extensions == null || extensions.isEmpty() || extensions.get("x-class-name") == null) {
            LOGGER.error("Extensions are required to run command. i.e: 'x-class-name'");
            return;
        }
        final String className = extensions.get("x-class-name").toString();
        try {
            final Class clazz = Class.forName(className);
            final Object commandObject = clazz.newInstance();
            final Map<String, Object> optionValueMap = CLIHelper
                    .createOptionValueMap(commandSchema, inputArgs);

            BeanUtils.populate(commandObject, optionValueMap);

            if (codegenArguments != null && !codegenArguments.isEmpty()
                    && commandObject instanceof Generate) {
                codegenArguments = codegenArguments.stream()
                        .filter(codegenArgument -> {
                            final String option = CLIHelper
                                    .fixOptionName(codegenArgument.getOption());
                            final String optionValue = String.valueOf(inputArgs.get(option));

                            if (StringUtils.isNotBlank(optionValue) && !"null"
                                    .equalsIgnoreCase(optionValue)) {
                                codegenArgument.setValue(optionValue);
                                return true;
                            } else {
                                return false;
                            }
                        })
                        .collect(Collectors.toList());

                Generate generateCommand = (Generate) commandObject;
                generateCommand.setCodegenArguments(codegenArguments);
            }

            if (commandObject instanceof Runnable) {
                //  new Thread(((Runnable) commandObject)).start();
                ((Runnable) commandObject).run(); //keep it synchronous
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            LOGGER.error(String.format("Could not load class '%s' for command '%s'", className,
                    userInputCommand), ex);
        }
    }

    private List<CodegenArgument> getCodegenArgs(String command, Subparser parser, String[] args) {
        List<CodegenArgument> codegenArguments = null;
        if (command.equalsIgnoreCase(GENERATE_COMMAND_NAME)) {
            String language = CLIHelper.detectlanguage(args);
            if (StringUtils.isNotBlank(language)) {
                final CodegenConfig config = CodegenConfigLoader.forName(language);
                codegenArguments = config.readLanguageArguments();
                if (codegenArguments != null && !codegenArguments.isEmpty()) {
                    for (final CodegenArgument codegenArgument : codegenArguments) {
                        final String[] arguments = CLIHelper.getArguments(codegenArgument);
                        final boolean isBoolean = "boolean"
                                .equalsIgnoreCase(codegenArgument.getType());
                        Class clazz = isBoolean ? Boolean.class : String.class;
                        final Argument argument = parser.addArgument(arguments)
                                .type(clazz)
                                .help(codegenArgument.getDescription())
                                .metavar(StringUtils.EMPTY);
                        if (isBoolean) {
                            argument.nargs("?").setConst(true);
                        } else {
                            final Boolean codeGenArray = codegenArgument.getArray();
                            if (codeGenArray != null && codeGenArray) {
                                argument.nargs("*");
                            }
                        }
                    }
                }
            }
        }
        return codegenArguments;
    }
}

