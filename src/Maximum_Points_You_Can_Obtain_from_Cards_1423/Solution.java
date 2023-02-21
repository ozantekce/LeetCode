package Maximum_Points_You_Can_Obtain_from_Cards_1423;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {


        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1},3));           //12
        System.out.println(maxScore(new int[]{2,2,2},2));                   //4
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9},7));           //55
        System.out.println(maxScore(new int[]{100,40,17,9,73,75},3));       //248
        System.out.println(maxScore(new int[]{1,79,80,1,1,1,200,1},3));     //202
        System.out.println(maxScore(new int[]{96,90,41,82,39,74,64,50,30},8));     //202

    }

    public static int maxScore(int[] cardPoints, int k) {

        if(k==cardPoints.length){
            int sum=0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum+=cardPoints[i];
            }
            return sum;
        }

        int [] front = new int[cardPoints.length+1];
        int [] end = new int[cardPoints.length+1];

        front[1] = cardPoints[0];
        end[1] = cardPoints[cardPoints.length-1];

        for (int i = 1; i <= k; i++) {
            front[i+1] = front[i]+cardPoints[i];
            end[i+1] = end[i]+ cardPoints[cardPoints.length-1-i];
        }


        //System.out.println(Arrays.toString(front));
        //System.out.println(Arrays.toString(end));

        int max = 0;
        for (int i = 0; i <= k; i++) {
            //System.out.println("c : "+(front[i]+end[k-i]));
            max = Math.max(max,front[i]+end[k-i]);
        }

        return max;
    }

    /*
    public static int maxScore(int[] cardPoints, int k) {

        if(k==cardPoints.length){
            int sum=0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum+=cardPoints[i];
            }
            return sum;
        }

        int [] front = new int[cardPoints.length+1];
        int [] end = new int[cardPoints.length+1];

        front[1] = cardPoints[0];
        end[1] = cardPoints[cardPoints.length-1];

        for (int i = 1; i <= k; i++) {
            front[i+1] = front[i]+cardPoints[i];
            end[i+1] = end[i]+ cardPoints[cardPoints.length-1-i];
        }


        //System.out.println(Arrays.toString(front));
        //System.out.println(Arrays.toString(end));

        int max = 0;
        for (int i = 0; i <= k; i++) {
            //System.out.println("c : "+(front[i]+end[k-i]));
            max = Math.max(max,front[i]+end[k-i]);
        }

        return max;
    }
*/


    /*
    private static int Memory [][];
    public static int maxScore(int[] cardPoints, int k) {
        Memory = new int[cardPoints.length][cardPoints.length];
        return recursive(0,cardPoints.length-1,0,cardPoints,k,0);
    }

    public static int recursive(int f,int l,int seq,int [] cardPoints,int k,int value){

        if(Memory[f][l]!=0)
            return Memory[f][l];

        if(seq==k)
            return value;
        Memory[f][l] = value;
        int v1 =0;
        if(f+1<cardPoints.length){
            v1 = recursive(f+1,l,seq+1,cardPoints,k,value+cardPoints[f]);
        }
        int v2 =0;
        if(l-1>=0){
            v2 = recursive(f,l-1,seq+1,cardPoints,k,value+cardPoints[l]);
        }
        return Math.max(v1,v2);

    }
*/



}
