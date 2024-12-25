package com.jdurham;

public record Token(TokenType tokenType, String lexeme) {

    enum TokenType {
        IDENTIFIER,
        SEMICOLON,
        OPEN_PARENTHESES,
        CLOSE_PARENTHESES,
        COMMA,
        ;
    }
}
