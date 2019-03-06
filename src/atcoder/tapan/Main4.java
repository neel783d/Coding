import java.util.*;

public class Main4 {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        if(m==0) return;

        int countRecords = 0;
        int countPages = 1;
        List<String> result = new ArrayList<String>();

        for(int i=0; i<n; i++){
            String record = sc.next();

            // If we have reached mth Page
            if(countPages == m){
                result.add(record);
            }

            countRecords++;

            // Incrementing Pages
            if (countRecords % k == 0) {
                countPages++;
                countRecords = 0;
            }

            // Finish Early
            // if(countPages > m) break;
        }

        for(String record: result){
            System.out.println(record);
        }
    }
}