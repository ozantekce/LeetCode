package Delete_Node_in_a_Linked_List_237;

public class Solution {


    public static void main(String[] args) {

    }



    public static void deleteNode(ListNode node) {

        ListNode prev = node;
        ListNode current = node;
        while (current.next != null){
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;

    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
