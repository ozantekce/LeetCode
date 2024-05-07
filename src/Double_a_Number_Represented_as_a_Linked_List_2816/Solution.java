package Double_a_Number_Represented_as_a_Linked_List_2816;

public class Solution {


    public static void main(String[] args) {

    }


    public static ListNode doubleIt(ListNode head) {

        head = reverseList(head);
        execute(head, 0);
        head = reverseList(head);

        return head;
    }

    private static void execute(ListNode head, int remainder){
        int baseValue = head.val * 2 + remainder;
        int value = baseValue % 10;
        remainder = baseValue / 10;
        head.val = value;
        if(head.next != null)
            execute(head.next, remainder);
        else if(remainder != 0){
            head.next = new ListNode();
            execute(head.next, remainder);
        }
    }


    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
