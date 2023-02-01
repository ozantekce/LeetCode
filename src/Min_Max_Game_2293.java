import java.util.Arrays;

public class Min_Max_Game_2293 {


    public static void main(String[] args) {

        System.out.println(minMaxGame(new int[]{999,939,892,175,114,464,850,107}));

    }

    public static int minMaxGame(int[] nums) {

        int n = nums.length;

        while (n>1){
            boolean min = true;
            for (int i = 0; i < n; i+=2) {
                if(min){
                    nums[i/2] = Math.min(nums[i],nums[i+1]);
                }else{
                    nums[i/2] = Math.max(nums[i],nums[i+1]);
                }
                min = !min;
            }
            n/=2;
            //System.out.println(Arrays.toString(nums));
        }

        return nums[0];
    }

}