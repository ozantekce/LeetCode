package Reverse_Linked_List_206;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseList(head);
        ListNode current = head;
        while (current!=null){
            System.out.println(current.val);
            current=current.next;
        }

    }

    public static ListNode reverseList(ListNode head) {

        if(head==null)
            return null;
        if(head.next==null)
            return head;

        ListNode last = head;
        ListNode current = head.next;
        ListNode next = null;
        boolean first = true;
        while (current!=null){
            next = current.next;
            current.next = last;
            if (first) {
                last.next = null;
                first =false;
            }
            last = current;
            current = next;

        }

        return last;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
