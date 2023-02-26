package Path_Sum_112;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

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


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root,22));

    }



    public static boolean hasPathSum(TreeNode root, int targetSum) {

     if(root==null){
         return false;
     }
     if(root.right==null && root.left ==null){
         return targetSum==root.val;
     }
     boolean b1 = false;
     boolean b2 = false;

     if(root.left!=null){
         root.left.val+=root.val;
         b1 = hasPathSum(root.left,targetSum);
     }
     if(root.right!=null){
         root.right.val+=root.val;
         b2 = hasPathSum(root.right,targetSum);
     }

     return b1 || b2;

    }




    /*
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null)
            return false;
        Queue<TreeNode> frontier = new ArrayDeque<>();
        frontier.add(root);

        while (!frontier.isEmpty()){

            TreeNode current = frontier.poll();
            TreeNode left = current.left;
            TreeNode right = current.right;
            if(left==null&&right==null){
                if(current.val==targetSum){
                    return true;
                }
                continue;
            }
            if(left!=null){
                left.val += current.val;
                frontier.add(left);
            }
            if(right != null){
                right.val += current.val;
                frontier.add(right);
            }

        }

        return false;
    }
*/

}
