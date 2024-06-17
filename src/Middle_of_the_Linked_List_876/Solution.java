package Middle_of_the_Linked_List_876;

public class Solution {


    public static void main(String[] args) {

    }


    public static ListNode middleNode(ListNode head) {

        int size = 0;
        ListNode current = head;
        while (current != null){
            size++;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < size/2; i++) {
            current = current.next;
        }

        return current;
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
