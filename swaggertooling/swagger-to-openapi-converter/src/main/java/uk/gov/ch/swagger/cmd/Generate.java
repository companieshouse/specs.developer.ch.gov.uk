package uk.gov.ch.swagger.cmd;

import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyAdditionalPropertiesKvpList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyImportMappingsKvpList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyInstantiationTypesKvpList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyLanguageSpecificPrimitivesCsvList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyReservedWordsMappingsKvpList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applySystemPropertiesKvpList;
import static io.swagger.codegen.v3.config.CodegenConfiguratorUtils.applyTypeMappingsKvpList;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static uk.gov.ch.swagger.CLIHelper.isValidJson;
import static uk.gov.ch.swagger.CLIHelper.isValidURL;
import static uk.gov.ch.swagger.CLIHelper.isValidYaml;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.codegen.v3.ClientOptInput;
import io.swagger.codegen.v3.CodegenArgument;
import io.swagger.codegen.v3.CodegenConstants;
import io.swagger.codegen.v3.DefaultGenerator;
import io.swagger.codegen.v3.config.CodegenConfigurator;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.parser.util.RemoteUrl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.swagger.CLIHelper;

/**
 * Based on an original class in the swagger-codegen CLI There is some redundancy left over from
 * that, but as a component of a self-deprecating tool this this is not important.
 */

