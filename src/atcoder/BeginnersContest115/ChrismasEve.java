package atcoder.BeginnersContest115;

import java.util.Scanner;

public class ChrismasEve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("input a number: ");
        int d = sc.nextInt();

        String result = "Christmas";
        for (int i = 24; i >= d && i>=22; i--) {
            result += " Eve";
        }
        System.out.println(result);
    }
}
