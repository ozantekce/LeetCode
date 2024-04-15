package Binary_Search_Tree_to_Greater_Sum_Tree_1038;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

    }

    public static TreeNode bstToGst(TreeNode root) {
        collectValues(root, 0);
        return root;
    }

    // 8, 7, 6, 5, 4, 3, 2, 1, 0
    //
    private static int collectValues(TreeNode root, int increase){

        root.val += increase;

        if(root.right != null){
            root.val += collectValues(root.right, increase) - increase;
        }

        if(root.left != null){
            return collectValues(root.left, root.val);
        }

        return root.val;
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
