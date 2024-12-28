package com.jdurham.storage;

import java.util.Map;

public record Row(long rowId, Map<String, String> data) {
}
