package SumofLeftLeaves_404;

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


    }

    public int sumOfLeftLeaves(TreeNode root) {

        return recursive(false,root);
    }


    public int recursive(boolean isLeft,TreeNode current){

        TreeNode left = current.left;
        TreeNode right = current.right;
        if(left==null && right==null){
           if(isLeft){
               return current.val;
           }else{
               return 0;
           }
        }else if(right!=null && left!=null){
            return recursive(false,right) + recursive(true,left);
        }else if(right!=null){
            return recursive(false,right);
        }else{
            return recursive(true,left);
        }

    }


}
