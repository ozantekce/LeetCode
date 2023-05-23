package Average_Salary_Excluding_the_Minimum_and_Maximum_Salary_1491;

public class Solution {


    public static void main(String[] args) {

        System.out.println(average(new int[]{4000,3000,1000,2000}));
        System.out.println(average(new int[]{1000,2000,3000}));
        System.out.println(average(new int[]{8000,9000,2000,3000,6000,1000}));

    }

    public static double average(int[] salary) {

        int max,min;
        max = min = salary[0];
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            max = Math.max(max,salary[i]);
            min = Math.min(min,salary[i]);
            sum += salary[i];
        }

        return (sum - max - min)/(salary.length-2);
    }


}
