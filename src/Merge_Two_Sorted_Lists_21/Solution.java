package Merge_Two_Sorted_Lists_21;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1==null && l2 ==null)
            return  null;
        ListNode root = new ListNode();
        ListNode current = root;
        while (true){

            if(l1!=null && l2!=null){
                if(l1.val < l2.val){
                    current.val = l1.val;
                    l1 = l1.next;

                }else{
                    current.val = l2.val;
                    l2 = l2.next;
                }
            }else if (l1!=null) {
                current.val = l1.val;
                l1 = l1.next;
            }else if(l2!=null){
                current.val = l2.val;
                l2 = l2.next;
            }

            if(l1==null && l2==null){
                break;
            }else{
                current.next = new ListNode();
                current = current.next;
            }

        }

        return root;
    }


}
