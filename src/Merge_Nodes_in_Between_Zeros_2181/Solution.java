package Merge_Nodes_in_Between_Zeros_2181;

public class Solution {


    public static void main(String[] args) {

    }


    public static ListNode mergeNodes(ListNode head) {

        ListNode current = head;
        ListNode resRoot = null;
        ListNode resCurrent = null;
        int val = 0;
        while (current != null){

            if(current.val != 0){
                val += current.val;
            }else{
                if(val != 0){
                    if(resRoot == null){
                        resCurrent = resRoot = new ListNode(val);
                    }else{
                        resCurrent.next = new ListNode(val);
                        resCurrent = resCurrent.next;
                    }
                }
                val = 0;
            }

            current = current.next;
        }

        return resRoot;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
