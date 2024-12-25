package com.jdurham;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Test
    void scanSelectStatement() {
        final String selectStatement = "SELECT * FROM my_table;";

        final Lexer lexer = new Lexer(selectStatement);
        final List<Token> tokens = lexer.scan();

        assertEquals(5, tokens.size());
        assertEquals(4, tokens.stream().filter(token -> token.tokenType() == Token.TokenType.IDENTIFIER).count());
        assertEquals(Token.TokenType.SEMICOLON, tokens.getLast().tokenType());
    }

}