package Remove_Linked_List_Elements_203;

public class Solution {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode current  = head.next;
        current = new ListNode(2);
        current  = current.next;
        current = new ListNode(6);
        current  = current.next;
        current = new ListNode(3);
        current  = current.next;
        current = new ListNode(4);
        current  = current.next;
        current = new ListNode(5);
        current  = current.next;
        current = new ListNode(6);

        removeElements(head,6);

    }


    public static ListNode removeElements(ListNode head, int val) {

        if(head==null)
            return null;

        ListNode parent = null;
        ListNode current = head;

        while (current!=null){

            if(current.val==val){
                if(parent!=null)
                    parent.next = current.next;
                else{
                    head = current.next;
                }

            }else{
                parent = current;
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
