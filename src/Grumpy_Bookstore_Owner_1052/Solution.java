package Grumpy_Bookstore_Owner_1052;

public class Solution {

    public static void main(String[] args) {


        int [] customers = {1,0,1,2,1,1,7,5};
        int [] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        System.out.println(maxSatisfied(customers,grumpy,minutes));

    }


    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int min = 0;
        int windowValue = 0;
        int maxWindowValue = 0;
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i]==0){
                min += customers[i];
            }
            if(i<minutes){
                if(grumpy[i]==1){
                    windowValue+=customers[i];
                    maxWindowValue = windowValue;
                }
            }else{

                if(grumpy[i-minutes]==1){
                    windowValue -= customers[i-minutes];
                }
                if(grumpy[i]==1){
                    windowValue += customers[i];
                }
                maxWindowValue = Math.max(windowValue,maxWindowValue);

            }

        }

        return min+maxWindowValue;
    }

}
