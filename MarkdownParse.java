// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        //this is a comment
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            // Fixes when there are no links in the .md file as the indexOf() method returns -1
            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1) break;
            int counter = 0;
            for (int i = openParen; i < closeParen; i++){
                if (markdown.charAt(i) == '\n'){
                    counter += 1;
                }
            }
            if (counter > 1){currentIndex = closeParen + 1; continue;}
            // Doesn't consider images or links that have text in between brackets and paren
            // Allows closed bracket ']' in between ] and ()
            if(nextOpenBracket == 0 || markdown.charAt(nextOpenBracket-1) != '!' && markdown.charAt(openParen - 1) == ']') {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}