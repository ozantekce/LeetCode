package Symmetric_Tree_101;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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

    public boolean iterative(TreeNode rootLeft, TreeNode rootRight){

        if(rootLeft == null || rootRight == null){
            return rootLeft == rootRight;
        }

        Stack<TreeNode> frontier = new Stack<>();

        frontier.add(rootLeft);
        frontier.add(rootRight);

        while (!frontier.isEmpty()){

            TreeNode currentLeft = frontier.pop();
            TreeNode currentRight = frontier.pop();

            if(currentLeft.val != currentRight.val)
                return false;

            if(currentLeft.left == null || currentRight.right == null){
                if(currentLeft.left != currentRight.right)
                    return false;
            }else{
                frontier.add(currentLeft.left);
                frontier.add(currentRight.right);
            }

            if(currentLeft.right == null || currentRight.left == null){
                if(currentLeft.right != currentRight.left)
                    return false;
            }else{
                frontier.add(currentLeft.right);
                frontier.add(currentRight.left);
            }


        }

        return true;
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
