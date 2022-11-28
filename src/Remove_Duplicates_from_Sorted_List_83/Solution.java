package Remove_Duplicates_from_Sorted_List_83;

public class Solution {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        head = deleteDuplicates(head);
        ListNode current = head;
        while (current!=null){
            System.out.println(current.val);
            current = current.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null)
            return head;
        ListNode current = head;

        while (current.next!=null){
            if(current.val==current.next.val){
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }

        return head;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
