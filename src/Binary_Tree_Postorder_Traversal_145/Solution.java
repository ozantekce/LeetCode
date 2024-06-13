package Binary_Tree_Postorder_Traversal_145;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }


    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }


    public static void recursive(TreeNode root, List<Integer> list){

        if(root == null)
            return;

        recursive(root.left, list);
        recursive(root.right, list);
        list.add(root.val);
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
