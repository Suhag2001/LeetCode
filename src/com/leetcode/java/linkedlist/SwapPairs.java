package src.com.leetcode.java.linkedlist;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        // If head is null or just having a single node, then no need to change anything.
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp; // Temporary pointer to store head.next.
        temp = head.next; // Assign temp the value of head.next.

        head.next = swapPairs(head.next.next); // Changing links.
        temp.next = head; // Put temp.next to head.

        return temp; // After changing links, temp acts as our head.
    }

    public static void main(String[] args) {
    }
}