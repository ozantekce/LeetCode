package Leaf_Similar_Trees_872;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }



    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        leafIndex = 0;
        List<Integer> leavesValues = new ArrayList<>();
        collectLeaves(root1, leavesValues);
        return compareLeaves(root2, leavesValues) && leafIndex == leavesValues.size();
    }


    private static void collectLeaves(TreeNode root, List<Integer> values){

        if(root == null)
            return;
        if(root.left == null && root.right == null){
            values.add(root.val);
            return;
        }

        collectLeaves(root.left, values);
        collectLeaves(root.right, values);
    }

    private static int leafIndex = 0;
    private static boolean compareLeaves(TreeNode root, List<Integer> values){

        if(root == null)
            return true;

        if(root.left == null && root.right == null){
            if(values.size() <= leafIndex)
                return false;
            return values.get(leafIndex++) == root.val;
        }

        return compareLeaves(root.left, values) && compareLeaves(root.right, values);

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
