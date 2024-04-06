package Four_Divisors_1390;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(sumFourDivisors(new int[]{21,4,7}));
        System.out.println(sumFourDivisors(new int[]{21,21}));
        //System.out.println(sumFourDivisors(new int[]{1,2,3,4,5}));
        System.out.println(sumFourDivisors(new int[]{1,2,3,4,5,6,7,8,9,10}));

    }

    private static HashMap<Integer, Integer> Cache = new HashMap<>();

    public static int sumFourDivisors(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += GetDivisorsSums(nums[i]);
        }
        
        return result;
    }


    private static int GetDivisorsSums(int num){

        if(Cache.containsKey(num)){
            return Cache.get(num);
        }
        int res = num + 1;
        int count = 2;
        for (int i = 2; i * i <= num && count <= 4; i++) {
            if (num % i == 0) {
                res += i;
                count++;
                if (i * i != num) {
                    res += num/i;
                    count++;
                }
            }
        }
        //System.out.println(num+" "+ count+" "+res);
        if(count == 4){
            Cache.put(num, res);
            return res;
        }else{
            Cache.put(num, 0);
            return 0;
        }
    }




}
