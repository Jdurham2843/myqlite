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
        while (currentCharOpt.isPresent()) {
            final StringBuilder lexemeBuilder = new StringBuilder();
            char currentChar = currentCharOpt.get();

            switch (currentChar) {
                case ' ':
                    tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                    break;
                case ';':
                    tokens.add(new Token(Token.TokenType.IDENTIFIER, lexemeBuilder.toString()));
                    tokens.add(new Token(Token.TokenType.SEMICOLON, ";"));
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
