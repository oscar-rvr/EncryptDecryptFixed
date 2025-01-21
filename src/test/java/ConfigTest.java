import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Config;

class ConfigTest {

    @Test
    void givenValidArgs_whenParseArgs_thenFieldsAreCorrectlySet() {
        String[] args = {"-mode", "dec", "-key", "5", "-data", "test", "-alg", "shift"};
        Config config = Config.parseArgs(args);

        assertEquals("dec", config.getMode());
        assertEquals(5, config.getKey());
        assertEquals("test", config.getData());
        assertEquals("shift", config.getAlg());
    }

    @Test
    void givenIncompleteArgs_whenParseArgs_thenDefaultValuesAreSet() {
        String[] args = {"-mode", "dec"};
        Config config = Config.parseArgs(args);

        assertEquals("dec", config.getMode());
        assertEquals(0, config.getKey());
        assertEquals("", config.getData());
        assertEquals("shift", config.getAlg());
    }

    @Test
    void givenNoArgs_whenParseArgs_thenDefaultsAreSet() {
        String[] args = {};
        Config config = Config.parseArgs(args);

        assertEquals("enc", config.getMode());
        assertEquals(0, config.getKey());
        assertEquals("", config.getData());
        assertEquals("shift", config.getAlg());
    }
}
