package Add_Two_Numbers_II_445;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1,l2);

        while (sum!=null){

            System.out.println(sum.val);
            sum= sum.next;
        }

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode current = l1;
        while (current!=null){
            s1.add(current.val);
            current = current.next;
        }

        current = l2;
        while (current!=null){
            s2.add(current.val);
            current = current.next;
        }

        int sum=0;
        int carry=0;
        current = new ListNode();
        while (!s1.isEmpty()||!s2.isEmpty()){
            int val1 = !s1.isEmpty()?  s1.pop():0;
            int val2 = !s2.isEmpty()?  s2.pop():0;

            sum = val1+val2+carry;
            carry = 0;
            if(sum>=20){
                carry=2;
                sum-=20;
            }else if(sum>=10){
                carry=1;
                sum-=10;
            }
            current.val = sum;
            ListNode temp = new ListNode();
            temp.next = current;
            current = temp;
        }

        if(carry!=0){
            current.val = carry;
        }else {
            current = current.next;
        }

        return current;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
