package Smallest_Number_in_Infinite_Set_2336;

import java.util.TreeSet;

class SmallestInfiniteSet {

    private TreeSet<Integer> added;
    private int pointer=1;
    public SmallestInfiniteSet() {
        added = new TreeSet<>();
    }

    public int popSmallest() {
        if(!added.isEmpty() && added.first() <= pointer){
            return added.pollFirst();
        }
        return pointer++;
    }

    public void addBack(int num) {
        if(num < pointer)
            added.add(num);
    }
}

public class Solution {

    public static void main(String[] args) {

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        int c = smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(c);
        c = smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
        System.out.println(c);
        c = smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
        System.out.println(c);
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        c = smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
        System.out.println(c);
        c = smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
        System.out.println(c);
        c = smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
        System.out.println(c);
    }


}
