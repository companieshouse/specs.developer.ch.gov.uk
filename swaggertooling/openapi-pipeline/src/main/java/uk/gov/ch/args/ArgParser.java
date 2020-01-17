package uk.gov.ch.args;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArgParser {

    private final Map<String, List<String>> params = new HashMap<>();

    ArgParser(final String[] args) {
        String key = null;
        for (final String arg : args) {
            if (arg.startsWith("-")) {
                key = arg;
                params.computeIfAbsent(key, k -> new ArrayList<>());
            } else {
                params.compute(key, (k, v) -> appendToArgs(arg, v));
            }
        }
    }

    private List<String> appendToArgs(String arg, List<String> v) {
        List<String> result;
        if (v == null) {
            result = Collections.singletonList(arg);
        } else {
            v.add(arg);
            result = v;
        }
        return result;
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