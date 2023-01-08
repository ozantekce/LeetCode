package Assign_Cookies_455;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {


        System.out.println(findContentChildren(
                new int[]{262,437,433,102,438,346,131,160,281,34,219,373,466,275,51,118,209,32,108,57,385,514,439,73,271,442,366,515,284,425,491,466,322,34,484,231,450,355,106,279,496,312,96,461,446,422,143,98,444,461,142,234,416,45,271,344,446,364,216,16,431,370,120,463,377,106,113,406,406,481,304,41,2,174,81,220,158,104,119,95,479,323,145,205,218,482,345,324,253,368,214,379,343,375,134,145,268,56,206}
                ,new int[]{149,79,388,251,417,82,233,377,95,309,418,400,501,349,348,400,461,495,104,330,155,483,334,436,512,232,511,40,343,334,307,56,164,276,399,337,59,440,3,458,417,291,354,419,516,4,370,106,469,254,274,163,345,513,130,292,330,198,142,95,18,295,126,131,339,171,347,199,244,428,383,43,315,353,91,289,466,178,425,112,420,85,159,360,241,300,295,285,310,76,69,297,155,416,333,416,226,262,63,445,77,151,368,406,171,13,198,30,446,142,329,245,505,238,352,113,485,296,337,507,91,437,366,511,414,46,78,399,283,106,202,494,380,479,522,479,438,21,130,293,422,440,71,321,446,358,39,447,427,6,33,429,324,76,396,444,519,159,45,403,243,251,373,251,23,140,7,356,194,499,276,251,311,10,147,30,276,430,151,519,36,354,162,451,524,312,447,77,170,428,23,283,249,466,39,58,424,68,481,2,173,179,382,334,430,84,151,293,95,522,358,505,63,524,143,119,325,401,6,361,284,418,169,256,221,330,23,72,185,376,515,84,319,27,66,497}
        )
        );

    }


    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(s);
        Arrays.sort(g);
        int counter = 0;

        int childIndex = 0;
        for (int i = 0; i < s.length; i++) {

            if(s[i]>=g[childIndex]){
                childIndex++;
                counter++;
            }
            if(childIndex>=g.length){
                break;
            }

        }

        return counter;
    }


    /*
    public static int findContentChildren(int[] g, int[] s) {
        int counter = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        Queue<Integer> greedyQueue = new ArrayDeque<>();
        Queue<Integer> cookieQueue = new ArrayDeque<>();

        for (int i = 0; i < g.length; i++) {
            greedyQueue.add(g[i]);
        }
        for (int i = 0; i < s.length; i++) {
            cookieQueue.add(s[i]);
        }

        while (!cookieQueue.isEmpty() && !greedyQueue.isEmpty()){

            int c = cookieQueue.poll();
            while (!greedyQueue.isEmpty()){
                int gr = greedyQueue.peek();
                //System.out.println("gr : "+gr+" c : "+c);
                if(c<gr){
                    break;
                }
                if(gr<=c){
                    greedyQueue.poll();
                    counter++;
                    break;
                }
            }

        }


        return counter;
    }
*/
}
