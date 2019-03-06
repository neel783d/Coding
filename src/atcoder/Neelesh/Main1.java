import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Tree Map to Maintain Range
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int minVal = sc.nextInt();
            int maxVal = sc.nextInt();

            // Getting Ranges that are less than or equal to start
            Entry<Integer, Integer> entFloor = treeMap.floorEntry(minVal);
            Entry<Integer, Integer> entCeil = treeMap.ceilingEntry(minVal);
            treeMap.put(minVal, maxVal);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int minVal = sc.nextInt();
            int maxVal = sc.nextInt();

            // Getting Ranges that are less than or equal to start
            Entry<Integer, Integer> entFloor = treeMap.floorEntry(minVal);
            Entry<Integer, Integer> entCeil = treeMap.ceilingEntry(minVal);

            // Check if range intersect or not
            if(entFloor != null && minVal <= entFloor.getValue()){
                result.add("NG");
            }
            else if(entCeil != null && entCeil.getKey() <= maxVal) {
                result.add("NG");
            }
            else {
                result.add("OK");
                treeMap.put(minVal, maxVal);
            }
        }

        // Result
        for(String k: result){
            System.out.println(k);
        }
    }
}