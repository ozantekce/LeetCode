package Destination_City_1436;

import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


    }


    public String destCity(List<List<String>> paths) {

        HashSet<String> city0s = new HashSet<>();

        for (int i = 0; i < paths.size(); i++) {
            String city0 = paths.get(i).get(0);
            city0s.add(city0);
        }

        for (int i = 0; i < paths.size(); i++) {
            String city1 = paths.get(i).get(1);
            if(!city0s.contains(city1))
                return city1;
        }

        return "";
    }


}
