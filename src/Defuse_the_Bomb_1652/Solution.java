package Defuse_the_Bomb_1652;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(decrypt(new int[]{5,7,1,4},3)));
        System.out.println(Arrays.toString(decrypt(new int[]{1,2,3,4},0)));
        System.out.println(Arrays.toString(decrypt(new int[]{2,4,9,3},-2)));
        System.out.println(Arrays.toString(decrypt(new int[]{10,5,7,7,3,2,10,3,6,9,1,6},-4)));

    }


    public static int[] decrypt(int[] code, int k) {

        int [] result = new int[code.length];
        if(k==0){
            return result;
        }

        int lastValue = -1;

        int absK = Math.abs(k);
        for (int i = 0; i < code.length; i++) {
            int value = 0;
            if(lastValue==-1){
                for (int j = 1; j <=absK; j++) {
                    int currentIndex = normalizeIndex( k>0 ? i+j:i-j,code.length);
                    value+=code[currentIndex];
                }
            }else{
                value = lastValue;
                if(k>0){
                    value -= code[normalizeIndex( i,code.length)];
                    value += code[normalizeIndex( i+k,code.length)];
                }else{
                    value += code[normalizeIndex( i-1,code.length)];
                    value -= code[normalizeIndex( i+k-1,code.length)];
                }
            }
            result[i] = value;
            lastValue = value;

        }

        return result;
    }


    private static int normalizeIndex(int index, int CAPACITY){
        if(index<0)return index%CAPACITY + CAPACITY;
        else if(index<CAPACITY)return index;
        else return index%CAPACITY;
    }

}
