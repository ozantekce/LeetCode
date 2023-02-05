package H_Index_274;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        System.out.println(hIndex(new int[]{0,1,1}));

    }


    public static int hIndex(int[] citations) {

        int size = 0;
        for (int i = 0; i < citations.length ; i++) {
            size = Math.max(size,citations[i]);
        }
        size++;
        int [] counter = new int[size];
        for (int i = 0; i < citations.length; i++) {
            counter[citations[i]]++;
        }

        int h=0;
        int max = 0;
        for (int i = size-1; i >= 0; i--) {
            if(counter[i]==0)
                continue;
            h+=counter[i];
            if(i>=h){
                max = h;
            }else{
                max = Math.max(max,i);
                break;
            }
        }

        return max;
    }



}
