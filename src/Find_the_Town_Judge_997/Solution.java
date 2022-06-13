package Find_the_Town_Judge_997;

public class Solution {


    public static int findJudge(int N, int[][] trust) {

        int giren [] = new int[N];
        int cikan [] = new int[N];


        for (int i = 0; i < trust.length; i++) {

            int s = trust[i][0]-1;
            int t = trust[i][1]-1;

            cikan[s]++;

            giren[t]++;

        }


        int judge = -1;

        for (int i = 0; i < N; i++) {

            boolean con = cikan[i]==0 && giren[i] == N-1;

            if(con){

                if(judge==-1){
                    judge=(i+1);
                }
                else return -1;
            }


        }


        return judge;
    }

}
