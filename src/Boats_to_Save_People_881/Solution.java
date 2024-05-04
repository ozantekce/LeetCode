package Boats_to_Save_People_881;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(numRescueBoats(new int[]{1,2},3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1},3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4},5));

    }


    // 1, 2, 2, 3

    public static int numRescueBoats(int[] people, int limit) {

        countingSort(people, limit);

        int res = 0;
        int p0 = 0;
        int p1 = people.length-1;

        while (p0 < p1){
            int weightMin = people[p0];
            int weightMax = people[p1];
            int total = weightMax + weightMin;

            if(total > limit){
                res++;
                p1--;
            }else {
                res++;
                p1--;
                p0++;
            }
        }

        if(p0 == p1){
            res++;
        }

        return res;
    }


    private static int[] countingSort(int[] people, int limit){

        int [] counter = new int[limit+1];

        for (int i = 0; i < people.length; i++) {
            counter[people[i]]++;
        }

        int k = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j < counter[i]; j++) {
                people[k++] = i;
            }
        }


        return people;
    }


}
