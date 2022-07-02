package IrregularExpressions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyFirstJUnitJupiterTests {

    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    private final static PrintStream originalErr = System.err;



    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test() throws IOException {
        Solution.main(null);
        File file = new File("/home/mark/IdeaProjects/GoogleKickStart/src/BuildingPalindromes/output.txt");
        byte[] b = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream expectedOutContent = new ByteArrayOutputStream();
        PrintStream expectedOut = new PrintStream(expectedOutContent);
        fileInputStream.read(b);
        for (int i = 0; i < b.length; i++) {
            expectedOut.print((char) b[i]);
        }
        assertEquals(expectedOutContent.toString(), outContent.toString());
    }

}