import java.util.*;

public class Main {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        if(m==0) return;

        List<String> result = new ArrayList<String>();
        List<String> inputVal = new ArrayList<String>();

        for(int i=0; i<n; i++){
            inputVal.add(sc.next());
        }

        int records = 0;
        int pages = 1;
        for(String record: inputVal) {
            // Output
            if(pages == m){
                System.out.println(record);
            }

            records++;

            // Pages Counter Update
            if (records % k == 0) {
                pages++;
                records = 0;
            }

            if(pages > m){
                break;
            }
        }
    }
}