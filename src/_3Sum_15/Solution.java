package _3Sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


        int [] nums ={0,0,0,0};

        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {

        ThreeValue.reset();
        result.clear();
        Arrays.sort(nums);
        int lastVal = nums[0];
        for (int i = 0; i < nums.length-2; i++) {

            if(i!=0&&lastVal == nums[i])
                continue;
            lastVal = nums[i];
            findTarget(nums,i+1,-nums[i]);

        }

        return result;
    }


    public static void findTarget(int[]nums,int firstIndex,int target){

        int i = firstIndex;
        int j = nums.length-1;
        while (i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                ThreeValue value = ThreeValue.get(nums[firstIndex-1],nums[i],nums[j]);
                if(value!=null){
                    List<Integer> temp = new ArrayList<>(3);
                    temp.add(value.x);
                    temp.add(value.y);
                    temp.add(value.z);
                    result.add(temp);
                }
            }
            if(sum>target){
                j--;
            }else{
                i++;
            }
        }

    }


    public static class ThreeValue{

        public int x;
        public int y;
        public int z;

        private static HashMap<Integer,HashMap<Integer,HashMap<Integer,ThreeValue>>> record = new HashMap<>();

        private ThreeValue(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public static void reset(){
            record = new HashMap<>();
        }

        public static ThreeValue get(int x,int y,int z){


            if(record.containsKey(x)){
                if(record.get(x).containsKey(y)){
                    if(record.get(x).get(y).containsKey(z)){
                        return null;
                    }
                }
            }


            HashMap<Integer,HashMap<Integer,ThreeValue>> hashMapY;
            if(record.containsKey(x)){
                hashMapY = record.get(x);
            }else{
                hashMapY = new HashMap<>();
                record.put(x,hashMapY);
            }
            HashMap<Integer,ThreeValue> hashMapZ;
            if(hashMapY.containsKey(y)){
                hashMapZ = hashMapY.get(y);
            }else{
                hashMapZ = new HashMap<>();
                hashMapY.put(y,hashMapZ);
            }

            if(hashMapZ.containsKey(z)){
                return hashMapZ.get(z);
            }else{
                ThreeValue temp = new ThreeValue(x,y,z);
                hashMapZ.put(z,temp);
                return temp;
            }
        }

    }





        /*
    public static List<MyVector> vectors = new ArrayList<>();
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {

        vectors.clear();
        result.clear();
        Arrays.sort(nums);
        int lastVal = nums[0];

        for (int i = 0; i < nums.length-2; i++) {

            if(i!=0&&lastVal == nums[i])
                continue;
            lastVal = nums[i];
            findTarget(nums,i+1,-nums[i]);

        }

        return result;
    }

    private static List<Integer> temp = new ArrayList<>();
    public static void findTarget(int[]nums,int firstIndex,int target){

        int i = firstIndex;
        int j = nums.length-1;
        while (i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                MyVector value = new MyVector(nums[firstIndex-1],nums[i],nums[j]);
                if(!vectors.contains(value)){
                    vectors.add(value);
                    temp = new ArrayList<>();
                    temp.add(value.x);
                    temp.add(value.y);
                    temp.add(value.z);
                    result.add(temp);
                }
            }
            if(sum>target){
                j--;
            }else{
                i++;
            }
        }

    }

    public static class MyVector{

        int x;
        int y;
        int z;

        public MyVector(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {

            MyVector O = (MyVector) o;
            if(O.x==this.x&&O.y==this.y&&O.z==this.z){
                return true;
            }
            return false;
        }

    }
*/

}
