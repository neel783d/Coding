package atcoder.KeyenceProgrammingContest2019;

import java.util.Scanner;

public class Keyence_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        char[] target = "keyence".toCharArray();

        int i = 0;
        int j = 0;
        int gap = 0;
        int prev = -1;

        // Alignment
        while (i < str.length && str[i] != target[j]) {
            i++;
        }

        while (i < str.length) {
            if (j == target.length) {
                break;
            }
            else if (str[i] == target[j]) {
                i++;
                j++;
            } else if (i < str.length && gap == 0 && str[i] != target[j]) {
                prev = i;
                while (i < str.length && str[i] != target[j]) {
                    i++;
                }
                gap = 1;
            } else if (i < str.length && gap == 1 && str[i] != target[j]) {
                // j=0;
                gap = 0;
                // i = prev;
            }
        }
        if (j == target.length) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
