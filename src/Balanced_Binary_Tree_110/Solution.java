package Balanced_Binary_Tree_110;

public class Solution {


    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        return depth(root) != -1;
    }


    private static int depth(TreeNode root){
        if(root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int depthLeft = depth(left);
        int depthRight = depth(right);
        if(depthLeft == -1 || depthRight == -1 || Math.abs(depthLeft - depthRight) > 1)
            return -1;
        return Math.max(depthLeft+1, depthRight+1);
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
