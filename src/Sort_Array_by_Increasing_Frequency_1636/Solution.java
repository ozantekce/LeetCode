package Sort_Array_by_Increasing_Frequency_1636;

import java.security.Key;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums ={1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(nums)));

    }

    public static int[] frequencySort(int[] nums) {
        ValueFrequency.reset();
        for (int i = 0; i < nums.length; i++) {
            ValueFrequency.addValue(nums[i]);
        }

        List<ValueFrequency> list = new ArrayList<>();

        for (ValueFrequency vf :ValueFrequency.getValueFrequencyHashMap().values()) {
            list.add(vf);
        }
        Collections.sort(list);
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            int fq = list.get(i).frequency;
            int val = list.get(i).value;
            for (int j = 0; j < fq; j++) {
                nums[k] = val;
                k++;
            }
        }

        return nums;
    }

    public static class ValueFrequency implements Comparable<ValueFrequency>{

        private static HashMap<Integer,ValueFrequency> valueFrequencyHashMap = new HashMap<>();

        public int value;
        public int frequency = 1;

        private ValueFrequency(int value) {
            this.value = value;
        }

        public static void addValue(int value){

            if(valueFrequencyHashMap.containsKey(value)){
                valueFrequencyHashMap.get(value).frequency++;
            }else{
                ValueFrequency temp = new ValueFrequency(value);
                valueFrequencyHashMap.put(value,temp);
            }

        }

        public static void reset(){
            valueFrequencyHashMap.clear();;
        }

        public static HashMap<Integer, ValueFrequency> getValueFrequencyHashMap() {
            return valueFrequencyHashMap;
        }



        @Override
        public String toString() {
            return "ValueFrequency{" +
                    "value=" + value +
                    ", frequency=" + frequency +
                    '}';
        }

        @Override
        public int compareTo(ValueFrequency o) {

            if(o.frequency==this.frequency){
                if(o.value>this.value)
                    return 1;
                else if(o.value<this.value)
                    return -1;
                else
                    return 0;
            }else{
                if(o.frequency>this.frequency)
                    return -1;
                else if(o.frequency<this.frequency)
                    return 1;
                else
                    return 0;
            }


        }

    }


}
