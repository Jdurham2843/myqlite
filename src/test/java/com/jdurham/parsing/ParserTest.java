package com.jdurham.parsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ParserTest {

    @Test
    void parseSelectStatement() {
        final String selectStatementStr = "SELECT id FROM my_table;";
        final Parser parser = Parser.build(selectStatementStr);
        final Statement statement = parser.parse();

        assertInstanceOf(SelectStatement.class, statement);
        final SelectStatement selectStatement = (SelectStatement) statement;
        assertEquals(1, selectStatement.columns().size());
        assertEquals("id", selectStatement.columns().getFirst());
        assertEquals("my_table", selectStatement.tableName());
    }
}