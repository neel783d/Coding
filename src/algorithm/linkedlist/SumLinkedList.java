package algorithm.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Summing Two Linked List
 * Problem Definition: https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-list/1
 */
public class SumLinkedList {
    public static void main(String[] args) {
        // Creating two LinkedList
        LinkedList linkedListA = new LinkedList();
        LinkedList linkedListB = new LinkedList();
        LinkedList sumAB = new LinkedList();

        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(6, 7);

        for (int z : a) {
            linkedListA.insertElements(linkedListA, z);
        }

        System.out.println("Elements in LinkedlistA: ");
        linkedListA.printLinkedList(linkedListA.head);

        for (int z : b) {
            linkedListB.insertElements(linkedListB, z);
        }
        System.out.println("Elements in LinkedlistB: ");
        linkedListB.printLinkedList(linkedListB.head);

        // Summing Two Linked List
        SumLinkedList s = new SumLinkedList();
        LinkedList result = s.sumLinkedList(linkedListA, linkedListB);

        System.out.println("\nSummation of two linked list: ");
        result.printLinkedList(result.head);
    }

    public LinkedList sumLinkedList(LinkedList a, LinkedList b) {
        LinkedList sumList = new LinkedList();

        // Two Pointers
        Node currA = a.head;
        Node currB = b.head;
        while (currA != null || currB != null) {
            if (currA != null && currB != null) {
                sumList.insertElements(sumList, currA.value + currB.value);
                currA = currA.next;
                currB = currB.next;
            } else if (currA == null) {
                sumList.insertElements(sumList, currB.value);
                currB = currB.next;
            } else {
                sumList.insertElements(sumList, currA.value);
                currA = currA.next;
            }
        }
        return sumList;
    }
}

/**
 * Bidirectional LinkedList
 */
class LinkedList extends LinkedListOperation {
    Node head = null;
    Node last = null;
}

/**
 * Represents Node of a Linked List
 *
 * @author Neelesh
 * @version 1.0
 */
class Node extends LinkedListOperation {
    protected int value;
    protected Node next = null;
    protected Node prev = null;
}

class LinkedListOperation {

    /**
     * Inserts Elements One By One in the LinkedList
     *
     * @param ll    Whole LinkedList
     * @param value its value
     * @return new element chain
     */
    public LinkedList insertElements(LinkedList ll, int value) {
        // Creating A New node
        Node n = new Node();
        n.value = value;

        if (ll.head == null) {
            // Adding to Head
            ll.head = n;
            ll.last = n;
        } else {
            // Adding to last element
            ll.last.next = n;
            n.prev = ll.last;
            ll.last = n;
        }
        return ll;
    }

    /**
     * Print Linked List from Start
     *
     * @param head Current Pointer
     */
    public void printLinkedList(Node head) {
        if (head == null) {
            System.out.print("Null");
            System.out.println();
            return;
        } else {
            System.out.print(head.value + "->");
            this.printLinkedList(head.next);
        }
    }

    /**
     * Returns Length of the linked list
     *
     * @param currNode   Current node
     * @param currLength Current Length
     * @return
     */
    public int lengthLinkedList(Node currNode, int currLength) {
        if (currNode == null) {
            return currLength;
        } else {
            return this.lengthLinkedList(currNode.next, currLength + 1);
        }
    }
}