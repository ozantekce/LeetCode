package Nim_Game_292;

public class Solution {

    public boolean canWinNim(int n) {

        if(n<4)
            return true;
        else if(n%4==0)
            return false;

        return true;
    }

}
