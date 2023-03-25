package Find_Score_of_an_Array_After_Marking_All_Elements_593;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(findScore(new int[]{2,1,3,4,5,2}));  //7
        System.out.println(findScore(new int[]{2,3,5,1,3,2}));  //5

    }


    public static long findScore(int[] nums) {

        Node[] nodes = new Node[nums.length];
        Node[] nodesSorted = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(i,nums[i]);
            nodesSorted[i] = nodes[i];
        }
        Arrays.sort(nodesSorted);
        int p = 0;
        long result = 0;
        while (p<nums.length){
            Node current = nodesSorted[p];
            if(!current.isMarked){
                current.isMarked=true;
                result+=current.value;
                int index = current.index;
                if(index-1>=0 && !nodes[index-1].isMarked)nodes[index-1].isMarked=true;
                if(index+1<= nums.length-1 && !nodes[index+1].isMarked)nodes[index+1].isMarked=true;
            }
            p++;
        }

        return result;
    }




    private static class Node implements Comparable<Node>{

        private int index;
        private int value;
        private boolean isMarked;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }



        @Override
        public int compareTo(Node o) {
            if(this.value>o.value)return 1;
            else if(this.value<o.value) return -1;
            return 0;
        }


        @Override
        public String toString() {
            return "N{" +
                    "v=" + value +
                    ", isM=" + isMarked +
                    '}';
        }
    }


}
