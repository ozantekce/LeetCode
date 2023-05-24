package Find_Winner_on_a_Tic_Tac_Toe_Game_1275;

public class Solution {


    public static void main(String[] args) {

        System.out.println(tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));
        System.out.println(tictactoe(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));
        System.out.println(tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
        System.out.println(tictactoe(new int[][]{{0,0},{1,1}}));

    }


    public static String tictactoe(int[][] moves) {

        int [][] gameBoard = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            int val = (i%2==0)? +1:-1;
            int x = moves[i][0];
            int y = moves[i][1];
            gameBoard[x][y] = val;
        }

        boolean gameOver;
        for (int i = 0; i < 3; i++) {
            gameOver = gameBoard[i][0]!=0 && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2];
            if(gameOver) return gameBoard[i][0]==+1? "A":"B";
            gameOver = gameBoard[0][i]!=0 && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i];
            if(gameOver) return gameBoard[0][i]==+1? "A":"B";
        }

        gameOver = gameBoard[1][1]!=0 && gameBoard[0][0] == gameBoard[1][1]  && gameBoard[0][0] == gameBoard[2][2];
        if(gameOver) return gameBoard[1][1]==+1? "A":"B";
        gameOver = gameBoard[1][1]!=0 && gameBoard[0][2] == gameBoard[1][1]  && gameBoard[0][2] == gameBoard[2][0];
        if(gameOver) return gameBoard[1][1]==+1? "A":"B";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gameBoard[i][j]==0)return "Pending";
            }
        }

        return "Draw";
    }


}
