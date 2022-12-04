package Maximum_Depth_of_Binary_Tree_104;

public class Solution {


    public static void main(String[] args) {

    }



    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return traveller(root,1);
    }

    public int traveller(TreeNode node,int depth) {

        boolean leftNotNull = node.left != null;
        boolean rightNotNull = node.right != null;

        if (leftNotNull && rightNotNull) {
            int l = traveller(node.left, depth + 1);
            int r = traveller(node.right, depth + 1);
            return Math.max(l, r);
        } else if (leftNotNull) {
            return traveller(node.left, depth + 1);
        } else if (rightNotNull) {
            return traveller(node.right, depth + 1);
        } else {
            return depth;
        }
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


}

