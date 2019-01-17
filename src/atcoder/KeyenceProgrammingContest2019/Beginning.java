package atcoder.KeyenceProgrammingContest2019;

import java.util.TreeSet;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.Scanner;

public class Beginning {
    public static void main(String[] args) {
        SortedSet<Integer> k = new TreeSet<>(Arrays.asList(1, 4, 7, 9));
        SortedSet<Integer> m = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int z = sc.nextInt();
            if (k.contains(z)) {
                m.add(z);
            }
        }
        if (m.toArray().length == 4) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
