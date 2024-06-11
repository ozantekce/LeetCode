package Intersection_of_Two_Linked_Lists_160;

public class Solution {


    public static void main(String[] args) {


    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeOfA = 0;
        ListNode currentA = headA;
        while (currentA != null){
            sizeOfA++;
            currentA = currentA.next;
        }

        int sizeOfB = 0;
        ListNode currentB = headB;
        while (currentB != null){
            sizeOfB++;
            currentB = currentB.next;
        }

        if(sizeOfB > sizeOfA){
            currentA = headA;
            currentB = headB;
            int move = sizeOfB - sizeOfA;
            for (int i = 0; i < move; i++) {
                currentB = currentB.next;
            }
        }else if(sizeOfA > sizeOfB){
            currentB = headB;
            currentA = headA;
            int move = sizeOfA - sizeOfB;
            for (int i = 0; i < move; i++) {
                currentA = currentA.next;
            }
        }else{
            currentA = headA;
            currentB = headB;
        }

        int move = Math.min(sizeOfA, sizeOfB);
        for (int i = 0; i < move; i++) {
            if(currentA.val == currentB.val)
                return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }


        return null;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

}
