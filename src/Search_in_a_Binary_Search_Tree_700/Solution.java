package Search_in_a_Binary_Search_Tree_700;

public class Solution {


    public static TreeNode searchBST(TreeNode root, int val) {

        TreeNode current = root;
        while (true){

            if(current==null || current.val == val)
                break;

            if(current.val<val)
                current = current.right;
            else
                current = current.left;

        }

        return current;
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
