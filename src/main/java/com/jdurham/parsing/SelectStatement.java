package com.jdurham.parsing;

import java.util.List;

public record SelectStatement(List<String> columns, String tableName) implements Statement {
}
