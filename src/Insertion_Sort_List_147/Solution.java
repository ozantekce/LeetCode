package Insertion_Sort_List_147;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode insertionSortList(ListNode head) {

        deneme(head);

        return head;
    }


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
