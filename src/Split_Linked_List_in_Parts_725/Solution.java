package Split_Linked_List_in_Parts_725;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


        ListNode heah = new ListNode(1);
        ListNode current = heah.next = new ListNode(2);
        current = current.next = new ListNode(3);

        System.out.println(Arrays.toString(splitListToParts(heah, 5)));


        heah = new ListNode(1);
        current = heah.next = new ListNode(2);
        current = current.next = new ListNode(3);
        current = current.next = new ListNode(4);
        current = current.next = new ListNode(5);
        current = current.next = new ListNode(6);
        current = current.next = new ListNode(7);
        current = current.next = new ListNode(8);
        current = current.next = new ListNode(9);
        current = current.next = new ListNode(10);

        System.out.println(Arrays.toString(splitListToParts(heah, 3)));

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {

        int totalSize = 0;
        ListNode current = head;
        while (current != null){
            totalSize++;
            current = current.next;
        }

        int minSize = totalSize / k;
        int remainder = totalSize - (minSize * k);

        int [] sizes = new int[k];
        Arrays.fill(sizes, minSize);

        int i = 0;
        while (remainder > 0){
            sizes[i]++;
            remainder--;
            i++;
            if(i >= k)
                i = 0;
        }

        //System.out.println(Arrays.toString(sizes));

        ListNode[] result = new ListNode[k];

        current = head;
        for (int j = 0; j < sizes.length; j++) {

            int size = sizes[j];
            result[j] = current;
            if(current == null)
                break;
            //System.out.println(j+" start: "+ current+" "+ size);
            for (int l = 0; l < size-1; l++) {
                current = current.next;
            }
            //System.out.println(j+" stop: "+ current+" "+ size);
            ListNode old = current;
            current = current.next;
            old.next = null;

        }

        return result;
    }



  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
          return "ListNode{" +
                  "val=" + val +
                  '}';
      }
  }
}
