package Add_Two_Numbers_2;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

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


        ListNode l = solution.addTwoNumbers(listNode1,listNode);
        System.out.println(solution.getVal(l));

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode root = new ListNode();
        ListNode current = root;

        ListNode cl1 = l1;
        ListNode cl2 = l2;

        while (true){
            int v1 = 0;
            int v2 = 0;
            if(cl1!=null){
                v1 = cl1.val;
                cl1 = cl1.next;
            }
            if(cl2!=null){
                v2 = cl2.val;
                cl2 = cl2.next;
            }
            int sum = v1+v2+carry;
            carry = sum/10;
            sum = sum%10;
            current.val = sum;
            if(cl1!=null || cl2!=null){
                current = current.next = new ListNode();
            }
            else{
                if(carry!=0){
                    current.next = new ListNode(carry);
                }
                break;
            }
        }


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