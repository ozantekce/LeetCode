package Count_Operations_to_Obtain_Zero_2169;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countOperations(2,3));

    }


    public static int countOperations(int num1, int num2) {

        int op = 0;

        while (num1!=0 && num2!=0){
            if(num1>num2){
                int times = num1/num2;
                op+=times;
                num1 -= times*num2;
            }else{
                int times = num2/num1;
                op+=times;
                num2 -= times*num1;
            }
        }


        return op;
    }

}
