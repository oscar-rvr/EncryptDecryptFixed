

import org.example.FileManager;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private static final String TEST_FILE = "testFile.txt";
    private static final String CONTENT = "Hello, World!";
    private static final String NON_EXISTENT_FILE = "nonexistent.txt";

    @BeforeEach
    void setup() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write(CONTENT);
        }
    }

    @AfterEach
    void teardown() {
        new File(TEST_FILE).delete();
    }

    @Test
    void givenExistingFile_whenReadFile_thenReturnsContent() {
        String result = FileManager.readFile(TEST_FILE);
        assertEquals(CONTENT, result);
    }

    @Test
    void givenNonExistentFile_whenReadFile_thenReturnsNull() {
        String result = FileManager.readFile(NON_EXISTENT_FILE);
        assertNull(result);
    }

    @Test
    void givenContent_whenWriteFile_thenCreatesFileWithContent() {
        String newContent = "New content";
        FileManager.writeFile(TEST_FILE, newContent);
        String result = FileManager.readFile(TEST_FILE);
        assertEquals(newContent, result);
    }

    @Test
    void givenNonWritableLocation_whenWriteFile_thenHandlesErrorGracefully() {
        // On most systems, the root directory is non-writable for users
        String rootFile = "/nonwritable.txt";
        FileManager.writeFile(rootFile, CONTENT);
        assertNull(FileManager.readFile(rootFile));
    }
}
