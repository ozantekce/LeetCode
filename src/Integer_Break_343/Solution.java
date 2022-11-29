package Integer_Break_343;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(integerBreak(6));

    }

    public static int integerBreak(int n) {

        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }

        int twos = n/2;
        int threes = 0;
        if(n%2==1){
            twos--;
            threes++;
        }

        int maxMul = 1;
        while (true){

            int mul = (int) (Math.pow(2,twos)*Math.pow(3,threes));
            if(mul>maxMul){
                maxMul = mul;
            }
            if(twos>=3){
                twos--;
                threes+=2;
                twos-=2;
            }else {
                break;
            }


        }
        return maxMul;
    }


/*
    public static int integerBreak(int n) {

        if(n==2)
            return 1;
        if(n==3)
            return 2;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(1);
        }

        int max = 1;
        while (numbers.size()>1){
            int current = numbers.remove(0);
            int index=0;
            while (current>0){
                index%=numbers.size();
                numbers.set(index,1+numbers.get(index));
                current--;
                index++;
            }

            Collections.sort(numbers);
            int mul = 1;
            for (int i = 0; i < numbers.size(); i++) {
                mul*=numbers.get(i);
            }
            if(mul>max){
                max = mul;
            }else{
                break;
            }

        }


        return max;
    }
*/
}
