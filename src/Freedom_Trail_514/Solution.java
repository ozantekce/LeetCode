package Freedom_Trail_514;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findRotateSteps("godding","gd"));
        System.out.println(findRotateSteps("godding","godding"));

    }


    // g o d d i n g
    // g o d d i n g

    private static int [][] Memory;

    public static int findRotateSteps(String ring, String key) {
        Memory = new int[ring.length()][key.length()];
        return recursive(0,0,ring,key);
    }


    private static int recursive(int i, int j, String ring, String key){

        if(j == key.length()){
            return 0;
        }
        else if(Memory[i][j] != 0){
            return Memory[i][j];
        }

        // find in right side
        int rightSizeIndex = i;
        int rightSizeSteps = 1; // for press
        for (int k = 0; k < ring.length(); k++) {
            int index = (i + k) % ring.length();
            if(ring.charAt(index) == key.charAt(j)){
                rightSizeIndex = index;
                rightSizeSteps += k;
                break;
            }
        }


        // find in left side
        int leftSizeIndex = i;
        int leftSizeSteps = 1; // for press
        for (int k = 0; k < ring.length(); k++) {
            int index = (i - k + ring.length()) % ring.length();
            if(ring.charAt(index) == key.charAt(j)){
                leftSizeIndex = index;
                leftSizeSteps += k;
                break;
            }
        }

        int rightSideCost = rightSizeSteps + recursive(rightSizeIndex, j+1, ring, key);
        int leftSideCost =  leftSizeSteps  + recursive(leftSizeIndex, j+1, ring, key);
        Memory[i][j] = Math.min(rightSideCost, leftSideCost);
        return Memory[i][j];
    }



}
