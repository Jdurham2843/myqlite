package com.jdurham;

import com.jdurham.execution.Executor;
import com.jdurham.parsing.Parser;
import com.jdurham.parsing.Statement;
import com.jdurham.storage.Row;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mqlite startup preamble");
        Scanner scanner = new Scanner(System.in);

        final Executor executor = new Executor();

        while (true) {
            System.out.print("> ");
            final String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("See ya!");
                break;
            }

            final Parser parser = Parser.build(input);
            final Statement statement = parser.parse();

            final List<Row> rows = executor.execute(statement);

            for (final Row row : rows) {
                System.out.println(row);
            }
        }
    }
}