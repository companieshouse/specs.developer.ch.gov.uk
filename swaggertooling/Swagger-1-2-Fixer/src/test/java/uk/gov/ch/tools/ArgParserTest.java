package uk.gov.ch.tools;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArgParserTest {

    private static final String oOpt = "-o";
    private static final String iOpt = "-i";
    private final String[] iO = {"1", iOpt, "2", "3", oOpt, "4"};
    private final String[] iValues = {"2", "3"};

    @Test
    void getI() {
        ArgParser ap = new ArgParser(iO);
        assertArrayEquals(iValues, ap.get(iOpt).toArray());
    }

    @Test
    void getX() {
        ArgParser ap = new ArgParser(iO);
        assertNull(ap.get("-x"));
    }

    @Test
    void hasO() {
        ArgParser ap = new ArgParser(iO);
        assertTrue(ap.has(oOpt));
    }

    @Test
    void hasNull() {
        ArgParser ap = new ArgParser(iO);
        assertTrue(ap.has(null));
    }

    @Test
    void hasY() {
        ArgParser ap = new ArgParser(iO);
        assertFalse(ap.has("-y"));
    }

    @Test
    void hasAnyY() {
        ArgParser ap = new ArgParser(iO);
        assertTrue(ap.hasAny());
    }

    @Test
    void hasAnyN() {
        String[] None = {};
        ArgParser ap = new ArgParser(None);
        assertFalse(ap.hasAny());
    }
}