public class Generate implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Generate.class);

    private Boolean verbose;
    private String lang;
    private String spec;
    private String templateDir;
    private String templateVersion;
    private String templateEngine;
    private String auth;
    private List<String> systemProperties = new ArrayList<>();
    private String configFile;
    private Boolean skipOverwrite;
    private String apiPackage;
    private String modelPackage;
    private String modelNamePrefix;
    private String modelNameSuffix;
    private List<String> instantiationTypes = new ArrayList<>();
    private List<String> typeMappings = new ArrayList<>();
    private List<String> additionalProperties = new ArrayList<>();
    private List<String> languageSpecificPrimitives = new ArrayList<>();
    private List<String> importMappings = new ArrayList<>();
    private String invokerPackage;
    private String groupId;
    private String artifactId;
    private String artifactVersion;
    private String library;
    private String gitUserId;
    private String gitRepoId;
    private String releaseNote;
    private String httpUserAgent;
    private List<String> reservedWordsMappings = new ArrayList<>();
    private String ignoreFileOverride;
    private Boolean removeOperationIdPrefix;
    private Boolean disableExamples;
    private String url;
    private List<CodegenArgument> codegenArguments;

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setCodegenArguments(List<CodegenArgument> codegenArguments) {
        this.codegenArguments = codegenArguments;
    }

    @Override
    public void run() {

        loadArguments();

        // attempt to read from config file
        CodegenConfigurator configurator = CodegenConfigurator.fromFile(configFile);

        // if a config file wasn't specified or we were unable to read it
        if (configurator == null) {
            // create a fresh configurator
            configurator = new CodegenConfigurator();
        }

        // now override with any specified parameters
        if (verbose != null) {
            configurator.setVerbose(verbose);
        }

        if (skipOverwrite != null) {
            configurator.setSkipOverwrite(skipOverwrite);
        }

        if (isNotEmpty(spec)) {
            configurator.setInputSpecURL(spec);
        }

        if (isNotEmpty(lang)) {
            configurator.setLang(lang);
        }

        String output = "";
        if (isNotEmpty(output)) {
            configurator.setOutputDir(output);
        }

        if (isNotEmpty(auth)) {
            configurator.setAuth(auth);
        }

        if (isNotEmpty(templateDir)) {
            configurator.setTemplateDir(templateDir);
        }

        if (isNotEmpty(templateVersion)) {
            configurator.setTemplateVersion(templateVersion);
        }

        if (isNotEmpty(apiPackage)) {
            configurator.setApiPackage(apiPackage);
        }

        if (isNotEmpty(modelPackage)) {
            configurator.setModelPackage(modelPackage);
        }

        if (isNotEmpty(modelNamePrefix)) {
            configurator.setModelNamePrefix(modelNamePrefix);
        }

        if (isNotEmpty(modelNameSuffix)) {
            configurator.setModelNameSuffix(modelNameSuffix);
        }

        if (isNotEmpty(invokerPackage)) {
            configurator.setInvokerPackage(invokerPackage);
        }

        if (isNotEmpty(groupId)) {
            configurator.setGroupId(groupId);
        }

        if (isNotEmpty(artifactId)) {
            configurator.setArtifactId(artifactId);
        }

        if (isNotEmpty(artifactVersion)) {
            configurator.setArtifactVersion(artifactVersion);
        }

        if (isNotEmpty(library)) {
            configurator.setLibrary(library);
        }

        if (isNotEmpty(gitUserId)) {
            configurator.setGitUserId(gitUserId);
        }

        if (isNotEmpty(gitRepoId)) {
            configurator.setGitRepoId(gitRepoId);
        }

        if (isNotEmpty(releaseNote)) {
            configurator.setReleaseNote(releaseNote);
        }

        if (isNotEmpty(httpUserAgent)) {
            configurator.setHttpUserAgent(httpUserAgent);
        }

        if (isNotEmpty(ignoreFileOverride)) {
            configurator.setIgnoreFileOverride(ignoreFileOverride);
        }

        if (removeOperationIdPrefix != null) {
            configurator.setRemoveOperationIdPrefix(removeOperationIdPrefix);
        }

        if (codegenArguments != null && !codegenArguments.isEmpty()) {
            configurator.setCodegenArguments(codegenArguments);
        }

        if (disableExamples != null && disableExamples) {
            additionalProperties.add(String
                    .format("%s=%s", CodegenConstants.DISABLE_EXAMPLES_OPTION,
                            disableExamples.toString()));
        }

        if (CodegenConstants.MUSTACHE_TEMPLATE_ENGINE.equalsIgnoreCase(templateEngine)) {
            additionalProperties.add(String.format("%s=%s", CodegenConstants.TEMPLATE_ENGINE,
                    CodegenConstants.MUSTACHE_TEMPLATE_ENGINE));
        } else {
            additionalProperties.add(String.format("%s=%s", CodegenConstants.TEMPLATE_ENGINE,
                    CodegenConstants.HANDLEBARS_TEMPLATE_ENGINE));
        }

        applySystemPropertiesKvpList(systemProperties, configurator);
        applyInstantiationTypesKvpList(instantiationTypes, configurator);
        applyImportMappingsKvpList(importMappings, configurator);
        applyTypeMappingsKvpList(typeMappings, configurator);
        applyAdditionalPropertiesKvpList(additionalProperties, configurator);
        applyLanguageSpecificPrimitivesCsvList(languageSpecificPrimitives, configurator);
        applyReservedWordsMappingsKvpList(reservedWordsMappings, configurator);
        final ClientOptInput clientOptInput = configurator.toClientOptInput();

        new DefaultGenerator().opts(clientOptInput).generate();
    }

    private void loadArguments() {
        if (StringUtils.isBlank(this.url)) {
            return;
        }
        final String content;
        File file = new File(this.url);
        if (file.exists() && file.isFile()) {
            try {
                content = FileUtils.readFileToString(file);
            } catch (IOException e) {
                LOG.error("Unable to read file: " + this.url, e);
                return;
            }
        } else if (isValidURL(this.url)) {
            try {
                content = RemoteUrl.urlToString(this.url, null);
            } catch (Exception e) {
                LOG.error("Unable to read url: " + this.url, e);
                return;
            }
        } else {
            return;
        }

        if (StringUtils.isBlank(content)) {
            return;
        }

        JsonNode node = null;

        if (isValidJson(content)) {
            try {
                node = Json.mapper().readTree(content.getBytes());
            } catch (IOException e) {
                LOG.error("Unable to deserialize json from: " + this.url, e);
                node = null;
            }
        } else if (isValidYaml(content)) {
            try {
                node = Yaml.mapper().readTree(content.getBytes());
            } catch (IOException e) {
                LOG.error("Unable to deserialize yaml from: " + this.url, e);
                node = null;
            }
        }

        if (node == null) {
            return;
        }

        final Map<String, Object> optionValueMap = CLIHelper.createOptionValueMap(node);
        try {
            BeanUtils.populate(this, optionValueMap);
        } catch (Exception e) {
            LOG.error("Error setting values to object.", e);
        }
    }

    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }
}
