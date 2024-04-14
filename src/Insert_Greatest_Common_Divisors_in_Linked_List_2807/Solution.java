package Insert_Greatest_Common_Divisors_in_Linked_List_2807;

public class Solution {

    public static void main(String[] args) {

    }



    public static ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode current = head;

        while (current != null){

            ListNode next = current.next;
            if(next != null){
                int gcd = gcdByEuclidsAlgorithm(current.val, next.val);
                ListNode node = new ListNode(gcd, next);
                current.next = node;
                current = next;
            }else{
                break;
            }

        }

        return head;
    }


    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
