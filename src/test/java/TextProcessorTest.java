

import org.example.Config;
import org.example.TextProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void givenShiftAlgorithm_whenEncrypting_thenShiftsCharacters() {
        Config config = new Config();
        config = Config.parseArgs(new String[]{"-mode", "enc", "-key", "3", "-alg", "shift"});
        String result = TextProcessor.process("abc", config);
        assertEquals("def", result);
    }

    @Test
    void givenShiftAlgorithm_whenDecrypting_thenShiftsCharactersBack() {
        Config config = new Config();
        config = Config.parseArgs(new String[]{"-mode", "dec", "-key", "3", "-alg", "shift"});
        String result = TextProcessor.process("def", config);
        assertEquals("abc", result);
    }

    @Test
    void givenUnicodeAlgorithm_whenEncrypting_thenAppliesUnicodeShift() {
        Config config = new Config();
        config = Config.parseArgs(new String[]{"-mode", "enc", "-key", "5", "-alg", "unicode"});
        String result = TextProcessor.process("abc", config);
        assertEquals("fgh", result);
    }

    @Test
    void givenUnicodeAlgorithm_whenDecrypting_thenReversesUnicodeShift() {
        Config config = new Config();
        config = Config.parseArgs(new String[]{"-mode", "dec", "-key", "5", "-alg", "unicode"});
        String result = TextProcessor.process("fgh", config);
        assertEquals("abc", result);
    }

    @Test
    void givenNonAlphabeticCharacters_whenProcessing_thenIgnoresThem() {
        Config config = new Config();
        config = Config.parseArgs(new String[]{"-mode", "enc", "-key", "3", "-alg", "shift"});
        String result = TextProcessor.process("a!b.c", config);
        assertEquals("d!e.f", result);
    }
}
