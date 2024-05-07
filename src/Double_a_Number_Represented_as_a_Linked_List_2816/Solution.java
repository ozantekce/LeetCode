package Double_a_Number_Represented_as_a_Linked_List_2816;

public class Solution {


    public static void main(String[] args) {

    }

    public static ListNode doubleIt(ListNode head) {
        int remainder = execute(head);
        if(remainder != 0){
            ListNode newHead = new ListNode(remainder);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private static int execute(ListNode head){
        if(head == null)
            return 0;
        int baseValue = head.val * 2 + execute(head.next);
        int value = baseValue % 10;
        int remainder = baseValue / 10;
        head.val = value;
        return remainder;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
