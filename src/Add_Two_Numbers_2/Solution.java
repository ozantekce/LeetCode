package Add_Two_Numbers_2;

import javax.swing.*;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

// Not a good solution must be change
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.nanoTime();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(9) ;
        listNode.next.next.next = new ListNode(9);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode listNode1 = new ListNode(9);

        System.out.println(solution.getVal(listNode));
        System.out.println(solution.getVal(listNode1));

        solution.addTwoNumbers(listNode1,listNode);

        long durationInMs = TimeUnit.MILLISECONDS.convert((System.nanoTime()-start), TimeUnit.NANOSECONDS);
        System.out.println(durationInMs+" ms ");

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger v1 = new BigInteger(getVal(l1));
        BigInteger v2 = new BigInteger(getVal(l2));

        v1 = v1.add(v2);

        StringBuffer sum = new StringBuffer(v1.toString());

        System.out.println(sum);
        ListNode root = new ListNode();
        ListNode current = root;
        for (int i = sum.length()-1; i >=0; i--) {
            current.val = sum.charAt(i)-48;
            if(i!=0) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        System.out.println(getVal(root));

        return root;
    }

    public String getVal(ListNode l){
        if(l.next==null){
            return ""+l.val;
        }else{
            return getVal(l.next)+""+l.val;
        }
    }



}