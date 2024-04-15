package Binary_Search_Tree_to_Greater_Sum_Tree_1038;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

    }

    public static TreeNode bstToGst(TreeNode root) {

        List<Integer> list1 = new ArrayList<>();
        collectValues(root, list1);
        return root;
    }

    // 8, 7, 6, 5, 4, 3, 2, 1, 0
    //
    private static void collectValues(TreeNode root, List<Integer> values){

        if(root.right != null){
            collectValues(root.right, values);
        }
        values.add(root.val);
        if(values.size() != 1){
            int val = values.get(values.size()-2) + root.val;
            values.set(values.size()-1, val);
            root.val = val;
        }
        if(root.left != null){
            collectValues(root.left, values);
        }
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
