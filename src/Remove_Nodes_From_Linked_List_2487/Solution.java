package Remove_Nodes_From_Linked_List_2487;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        System.out.println(removeNodes(head));

    }



    public static ListNode removeNodes0(ListNode head) {

        if(head == null) return null;

        Stack<Integer> stack0 = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack0.push(node.val);
            node = node.next;
        }

        Stack<Integer> stack1 = new Stack<>();

        int currentVal, maxVal;

        currentVal = maxVal = stack0.pop();
        stack1.push(currentVal);

        while (!stack0.isEmpty()){

            currentVal = stack0.pop();
            if(currentVal>=maxVal){
                stack1.push(currentVal);
                maxVal = currentVal;
            }
        }

        ListNode newHead = new ListNode();
        ListNode current = newHead;
        current.val = stack1.pop();
        while (!stack1.isEmpty()){
            int val = stack1.pop();
            current.next = new ListNode(val);
            current = current.next;
        }

        return newHead;
    }


    public static ListNode removeNodes1(ListNode head) {

        if(head == null) return null;

        List<Integer> list = new ArrayList<>();
        int size = 0;
        ListNode current = head;
        while (current != null){
            int val = current.val;
            if(size>0){
                if(list.size() == size)
                    list.add(val);
                else
                    list.set(size, val);
            }else {
                if(list.isEmpty()){
                    list.add(val);
                }else{
                    list.set(0, val);
                }
            }
            current = current.next;
            size++;

            if(size>1){
                int currentIndex = size-1;
                int lastIndex = size-2;

                int currentVal;
                int lastVal;
                while (size>1){
                    currentVal = list.get(currentIndex);
                    lastVal = list.get(lastIndex);
                    if(currentVal <= lastVal) break;
                    list.set(lastIndex, currentVal);
                    currentIndex--;
                    lastIndex--;
                    size--;
                }
            }
        }

        ListNode newHead = new ListNode(list.get(0));
        ListNode node = newHead;
        for (int i = 1; i < size; i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }



        return newHead;
    }


    public static ListNode removeNodes(ListNode head) {

        if(head == null){
            return null;
        }

        head = reverseList(head);
        ListNode currentNode = head;

        int currentVal, nextVal;
        while (currentNode != null){
            currentVal = currentNode.val;
            if(currentNode.next ==null){
                break;
            }
            nextVal = currentNode.next.val;

            if(currentVal > nextVal){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }

        }
        return reverseList(head);
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


}
