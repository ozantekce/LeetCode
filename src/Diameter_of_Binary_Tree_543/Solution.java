package Diameter_of_Binary_Tree_543;

import java.util.Dictionary;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

    }

    public static int Res = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        Res = 0;
        find(root);
        return Res;
    }

    public static int find(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        int fromLeft = left != null ? find(left) + 1 : 0;
        int fromRight = right != null ? find(right) + 1 : 0;

        Res = Math.max(fromLeft + fromRight, Res);

        return Math.max(fromLeft, fromRight);
    }



    public class TreeNode {
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
