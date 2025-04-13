package Sum_of_Nodes_with_Even_Valued_Grandparent_1315;

public class Solution {


    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        return find(root, null, null);
    }

    private static int find(TreeNode root, TreeNode parent, TreeNode grantParent) {
        if (root == null)
            return 0;

        int res = 0;
        if (grantParent != null && grantParent.val % 2 == 0) {
            res += root.val;
        }

        return res + find(root.left, root, parent) + find(root.right, root, parent);

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
