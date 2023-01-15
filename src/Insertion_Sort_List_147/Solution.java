package Insertion_Sort_List_147;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode insertionSortList(ListNode head) {

        return sort(head);
    }


    public ListNode sort(ListNode node){

        int size = 0;
        ListNode current = node;
        while (current!=null){
            size++;
            current = current.next;
        }
        int [] array = new int[size];
        current = node;
        for (int i = 0; i < size; i++) {
            array[i] = current.val;
            current = current.next;
        }
        Arrays.sort(array);
        ListNode head = new ListNode(array[0]);
        current = head;
        for (int i = 1; i < size; i++) {
            current.next = new ListNode(array[i]);
            current =current.next;
        }


        return head;
    }


    /*
    public ListNode sort(ListNode node){

        List<Integer> list = new ArrayList<>();

        ListNode current = node;
        while (current!=null){
            list.add(current.val);
            current = current.next;
        }
        Collections.sort(list);
        ListNode head = new ListNode();
        current = head;
        for (int i = 0; i < list.size(); i++) {
            current.val = list.get(i);
            if (i != list.size() - 1) {
                current.next = new ListNode();
                current = current.next;
            }

        }

        return head;
    }
*/

    public void deneme(ListNode node){

        if(node.next==null){
            return;
        }

        if(node.next.next!=null){
            deneme(node.next);
        }

        ListNode temp = node;
        int val = temp.val;
        while (temp.next!=null && temp.next.val<val){

            temp.val = temp.next.val;
            temp.next.val = val;
            temp = temp.next;
        }
    }

}
