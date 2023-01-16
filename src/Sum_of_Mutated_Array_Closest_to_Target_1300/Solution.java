package Sum_of_Mutated_Array_Closest_to_Target_1300;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        int [] arr = {2,3,5};
        int target = 10;
        System.out.println(findBestValue(arr,target));

    }


    public static int sums [];

    public static int findBestValue(int[] arr, int target) {

        if(arr==null){
            return 0;
        }
        Arrays.sort(arr);
        setSums(arr);
        int max = arr[arr.length-1];
        int min = (target/arr.length)-1;

        int dif = Integer.MAX_VALUE;
        int value = 0;

        while (min<=max){
            int mid = (max+min)/2;
            int c = calculate(arr,mid);
            int d = Math.abs(target-c);

            if(d==0){
                return mid;
            }
            if(d<dif){
                value = mid;
                dif = d;
            }
            if(c>target){
                max = mid-1;
            }else{
                min = mid+1;
            }

        }


        return value;
    }

    public static void setSums(int[] arr){
        sums = new int[arr.length+1];
        int sum = 0;
        for (int i = 1; i < arr.length+1; i++) {
            sum+=arr[i-1];
            sums[i] = sum;
        }
    }


    public static int calculate(int[] arr, int val){
        int sum = 0;
        int x = -1;

        int min =0;
        int max = arr.length-1;
        while (min<=max){
            int mid = (max+min)/2;
            if(mid<0||mid>arr.length-1)
                break;
            if(val<arr[mid]){
                x=mid;
                max = mid-1;
            }else{
                min = mid+1;
            }

        }
        if(x==-1){
            x=arr.length-1;
        }

        sum = sums[x] + ((arr.length-x) * val);
        return sum;
    }

}
