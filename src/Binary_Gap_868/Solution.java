package Binary_Gap_868;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(binaryGap(22));
        //System.out.println(binaryGap(8));
        //System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
    }


    public static int binaryGap(int n) {

        int maxGap = 1;
        int gap = 0;
        boolean set = false;
        boolean control = false;
        while (n > 0){
            int t = n % 2;
            n /= 2;

            if(t == 1){
                if(set){
                    control = true;
                }
                set = true;
                gap = 1;
            }else if(set){
                control = true;
                gap++;
                maxGap = Math.max(gap, maxGap);
            }

        }

        if(!control) return 0;

        return maxGap;
    }


}
