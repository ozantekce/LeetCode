package Swim_in_Rising_Water_778;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

/*
        int [][] grid = {
                {0,1,2,3,4}
                ,{24,23,22,21,5}
                ,{12,13,14,15,16}
                ,{11,17,18,19,20}
                ,{10,9,8,7,6}
        };
*/
/*
        int [][] grid = {
                {3,2}
                ,{0,1}
        };
*/

        int[][] grid = {
                  {7, 34, 16, 12, 15, 0}
                , {10, 26, 4, 30, 1, 20}
                , {28, 27, 33, 35, 3, 8}
                , {29, 9, 13, 14, 11, 32}
                , {31, 21, 23, 24, 19, 18}
                , {22, 6, 17, 5, 2, 25}
        };



        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("--------------------------------------------------------------------------------------------");


        System.out.println(swimInWater(grid));//
        System.out.println(swimInWaterOld(grid));//

    }


    public static int swimInWater(int[][] grid) {

        if(grid.length==1){
            return grid[0][0];
        }

        Pair.pairs = new Pair[grid.length][grid.length];
        Pair.grid = grid;

        TreeSet<Pair> followQueue = new TreeSet<>();
        followQueue.add(Pair.getPair(0,1));
        followQueue.add(Pair.getPair(1,0));

        Pair.getPair(0,0).removed = true;

        Pair target = Pair.getPair(grid.length-1,grid.length-1);

        int max = grid[0][0];
        while (true){
            Pair currentPair = followQueue.pollFirst();
            currentPair.removed = true;

            max = Math.max(currentPair.value,max);
            if(currentPair == target)
                break;
            if(hasLeft(currentPair) && !Pair.getPair(currentPair.i, currentPair.j-1).removed){
                Pair temp = Pair.getPair(currentPair.i, currentPair.j-1);
                if(temp==target){
                    max = Math.max(target.value,max);
                    break;
                }
                followQueue.add(temp);
            }
            if(hasRight(currentPair)&& !Pair.getPair(currentPair.i, currentPair.j+1).removed){
                Pair temp = Pair.getPair(currentPair.i, currentPair.j+1);
                if(temp==target){
                    max = Math.max(target.value,max);
                    break;
                }
                followQueue.add(temp);
            }

            if(hasDown(currentPair)&& !Pair.getPair(currentPair.i+1, currentPair.j).removed){
                Pair temp = Pair.getPair(currentPair.i+1, currentPair.j);
                if(temp==target){
                    max = Math.max(target.value,max);
                    break;
                }
                followQueue.add(temp);
            }

            if(hasUp(currentPair)&& !Pair.getPair(currentPair.i-1, currentPair.j).removed){
                Pair temp = Pair.getPair(currentPair.i-1, currentPair.j);
                if(temp==target){
                    max = Math.max(target.value,max);
                    break;
                }
                followQueue.add(temp);
            }

        }


        return max;
    }

    private static boolean hasLeft(Pair p){
        return p.j-1>=0;
    }
    private static boolean hasRight(Pair p){
        return p.j+1<Pair.grid.length;
    }
    private static boolean hasDown(Pair p){
        return p.i+1<Pair.grid.length;
    }
    private static boolean hasUp(Pair p){
        return p.i-1>=0;
    }

    private static class Pair implements Comparable<Pair>{

        private int i;
        private int j;
        private int value;

        public boolean removed;

        public static int grid[][];
        public static Pair [][] pairs;

        private Pair(int i,int j){
            this.i = i;
            this.j = j;
            value = grid[i][j];
        }

        public static Pair getPair(int i,int j){
            if(pairs[i][j]!=null){
                return pairs[i][j];
            }else{
                Pair p = new Pair(i,j);
                pairs[i][j] = p;
                return p;
            }
        }


        @Override
        public int compareTo(Pair o) {
            if(this.value>o.value)return 1;
            if(this.value<o.value)return -1;
            return 0;
        }
    }





    public static int swimInWaterOld(int[][] grid) {

        int [] gridArea = new int[grid.length* grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                gridArea[j+ (i* grid.length)] = grid[i][j];
            }
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer,Integer> valueIndexPair = new HashMap<>();

        queue.add(gridArea[0]);
        valueIndexPair.put(gridArea[0],0);

        int max = Integer.MIN_VALUE;

        while (true){

            int currentVal = queue.poll();
            int currentIndex = valueIndexPair.get(currentVal);

            if(currentVal>max){
                max = currentVal;
            }

            //System.out.println("cv : "+currentVal);
            if(currentIndex==gridArea.length-1){
                break;
            }

            if(hasDown(currentIndex,grid.length)){

                if(!valueIndexPair.containsKey(gridArea[getDownIndex(currentIndex,grid.length)])){
                   // System.out.println("down : "+gridArea[getDownIndex(currentIndex,grid.length)]);
                    queue.add(gridArea[getDownIndex(currentIndex,grid.length)]);
                    valueIndexPair.put(gridArea[getDownIndex(currentIndex,grid.length)],getDownIndex(currentIndex,grid.length));
                }

            }
            if(hasUp(currentIndex,grid.length)){
                if(!valueIndexPair.containsKey(gridArea[getUpIndex(currentIndex,grid.length)])){
                    //System.out.println("up : "+gridArea[getUpIndex(currentIndex,grid.length)]);
                    queue.add(gridArea[getUpIndex(currentIndex,grid.length)]);
                    valueIndexPair.put(gridArea[getUpIndex(currentIndex,grid.length)],getUpIndex(currentIndex,grid.length));
                }

            }
            if(hasRight(currentIndex,grid.length)){
                if(!valueIndexPair.containsKey(gridArea[getRightIndex(currentIndex)])){
                    //System.out.println("right : "+gridArea[getRightIndex(currentIndex)]);
                    queue.add(gridArea[getRightIndex(currentIndex)]);
                    valueIndexPair.put(gridArea[getRightIndex(currentIndex)],getRightIndex(currentIndex));
                }
            }
            if(hasLeft(currentIndex,grid.length)){
                if(!valueIndexPair.containsKey(gridArea[getLeftIndex(currentIndex)])){
                    //System.out.println("left : "+gridArea[getLeftIndex(currentIndex)]);
                    queue.add(gridArea[getLeftIndex(currentIndex)]);
                    valueIndexPair.put(gridArea[getLeftIndex(currentIndex)],getLeftIndex(currentIndex));
                }

            }
            //System.out.println(queue);



        }



        return max;
    }

    //6 6 6 6
    //6,6,6 6

    private static boolean hasLeft(int index,int mul){
        return (index%mul)-1>=0;
    }
    private static boolean hasRight(int index,int mul){
        return (index%mul)+1<mul;
    }
    private static boolean hasUp(int index,int mul){

        return index>=mul;
    }

    private static boolean hasDown(int index,int mul){
        return (index+mul)/mul<mul;
    }


    private static int getLeftIndex(int index){
        return index-1;
    }
    private static int getRightIndex(int index){
        return index+1;
    }
    private static  int getUpIndex(int index,int mul){
        return  index - mul;
    }
    private static int getDownIndex(int index,int mul){
        return index + mul;
    }

}