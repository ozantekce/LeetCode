package Check_If_N_and_Its_Double_Exist_1346;

public class Solution {


    public static void main(String[] args) {

        
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
        
    }

    public static boolean checkIfExist(int[] arr) {


        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length; j++) {

                if(arr[i] == arr[j]*2 || arr[i]*2 == arr[j])
                    return true;
            }

        }
        
        
        return false;
    }

}
