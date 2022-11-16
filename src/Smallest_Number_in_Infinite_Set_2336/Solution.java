package Smallest_Number_in_Infinite_Set_2336;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class SmallestInfiniteSet {

    private Set<Integer> removed;
    public SmallestInfiniteSet() {
        removed = new HashSet<>();
    }

    public int popSmallest() {
        if(removed.isEmpty()){
            removed.add(1);
            return 1;
        }else{
            if(!removed.contains(1)){
                removed.add(1);
                return 1;
            }
            for(Integer value : removed){
                if(!removed.contains(value+1)){
                    removed.add(value+1);
                    return value+1;
                }

            }

        }
        return 0;
    }

    public void addBack(int num) {
        if(removed.contains(num)){
            removed.remove(num);
        }
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
