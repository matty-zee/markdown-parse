import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./test-file3.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile4() throws IOException {
        String contents= Files.readString(Path.of("./test-file4.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile5() throws IOException {
        String contents= Files.readString(Path.of("./test-file5.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile6() throws IOException {
        String contents= Files.readString(Path.of("./test-file6.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }


    @Test
    public void testFile7() throws IOException {
        String contents= Files.readString(Path.of("./test-file7.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile8() throws IOException {
        String contents= Files.readString(Path.of("./test-file8.md"));
        List<String> expect = List.of("a link on the first line");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile9() throws IOException {
        String contents= Files.readString(Path.of("./testFail.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet1() throws IOException {
        String contents= Files.readString(Path.of("./snippet1.md"));
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        String contents= Files.readString(Path.of("./snippet2.md"));
        List<String> expect = List.of("a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        String contents= Files.readString(Path.of("./snippet3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}

    
