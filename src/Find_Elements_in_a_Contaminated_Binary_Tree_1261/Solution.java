package Find_Elements_in_a_Contaminated_Binary_Tree_1261;

import java.util.HashSet;

public class Solution {


    class FindElements {

        private HashSet<Integer> values;

        public FindElements(TreeNode root) {
            values = new HashSet<>();
            root.val = 0;
            recover(root);
        }

        private void recover(TreeNode node) {
            int val = node.val;
            values.add(val);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                left.val = 2 * val + 1;
                recover(left);
            }
            if (right != null) {
                right.val = 2 * val + 2;
                recover(right);
            }
        }

        public boolean find(int target) {
            return values.contains(target);
        }
    }


    public class TreeNode {
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
