package Count_Total_Number_of_Colored_Cells_2579;

public class Solution {

    public long coloredCells(int n) {
        long l = n;
        return (l*l)+((l-1)*(l-1));
    }

}
