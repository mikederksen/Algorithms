package Symbols;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

public class Tokenizer {
    public Tokenizer(Reader inStream) {
        numOfErrors = 0;
        currentChar = '\0';
        currentLine = 1;
        inputStream = new PushbackReader(inStream);
    }

    private static final int SLASH_SLASH = 0;
    private static final int SLASH_STAR = 1;
    private static final char NEW_LINE = '\n';

    private PushbackReader inputStream;
    private char currentChar;
    private int currentLine;
    private int numOfErrors;

    public int getLineNumber() {
        return currentLine;
    }

    public int getErrorCount() {
        return numOfErrors;
    }

    public char getNextOpenClose() {
        while (nextChar()) {
            if (currentChar == '/') {
                processSlash();
            } else if (currentChar == '\'' || currentChar == '"') {
                skipQuote(currentChar);
            } else if (currentChar == '(' || currentChar == '[' || currentChar == '{' ||
                    currentChar == ')' || currentChar == ']' || currentChar == '}') {
                return currentChar;
            }
        }

        return '\0';
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        while (nextChar()) {
            result.append(currentChar);
        }

        inputStream = new PushbackReader(new StringReader(result.toString())); // Niet de mooiste manier, werkt voor nu.

        return result.toString();
    }

    //public char getNextID() {
        /* Figure 12.29 */
    //}

    private boolean nextChar() {
        try {
            int currentCharValue = inputStream.read();

            if (currentCharValue == -1) {
                return false;
            }

            currentChar = (char) currentCharValue;

            if (currentChar == NEW_LINE) {
                currentLine++;
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void putBackChar() {
        if (currentChar == NEW_LINE) {
            currentLine--;
        }

        try {
            inputStream.unread((int) currentChar);
        } catch (IOException e) {
            // Swallow
        }
    }

    private void skipComment(int start) {
        if (start == SLASH_SLASH) {
            while (nextChar() && (currentChar != '\n'))
                ;

            return;
        }

        boolean state = false;

        while (nextChar()) {
            if (state && currentChar == '/') {
                return;
            }

            state = currentChar == '*';
        }

        numOfErrors++;

        System.out.println("Unterminated comment!");
    }

    private void skipQuote(char quoteType) {
        while (nextChar()) {
            if (currentChar == quoteType) {
                return;
            }

            if (currentChar == NEW_LINE) {
                numOfErrors++;
                System.out.println(String.format(
                        "Missing closed quote at line %s",
                        currentLine));
            } else if (currentChar == '\\') {
                nextChar();
            }
        }
    }

    private void processSlash() {
        if (nextChar()) {
            if (currentChar == '*') {
                if (nextChar() && currentChar != '*') {
                    putBackChar();
                }

                skipComment(SLASH_STAR);
            } else if (currentChar == '/') {
                skipComment(SLASH_SLASH);
            } else if (currentChar != NEW_LINE) {
                putBackChar();
            }
        }
    }

    //private static final boolean isIdChar(char ch) {
        /* Figure 12.27 */
    //}

    //private String getRemainingString() {
        /* Figure 12.28 */
    //}
}