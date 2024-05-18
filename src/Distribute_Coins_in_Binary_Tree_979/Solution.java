package Distribute_Coins_in_Binary_Tree_979;

public class Solution {


    public static void main(String[] args) {

    }

    public static int distributeCoins(TreeNode root) {
        Res = 0;
        findRes(root);
        return Res;
    }

    private static int Res;
    private static int[] findRes(TreeNode root){

        if(root == null){
            return new int[]{0,0};
        }
        int[] amountAndNeed = new int[]{root.val,1};

        TreeNode left = root.left;
        TreeNode right = root.right;

        int[] leftValues = findRes(left);
        int[] rightValues = findRes(right);

        amountAndNeed[0] += leftValues[0] + rightValues[0];
        amountAndNeed[1] += leftValues[1] + rightValues[1];
        Res += Math.abs(amountAndNeed[0] - amountAndNeed[1]);
        return amountAndNeed;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
