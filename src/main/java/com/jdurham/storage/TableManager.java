package com.jdurham.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableManager {
    private final Map<String, List<Row>> tables = new HashMap<>();

    public TableManager() {
        tables.put("my_table", List.of(
                new Row(1, Map.ofEntries(Map.entry("id", "1"), Map.entry("age", "27")))
        ));
    }

    public List<Row> fetchTable(String tableName) {
        return tables.get(tableName);
    }
}
