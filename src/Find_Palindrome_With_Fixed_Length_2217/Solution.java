package Find_Palindrome_With_Fixed_Length_2217;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(kthPalindrome(new int[]{1,2,3,4,5,90},3)));
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2,4,6},4)));
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2,201429812,8,520498110,492711727,339882032,462074369,9,7,6},1)));

    }


    public static long[] kthPalindrome(int[] queries, int intLength) {

        long [] result = new long[queries.length];
        if(intLength%2==0){
            for (int i = 0; i < queries.length; i++) {
                result[i] = findEven(queries[i],intLength);
            }
        }else{
            for (int i = 0; i < queries.length; i++) {
                result[i] = findOdd(queries[i],intLength);
            }
        }

        return result;
    }


    public static long findOdd(int q, int length){

        int l = length/2 + 1 ;

        long val = (long) Math.pow(10,(l-1));

        val += q-1;

        long rev = reverse(val);

        val = val/10 * (long) Math.pow(10,l) + rev;

        long max = (long) (Math.pow(10,length)-1);
        if(val>max)return -1;

        return val;
    }

    public static long findEven(int q, int length){

        int l = length/2;

        long val = (long) Math.pow(10,(l-1));

        val += q-1;

        long rev = reverse(val);

        val = val * (long) Math.pow(10,l) +rev;

        long max = (long) (Math.pow(10,length)-1);
        if(val>max)return -1;

        return val;
    }




    public static long reverse(long num){
        long reversed = 0;
        while (num>0){
            reversed*=10;
            reversed+= num%10;
            num/=10;
        }
        return reversed;
    }

}
