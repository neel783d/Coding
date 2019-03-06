import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node head = null;

        for (int i = 0; i < m; i++) {
            long minVal = sc.nextLong();
            long maxVal = sc.nextLong();
            Node node = new Node(minVal, maxVal);
            // node.dataMin = minVal;
            // node.dataMax = maxVal;

            if (head == null) {
                head = node;
            } else {
                head.insertGraph(head, node);
            }
        }

        // Search
        int q = sc.nextInt();
        for (int i=0; i<q; i++){
            long minVal = sc.nextLong();
            long maxVal = sc.nextLong();
            Node node = new Node(minVal, maxVal);
            // node.dataMin = minVal;
            // node.dataMax = maxVal;

            if (head == null) {
                head = node;
                System.out.println("OK " + node.dataMin + " " + node.dataMax);
            } else {
                Boolean flag = head.insertGraph(head, node);
                if(flag){
                    System.out.println("OK " + node.dataMin + " " + node.dataMax);
                }else{
                    System.out.println("NG " + node.dataMin + " " + node.dataMax);
                }
            }
        }
    }
}

class Node {

    Node left = null;
    Node right = null;
    Node parent = null;
    Long dataMin = null;
    Long dataMax = null;


    public Node(long minVal, long maxVal) {
        this.dataMax = maxVal;
        this.dataMin = minVal;
    }

    public Boolean insertGraph(Node currNode, Node newNode) {

        if ((newNode.dataMin>=currNode.dataMin && newNode.dataMin<=currNode.dataMax) // e
                || (newNode.dataMax>=currNode.dataMin && newNode.dataMax <= currNode.dataMax) //d
        ) {
            return false;
        }

        if (currNode.dataMin >= newNode.dataMin && newNode.dataMax <= currNode.dataMax){
            return false;
        }

        if (currNode.left == null && newNode.dataMin < currNode.dataMin) {
            currNode.left = newNode;
            return true;
        }

        if (currNode.right == null && newNode.dataMax >= currNode.dataMax) {
            currNode.right = newNode;
            return true;
        }

        if (newNode.dataMin < currNode.dataMin) {
            return insertGraph(currNode.left, newNode);
        }
        if (newNode.dataMax >= currNode.dataMax) {
            return insertGraph(currNode.right, newNode);
        }

        return false;
    }

    public void printInOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        printInOrder(currNode.left);
        System.out.print(", " + currNode.dataMin + "--" + currNode.dataMax);
        printInOrder(currNode.right);
    }
}
