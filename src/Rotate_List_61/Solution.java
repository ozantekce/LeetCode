package Rotate_List_61;

public class Solution {


    public static void main(String[] args) {


    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        if(k == 0) return head;

        int n = 0;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            n++;
            prev = cur;
            cur = cur.next;
        }

        if(n == 1) return head;

        prev.next = head;

        prev = null;
        cur = head;
        int headIndex = (n - (k % n));
        for (int i = 0; i <= headIndex; i++) {
            if (i == headIndex) {
                prev.next = null;
                head = cur;
                break;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
