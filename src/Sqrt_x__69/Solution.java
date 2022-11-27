package Sqrt_x__69;

public class Solution {


    public static void main(String[] args) {

        int x = 2147395599;
        System.out.println(mySqrt(x));
    }



    public static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        int first = 0;
        int last = x;
        int mid = 0;
        while (first<last){
            //System.out.println(first+" "+last);
            if(first+1==last){
                return first;
            }
            mid = (first+last)/2;
            int sqr = x/mid;
            if(sqr==mid){
                return sqr;
            }else if(sqr<mid){
                last = mid;
            }else{
                first = mid;
            }

        }

        return mid;

    }

}

