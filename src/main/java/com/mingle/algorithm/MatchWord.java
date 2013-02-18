package com.mingle.algorithm;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * User: mingle
 * Date: 12-11-27
 * Time: 下午11:13
 * desc
 */
public class MatchWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hashtable<String, String> table = new Hashtable<String, String>();
        String input;
        String[] array = new String[2];
        while (in.hasNext()) {
            input = in.nextLine();
            if (input.length() == 0) break;
            array = input.split(" ");
            table.put(array[1], array[0]);
        }
        while (in.hasNext()) {
            input = in.nextLine();
            if (table.get(input) != null) System.out.println(table.get(input));
            else System.out.println("eh");
        }
    }
}
/*
Sample Input

dog ogday
cat atcay
pig igpay
froot ootfray
loops oopslay

atcay
ittenkay
oopslay


Sample Output

cat
eh
loops
*/