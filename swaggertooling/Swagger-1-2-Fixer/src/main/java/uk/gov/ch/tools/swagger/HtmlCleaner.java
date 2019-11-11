package uk.gov.ch.tools.swagger;

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HtmlCleaner {

    private static Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
    /**
     * Map of lower case tags to functions that can process them for replacements
     */
    private static Map<String, UnaryOperator<String>> tagHandlers;

    static {
        tagHandlers = new TreeMap<>();
        tagHandlers.put("<code", HtmlCleaner::codeReplacement);
        tagHandlers.put("</code", HtmlCleaner::codeReplacement);
        tagHandlers.put("<a ", HtmlCleaner::hrefReplacement);
    }

    /**
     * Extract an href from an &lta tag and replace it with the href in markdown
     */
    private static String hrefReplacement(final String tagString) {
        String result = "";
        Matcher hrefMatch = hrefPattern.matcher(tagString);
        if (hrefMatch.find()) {
            result = hrefMatch.group(1);
            if (!result.isEmpty()) {
                result = "[" + result + "](" + result + ")";
            }
        }
        return result;
    }

    /**
     * Provide the markdown equivalent
     */
    private static String codeReplacement(final String tag) {
        return "`";
    }

    String removeHtml(final String originalValue) {

        String newValue = originalValue;
        String oldValue;
        do {
            oldValue = newValue;
            newValue = remove1Tag(newValue);
        } while ((!newValue.equals(oldValue)));
        return newValue;
    }

    private String remove1Tag(final String originalValue) {
        String result = originalValue;
        final int openIndex = originalValue.indexOf("<");
        if (openIndex >= 0) {
            final StringBuilder buffer = new StringBuilder(originalValue);
            final int closeIndex = buffer.indexOf(">", openIndex);
            if (closeIndex >= 0) {
                final String tag = buffer.substring(openIndex, closeIndex + 1);
                buffer.replace(openIndex, closeIndex + 1, tagReplacement(tag));
            }
            result = buffer.toString();
        }
        return result;
    }

    private String tagReplacement(final String tag) {
        String replacement = "";
        final String lowerTag = tag.toLowerCase(Locale.ROOT);
        final Optional<UnaryOperator<String>> handler = tagHandlers.entrySet().stream()
                .filter(entry -> lowerTag.startsWith(entry.getKey()))
                .map(Entry::getValue)
                .findFirst();
        if (handler.isPresent()) {
            replacement = handler.get().apply(tag);
        }
        return replacement;
    }
}
