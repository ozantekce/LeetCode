package Number_of_Steps_to_Reduce_a_Number_to_Zero_1324;

public class Solution {

    public static void main(String[] args) {

        System.out.println(numberOfSteps(14));

    }


    public static int numberOfSteps(int num) {

        int counter = 0;

        if(num ==0){
            return 0;
        }

        while (num!=0){

            if(num%2==0){
                num>>=1;
                counter++;
            }else{
                num--;
                counter++;
            }

        }

        return counter;
    }


}
