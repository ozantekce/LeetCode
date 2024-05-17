package Delete_Leaves_With_a_Given_Value_1325;

public class Solution {

    public static void main(String[] args) {

    }



    public static TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null){
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left == null && right == null){
            if(root.val == target)
                return null;
            else
                return root;
        }

        root = new TreeNode(root.val, removeLeafNodes(left, target), removeLeafNodes(right, target));
        left = root.left;
        right = root.right;
        if(left == null && right == null){
            if(root.val == target)
                return null;
        }

        return root;
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
