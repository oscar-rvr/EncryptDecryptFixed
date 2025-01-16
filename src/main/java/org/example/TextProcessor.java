package org.example;

public class TextProcessor {

    public static String process(String message, Config config) {
        boolean isShift = config.getAlg().equals("shift");
        boolean isEncrypt = config.getMode().equals("enc");
        int key = isEncrypt ? config.getKey() : -config.getKey();

        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            result.append(isShift ? processShift(c, key) : processUnicode(c, key));
        }
        return result.toString();
    }

    private static char processShift(char c, int key) {
        if (Character.isLetter(c)) {
            int base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (base + (c - base + key + 26) % 26);
        }
        return c;
    }

    private static char processUnicode(char c, int key) {
        return (char) (c + key);
    }
}
