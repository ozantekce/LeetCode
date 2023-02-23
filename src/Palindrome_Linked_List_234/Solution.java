package Palindrome_Linked_List_234;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public boolean isPalindrome(ListNode head) {

        ListNode current = head;

        int size = 0;
        while (current!=null){
            size++;
            current = current.next;
        }

        current = head;
        int[] array = new int[size];
        int j = 0;
        while (current!=null){
            array[j++] = current.val;
            current = current.next;
        }

        for (int i = 0; i < size/2; i++) {
            int v1 = array[i];
            int v2 = array[size-1-i];
            if(v1!=v2){
                return false;
            }
        }

        return true;
    }


}
