package uk.gov.ch.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgParser {

    private Map<String, List<String>> params = new HashMap<>();

    public ArgParser(final String[] args) {
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

    public List<String> get(final String key) {
        return params.get(key);
    }

    public boolean has(final String key) {
        return params.containsKey(key);
    }

    public boolean hasAny() {
        return params.size() != 0;
    }
}
