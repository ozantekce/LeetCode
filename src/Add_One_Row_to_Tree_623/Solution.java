package Add_One_Row_to_Tree_623;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

    }



    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        int targetDepth = depth - 1;

        if(targetDepth == 0){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        recursive(val, root, 1, targetDepth);
        return root;
    }


    private static void recursive(int val, TreeNode current, int currentDepth, int targetDepth){

        if(currentDepth == targetDepth){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = current.left;
            current.left = newLeft;

            TreeNode newRight = new TreeNode(val);
            newRight.right = current.right;
            current.right = newRight;

        }else if(currentDepth < targetDepth){
            TreeNode left = current.left;
            if(left != null){
                recursive(val, left, currentDepth + 1, targetDepth);
            }
            TreeNode right = current.right;
            if(right != null){
                recursive(val, right, currentDepth + 1, targetDepth);
            }
        }
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
    }

}
