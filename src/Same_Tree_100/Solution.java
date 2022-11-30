package Same_Tree_100;

public class Solution {

    public static void main(String[] args) {
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameNode(p,q);
    }

    public boolean sameNode(TreeNode p, TreeNode q){

        if(p==null&&q!=null){
            return false;
        }
        else if(p!=null&&q==null){
            return false;
        }else if(p==null&&q==null){
            return true;
        }
        else if(p.val!=q.val){
            return false;
        }else{
            return sameNode(p.left,q.left) && sameNode(p.right,q.right);
        }

    }

    public class TreeNode {
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
