package Sort_the_People_2418;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        String [] names ={"Mary","John","Emma"};
        int [] heights = {180,165,170};

        System.out.println(Arrays.toString(sortPeople(names,heights)));

    }


    public static String[] sortPeople(String[] names, int[] heights) {

        NameHeightPair[] nameHeightPairs = new NameHeightPair[heights.length];
        for (int i = 0; i < heights.length; i++) {
            nameHeightPairs[i] = new NameHeightPair(names[i],heights[i]);
        }
        Arrays.sort(nameHeightPairs);
        for (int i = 0; i < names.length; i++) {
            names[i] = nameHeightPairs[i].name;
        }

        return names;
    }

    private static class NameHeightPair implements Comparable<NameHeightPair>{

        public String name;
        public int height;

        public NameHeightPair(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(NameHeightPair o) {
            if(o.height>this.height)
                return 1;
            else if(o.height<this.height)
                return -1;

            return 0;
        }
    }


}
