import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.example.Config;
import org.example.FileManager;

import org.example.Main;

import org.junit.jupiter.api.Test;

class MainTest {



    @Test
    void givenNoInputData_whenRun_thenPrintErrorMessage() throws Exception {
        String[] args = {"-mode", "enc"};
        Config mockConfig = mock(Config.class);

        when(mockConfig.getData()).thenReturn("");
        when(mockConfig.getInFile()).thenReturn(null);

        String result = SystemLambda.tapSystemOutNormalized(() -> Main.main(args));

        assertTrue(result.contains("Error: No input data provided or invalid file"));
    }

@Test
void givenValidArgs_whenMainExecutedShift_thenCorrectOutputAndConfigValues() throws Exception {
    String[] args = {"-mode", "enc","-key","5","-data","welcome to hyperskill","-alg","shift"};
    Config mockConfig = mock(Config.class);
    when(mockConfig.getMode()).thenReturn("enc");
    when(mockConfig.getKey()).thenReturn(5);
    when(mockConfig.getData()).thenReturn("welcome to hyperskill");
    when(mockConfig.getAlg()).thenReturn("shift");


    String processedData = "bjqhtrj yt mdujwxpnqq";

    String result = SystemLambda.tapSystemOutNormalized(() -> Main.main(args));

    assertEquals("enc",mockConfig.getMode());
    assertEquals(5,mockConfig.getKey());
    assertEquals(result.replace("\n", ""),processedData);
    assertEquals("shift",mockConfig.getAlg());





}
@Test
void givenValidArgs_whenMainExecutedUnicode_thenCorrectOutputAndConfigValues() throws Exception {
        String[] args = {"-mode", "enc","-key","5","-data","Welcome to hyperskill!","-alg","unicode"};
        Config mockConfig = mock(Config.class);
        when(mockConfig.getMode()).thenReturn("enc");
        when(mockConfig.getKey()).thenReturn(5);
        when(mockConfig.getData()).thenReturn("Welcome to hyperskill!");
        when(mockConfig.getAlg()).thenReturn("unicode");


        String processedData = "\\jqhtrj%yt%m~ujwxpnqq&";

        String result = SystemLambda.tapSystemOutNormalized(() -> Main.main(args));

        assertEquals("enc",mockConfig.getMode());
        assertEquals(5,mockConfig.getKey());
        assertEquals(result.replace("\n", ""),processedData);
        assertEquals("unicode",mockConfig.getAlg());





    }
    @Test
    void givenNoInputFile_whenRun_thenPrintErrorMessage() throws Exception {
        String[] args = {"-mode", "enc", "-data", "test","-in","file1.txt"};
        Config mockConfig = mock(Config.class);

        when(mockConfig.getData()).thenReturn("test");
        when(mockConfig.getInFile()).thenReturn(null);

        String result = SystemLambda.tapSystemOutNormalized(() -> Main.main(args));
        String realResult = "test";

        assertEquals(realResult,result.replace("\n", ""));
    }

    @Test
    void givenEmptyDataAndInvalidFile_whenRun_thenPrintErrorMessage() throws Exception {
        String[] args = {"-mode", "enc", "-data", "", "-in", "invalid.txt"};
        Config mockConfig = mock(Config.class);

        when(mockConfig.getData()).thenReturn("");
        when(mockConfig.getInFile()).thenReturn("invalid.txt");

//        when(FileManager.readFile("invalid.txt")).thenReturn(null);

        String result = SystemLambda.tapSystemOutNormalized(() -> Main.main(args));

        assertTrue(result.contains("Error: Unable to read input file"));
        System.out.println(result);
    }

}
