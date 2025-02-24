package Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889;

public class Solution {


    public static void main(String[] args) {

        System.out.println(constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}));
        //System.out.println(constructFromPrePost(new int[]{2, 1}, new int[]{1, 2}));
        //System.out.println(constructFromPrePost(new int[]{2, 1, 3}, new int[]{3, 1, 2}));

    }


    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return find(new int[]{0, 0}, preorder, postorder);
    }

    public static TreeNode find(int[] preAndPostIndices, int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[preAndPostIndices[0]]);

        // increase pre order index (enter)
        preAndPostIndices[0]++;

        if (node.val == postorder[preAndPostIndices[1]]) {
            preAndPostIndices[1]++;
            return node;
        }

        node.left = find(preAndPostIndices, preorder, postorder);
        if (node.val == postorder[preAndPostIndices[1]]) {
            // increase post order index (exit)
            preAndPostIndices[1]++;
            return node;
        }

        node.right = find(preAndPostIndices, preorder, postorder);
        if (node.val == postorder[preAndPostIndices[1]]) {
            // increase post order index (exit)
            preAndPostIndices[1]++;
            return node;
        }

        // decrease pre order index (node is removed)
        preAndPostIndices[0]--;
        return null;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ((left != null && left.val != 0) ? ", left=" + left : "") +
                    ((right != null && right.val != 0) ? ", right=" + right : "") +
                    '}';
        }
    }
}
