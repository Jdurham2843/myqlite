package com.jdurham;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseSelectStatement() {
        final String selectStatementStr = "SELECT id FROM my_table;";
        final Lexer lexer = new Lexer(selectStatementStr);
        final List<Token> tokens = lexer.scan();
        final Parser parser = new Parser(tokens);
        final Statement statement = parser.parse();

        assertInstanceOf(SelectStatement.class, statement);
        final SelectStatement selectStatement = (SelectStatement) statement;
        assertEquals(1, selectStatement.columns().size());
        assertEquals("id", selectStatement.columns().getFirst());
        assertEquals("my_table", selectStatement.tableName());
    }
}