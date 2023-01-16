package Binary_Tree_Pruning_814;

class TreeNode {
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

public class Solution {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);


    }

    public static TreeNode pruneTree(TreeNode root) {

        prune(root);
        if(root.right==null && root.left==null && root.val==0)
            root = null;
        return root;
    }


    public static int prune(TreeNode node){


        TreeNode left = node.left;
        TreeNode right = node.right;

        if(left==null&&right==null){
            return node.val;
        }else{
            int valLeft = 0,valRight=0, valMid = node.val;

            if(left!=null){
                valLeft = prune(left);
                if(valLeft==0)
                    node.left = null;
            }if(right!=null){
                valRight = prune(right);
                if(valRight==0)
                    node.right = null;
            }
            int val = Math.max(valLeft,Math.max(valMid,valRight));
            return val;
        }


    }


}
