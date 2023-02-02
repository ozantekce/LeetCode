package Maximum_Candies_Allocated_to_K_Children_2226;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maximumCandies(new int[]{1,2,3,4,10},5));

    }

    public static int maximumCandies(int[] candies, long k) {

        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if(max<candies[i]){
                max = candies[i];
            }
        }

        int left = 0;
        int right = max;
        int mid;
        int rst = 0;
        while (left<=right){
            mid = (left+right)/2;
            if(canGetC(candies,k,mid)){
                left = mid+1;
                rst = mid;
            }else{
                right = mid-1;
            }
        }
        return rst;
    }



    public static boolean canGetC(int[] candies,long k,int c){
        if(c==0)
            return true;
        long s = 0;
        for (int i = 0; i < candies.length; i++) {
            s += candies[i]/c;
            if(s>=k){
                return true;
            }
        }
        return false;
    }

}
