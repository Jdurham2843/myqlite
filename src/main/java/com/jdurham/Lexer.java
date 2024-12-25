package com.jdurham;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lexer {

    private final String input;
    private int cursor = -1;
    private List<Token> tokens = new ArrayList<>();

    public Lexer(String input) {
        this.input = input.trim();
    }

    public List<Token> scan() {

        Optional<Character> currentCharOpt = next();
        StringBuilder lexemeBuilder = new StringBuilder();
        while (currentCharOpt.isPresent()) {
            char currentChar = currentCharOpt.get();

            switch (currentChar) {
                case ' ':
                    if (lexemeBuilder.length() > 0) {
                        tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                        lexemeBuilder = new StringBuilder();
                    }
                    break;
                case ';':
                    if (lexemeBuilder.length() > 0) {
                        tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                        lexemeBuilder = new StringBuilder();
                    }
                    tokens.add(new Token(Token.TokenType.SEMICOLON, ";"));
                    break;
                case '(':
                    if (lexemeBuilder.length() > 0) {
                        tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                        lexemeBuilder = new StringBuilder();
                    }
                    tokens.add(new Token(Token.TokenType.OPEN_PARENTHESES, "("));
                    break;
                case ')':
                    if (lexemeBuilder.length() > 0) {
                        tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                        lexemeBuilder = new StringBuilder();
                    }
                    tokens.add(new Token(Token.TokenType.CLOSE_PARENTHESES, ")"));
                    break;
                case ',':
                    if (lexemeBuilder.length() > 0) {
                        tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                        lexemeBuilder = new StringBuilder();
                    }
                    tokens.add(new Token(Token.TokenType.COMMA, ","));
                    break;
                default:
                    lexemeBuilder.append(currentChar);
                    break;
            }

            currentCharOpt = next();
        }


        return this.tokens;
    }

    private Optional<Character> next() {
        cursor++;
        if (cursor >= input.length()) return Optional.empty();

        return Optional.of(input.charAt(cursor));
    }

}
