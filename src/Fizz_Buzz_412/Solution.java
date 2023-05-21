package Fizz_Buzz_412;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));

    }


    public static List<String> fizzBuzz(int n) {

        ArrayList<String> arrayList = new ArrayList<>(n);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            boolean c1 = i%3==0;
            boolean c2 = i%5==0;
            if(c1 && c2)arrayList.add("FizzBuzz");
            else if(c1)arrayList.add("Fizz");
            else if(c2)arrayList.add("Buzz");
            else {
                sb.append(i);
                arrayList.add(sb.toString());
                sb.setLength(0);
            }

        }

        return arrayList;
    }

}
