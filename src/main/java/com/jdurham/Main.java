package com.jdurham;

import com.jdurham.parsing.Parser;
import com.jdurham.parsing.Statement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mqlite startup preamble");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            final String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("See ya!");
                break;
            }

            final Parser parser = Parser.build(input);
            final Statement statement = parser.parse();
            System.out.println(statement);
        }
    }
}