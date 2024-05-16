package Evaluate_Boolean_Binary_Tree_2331;

public class Solution {


    public static void main(String[] args) {

    }


    public static boolean evaluateTree(TreeNode root) {

        if(root.val == 0) return false;
        else if(root.val == 1) return true;

        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) :
                evaluateTree(root.left) && evaluateTree(root.right);
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
