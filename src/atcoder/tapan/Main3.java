import java.util.*;

public class Main2 {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] nums = new int[n];
        HashMap<int, int> hmap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();

            if(max <= nums[i])
                max = i;

            if(i%l==0){
                max =
            }

        }

    }
}