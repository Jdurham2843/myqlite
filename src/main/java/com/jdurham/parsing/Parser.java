package com.jdurham.parsing;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int cursor = -1;

    public static Parser build(String input) {
        final Lexer lexer = new Lexer(input);
        return new Parser(lexer.scan());
    }

    private Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Statement parse() {
        final Token initialToken = next();
        Statement statement = null;

        switch (initialToken.lexeme()) {
            case "SELECT":
            case "select":
            case "Select":
                statement = parseSelect();
                break;
            default:
                break;
        }

        return statement;
    }

    private SelectStatement parseSelect() {
        final List<String> columns = new ArrayList<>();

        Token nextToken = next();
        while (!nextToken.lexeme().equalsIgnoreCase("from")) {
            columns.add(nextToken.lexeme());
            nextToken = next();
        }

        nextToken = next();

        final String tableName = nextToken.lexeme();

        // consume semicolon
        next();

        return new SelectStatement(columns, tableName);
    }

    private Token next() {
        cursor++;

        return tokens.get(cursor);
    }
}
