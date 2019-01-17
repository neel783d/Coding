package atcoder.BeginnersContest115;

import java.util.Scanner;

public class ChristmasEveEve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("input a number: ");
        int d = sc.nextInt();
        float[] price = new float[d];
        int maxIndx = 0;
        for (int i = 0; i < d; i++) {
            price[i] = sc.nextFloat();
            if (price[maxIndx] < price[i]) {
                maxIndx = i;
            }
        }

        float sum = 0;

        for (int i = 0; i < price.length; i++) {
            sum += price[i];
        }

        sum -= price[maxIndx] / 2.0;
        if (sum % 1 == 0) {
            System.out.println(Math.round(sum));
        }
        else {
            System.out.println(sum);
        }
    }
}
