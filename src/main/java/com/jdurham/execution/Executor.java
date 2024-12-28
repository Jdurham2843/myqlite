package com.jdurham.execution;

import com.jdurham.parsing.SelectStatement;
import com.jdurham.parsing.Statement;
import com.jdurham.storage.Row;
import com.jdurham.storage.TableManager;

import java.util.List;

public class Executor {

    private final TableManager tableManager = new TableManager();

    public List<Row> execute(Statement statement) {
        List<Row> rows = switch (statement) {
            case SelectStatement select -> executeSelect(select);
        };

        return rows;
    }

    private List<Row> executeSelect(SelectStatement select) {
        final String tableName = select.tableName();
        final List<Row> table = tableManager.fetchTable(tableName);

        return table;
    }
}
