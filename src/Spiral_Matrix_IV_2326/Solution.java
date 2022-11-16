package Spiral_Matrix_IV_2326;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {







    public static void main(String[] args) {

        int[] array ={3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head = new ListNode();
        ListNode current = head;

        for (int i = 0; i < array.length; i++) {
            current.val = array[i];
            if(i!=array.length-1){
                current.next = new ListNode();
                current = current.next;
            }

        }

        int spiralArray[][] = spiralMatrix(3,5,head);

        for (int i = 0; i < spiralArray.length; i++) {
            System.out.println(Arrays.toString(spiralArray[i]));
        }

    }


    public static int[][] spiralMatrix(int m, int n, ListNode head) {

        int [][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = -1;
            }
        }
        int upBound,downBound,leftBound,rightBound;
        rightBound = n-1;
        downBound = m-1;
        upBound = 1;
        leftBound = 0;


        int i = 0;
        int j = 0;
        int status = 0; //0:go right : j++ , 1:go down : i++ ,2:go left: j-- , 3:go up: i--
        ListNode current = head;
        while (current!=null){
            //System.out.println("i:"+i+" j:"+j);
            if(status==0){

                array[i][j] = current.val;
                current = current.next;
                if(j==rightBound){
                    rightBound--;
                    status = 1;
                    i++;
                }else{
                    j++;
                }

            }else if(status==1){

                array[i][j] = current.val;
                current = current.next;
                if(i==downBound){
                    downBound--;
                    status = 2;
                    j--;
                }else{
                    i++;
                }

            }else if(status==2){

                array[i][j] = current.val;
                current = current.next;
                if(j==leftBound){
                    leftBound++;
                    status = 3;
                    i--;
                }else{
                    j--;
                }

            }else if(status==3){

                array[i][j] = current.val;
                current = current.next;
                if(i==upBound){
                    upBound++;
                    status = 0;
                    j++;
                }else{
                    i--;
                }
            }

        }

        return array;
    }



}
