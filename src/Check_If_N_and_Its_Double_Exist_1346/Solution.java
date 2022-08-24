package Check_If_N_and_Its_Double_Exist_1346;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        
        System.out.println(checkIfExist(new int[]{-10,12,-20,-8,15}));
        
    }

    public static boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);

        //4,6,10,20
        //2,3,5,10

        for (int i = 0; i < arr.length; i++) {


            int index = -1;
            if(arr[i]>0){
                index = Arrays.binarySearch(arr,i+1,arr.length,arr[i]*2);
            }else{
                index = Arrays.binarySearch(arr,0,i,arr[i]*2);
            }

            if(index>=0){
                return true;
            }

        }

        return false;
    }

}
