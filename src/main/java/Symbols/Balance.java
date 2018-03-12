package Symbols;

import CustomTypes.HANStack;

import java.io.Reader;

public class Balance {
    private static final String EXTRANEOUS_ERROR = "Extraneous %c at line %d";
    private static final String UNMATCHED_ERROR = "Unmatched %c at line %d";

    public Balance(Reader inStream) {
        errors = 0;
        tok = new Tokenizer(inStream);
    }

    public int checkBalance() {
        char currentChar;
        Symbol match = null;
        HANStack<Symbol> pendingTokens = new HANStack<Symbol>();

        while ((currentChar = tok.getNextOpenClose()) != '\0') {
            Symbol lastSymbol = new Symbol(currentChar, tok.getLineNumber());

            switch (currentChar) {
                case '(':
                case '[':
                case '{':
                    pendingTokens.push(lastSymbol);
                    break;

                case ')':
                case ']':
                case '}':
                    if (pendingTokens.isEmpty()) {
                        errors++;
                        System.out.println(String.format(EXTRANEOUS_ERROR, currentChar, tok.getLineNumber()));
                    } else {
                        match = pendingTokens.pop();
                        checkMatch(match, lastSymbol);
                    }
                    break;

                default:
                    break; // Cannot happen
            }
        }

        while (!pendingTokens.isEmpty()) {
            match = pendingTokens.pop();
            System.out.println(String.format(UNMATCHED_ERROR, match.token, match.line));

            errors++;
        }

        return errors + tok.getErrorCount();
    }

    @Override
    public String toString() {
        return tok.toString();
    }

    private Tokenizer tok;
    private int errors;

    private static class Symbol {
        public char token;
        public int line;

        public Symbol(char token, int line) {
            this.token = token;
            this.line = line;
        }
    }

    private void checkMatch(Symbol openSymbol, Symbol closeSym) {
        if (hasNoCloseSymbol(openSymbol, closeSym)) {
            System.out.println(String.format(
                    "Found %c on line %d; does not match %c on line %d",
                    openSymbol.token,
                    openSymbol.line,
                    closeSym.token,
                    closeSym.line));

            errors++;
        }
    }

    private boolean hasNoCloseSymbol(Symbol openSymbol, Symbol closeSymbol) {
        return openSymbol.token == '(' && closeSymbol.token != ')' ||
                openSymbol.token == '[' && closeSymbol.token != ']' ||
                openSymbol.token == '{' && closeSymbol.token != '}';
    }
}