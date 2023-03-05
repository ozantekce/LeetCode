package Valid_Tic_Tac_Toe_State_794;

public class Solution {


    public static void main(String[] args) {

        System.out.println(validTicTacToe(new String[]{"O  ","   ","   "}));
        System.out.println(validTicTacToe(new String[]{"XOX"," X ","   "}));
        System.out.println(validTicTacToe(new String[]{"XOX","O O","XOX"}));
        System.out.println(validTicTacToe(new String[]{"XXX","   ","OOO"}));
        System.out.println(validTicTacToe(new String[]{"XXX","XOO","OO "}));
        System.out.println(validTicTacToe(new String[]{"XO ","XO ","XO "}));
        System.out.println(validTicTacToe(new String[]{"OXX","XOX","OXO"}));

    }


    public static boolean validTicTacToe(String[] board) {
        int [] charToValue = new int[89];
        charToValue['X'] = 1;
        charToValue['O'] = -1;

        char [][] chars = new char[3][3];
        for (int i = 0; i < 3; i++)chars[i] = board[i].toCharArray();

        boolean X_Win = false, O_Win = false;

        int [] rows = new int[3];
        int [] cols = new int[3];
        int [] crosses = new int[2];

        crosses[0] =  charToValue[chars[0][0]]+charToValue[chars[1][1]]+charToValue[chars[2][2]];
        crosses[1] =  charToValue[chars[0][2]]+charToValue[chars[1][1]]+charToValue[chars[2][0]];
        if(crosses[0]==3||crosses[1]==3)X_Win=true;
        if(crosses[0]==-3||crosses[1]==-3)O_Win=true;

        int value = 0;
        // value = 0 -> X turn
        // value = 1 -> O turn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rows[i] += charToValue[chars[i][j]];
                cols[i] += charToValue[chars[j][i]];
            }
            if(rows[i]==3||cols[i]==3)X_Win=true;
            else if(rows[i]==-3||cols[i]==-3)O_Win=true;
            value+=rows[i];
            // both of them cannot win
            if(X_Win && O_Win) return false;
        }
        // value must be 0 or 1
        if(!(value==0 || value==1))return false;
        // value cannot be 0 when X Win
        if(value==0 && X_Win)return false;
        // value cannot be 1 when O Win
        if(value==1 && O_Win)return false;

        return true;
    }



}
