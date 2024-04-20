package Symmetric_Tree_101;

public class Solution {


    public static void main(String[] args) {

    }


    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return recursive(root.left, root.right);
    }


    public boolean recursive(TreeNode rootLeft, TreeNode rootRight) {

        if(rootLeft == null || rootRight == null){
            return rootLeft == rootRight;
        }

        if(rootLeft.val != rootRight.val){
            return false;
        }

        return  recursive(rootLeft.right, rootRight.left)
                && recursive(rootLeft.left, rootRight.right);

    }

    public static boolean iterative(){

        return false;
    }




    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
