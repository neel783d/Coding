import java.util.*;

public class Main {

    public List<Integer> dequeSolution(List<Integer> inputVal, int l) {
        if (inputVal.isEmpty() || l <= 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // Storing Max
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < inputVal.size(); i++) {

            // Remove Numbers that are not in the range
            while (!que.isEmpty() && que.peek() < i - l + 1) {
                que.poll();
            }

            // Found Smaller Values
            while (!que.isEmpty() && inputVal.get(que.peekLast()) < inputVal.get(i)) {
                que.pollLast();
            }

            // Adding to Que
            que.add(i);

            // Adding Result
            if (i >= l - 1) {
                result.add(inputVal.get(que.peek()));
            }
        }
        return result;
    }

    public static void main(String []args) {

        Main mObj =  new Main();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        List<Integer> inputVal = new ArrayList<>();

        for(int i=0; i<n; i++){
            inputVal.add(sc.nextInt());
        }

        List<Integer> result = mObj.dequeSolution(inputVal, l);

        for(int k: result){
            System.out.println(k);
        }
    }
}