package uk.gov.ch.args;

import java.util.*;

class ArgParser {
    private final Map<String, List<String>> params = new HashMap<>();

    ArgParser(final String[] args) {
        String key = null;
        for (final String arg : args) {
            if (arg.startsWith("-")) {
                key = arg;
                params.computeIfAbsent(key, k -> new ArrayList<>());
            } else {
                params.compute(key, (k, v) -> {
                    if (v == null) {
                        return Collections.singletonList(arg);
                    } else {
                        v.add(arg);
                        return v;
                    }
                });
            }
        }
    }

    List<String> get(final String key) {
        return params.get(key);
    }

    boolean has(final String key) {
        return params.containsKey(key);
    }

    boolean hasAny() {
        return params.size() != 0;
    }
}