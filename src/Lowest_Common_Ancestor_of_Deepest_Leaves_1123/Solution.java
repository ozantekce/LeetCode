package Lowest_Common_Ancestor_of_Deepest_Leaves_1123;

public class Solution {


    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        MaxDepth = 0;
        Result = null;
        find(root, 0);
        return Result;
    }


    private static int MaxDepth;
    private static TreeNode Result;

    private static int find(TreeNode root, int depth) {

        MaxDepth = Math.max(MaxDepth, depth);

        int leftDepth = depth;
        int rightDepth = depth;

        if (root.left != null) {
            leftDepth = find(root.left, depth + 1);
        }
        if (root.right != null) {
            rightDepth = find(root.right, depth + 1);
        }

        if (leftDepth == MaxDepth && rightDepth == MaxDepth) {
            Result = root;
        }

        return Math.max(depth, Math.max(leftDepth, rightDepth));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
