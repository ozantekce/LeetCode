package Most_Profit_Assigning_Work_826;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));

    }


    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Arrays.sort(worker);
        Work[] works = new Work[difficulty.length];
        int size = 0;
        for (int i = 0; i < difficulty.length; i++) {
            if(worker[worker.length-1]>=difficulty[i]){
                works[size] = new Work(difficulty[i],profit[i]);
                size++;
            }
        }
        Arrays.sort(works,0,size);
        int result = 0;

        int f;
        int l=worker.length;

        for (int i = 0; i < size; i++) {

            Work current = works[i];

            if(current.dif>worker[l-1])
                continue;

            int recordL=l;
            f= 0;
            int mid;
            int best = -1;
            while (f<=l && f<recordL){
                mid = (l+f)/2;
                if(worker[mid] >= current.dif){
                    l = mid-1;
                    best = mid;
                }else{
                    f = mid+1;
                }
            }
            if(best!=-1){
                l = best;
                result += (current.pro*(recordL-l));
                if(l==0)
                    break;
            }else{
                l=recordL;
            }
        }

        return result;
    }


    private static class Work implements Comparable<Work>{

        private int dif;
        private int pro;

        public Work(int dif, int pro) {
            this.dif = dif;
            this.pro = pro;
        }

        @Override
        public int compareTo(Work o) {
            if(this.pro>o.pro) return -1;
            if(this.pro<o.pro) return +1;
            return 0;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "dif=" + dif +
                    ", pro=" + pro +
                    '}';
        }
    }





}
