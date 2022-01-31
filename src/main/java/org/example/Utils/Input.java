package org.example.Utils;

import java.util.Locale;
import java.util.Scanner;

public class Input {

    public static String command(){

        Scanner sc = new Scanner(System.in);
        String answer;

        answer = sc.nextLine();

        return answer.trim().toUpperCase(Locale.ROOT);
    }
}
