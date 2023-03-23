package Cousins_in_Binary_Tree_993;

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


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(isCousins(root,4,3));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root,5,4));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(isCousins(root,3,6));


    }


    public static boolean isCousins(TreeNode root, int x, int y) {
        xFinded = false;
        yFinded = false;
        maxDepth = -1;
        find(null,root,x,y,0);
        return xFinded && yFinded && yDepth==xDepth && xParent!=yParent;
    }

    private static int maxDepth = -1;
    private static TreeNode xParent;
    private static int xDepth = 0;
    private static TreeNode yParent;
    private static int yDepth = 0;

    private static boolean xFinded;
    private static boolean yFinded;
    public static void find(TreeNode parent,TreeNode node,int x,int y,int depth){

        if( (xFinded && yFinded) || (maxDepth!=-1  && depth>maxDepth)){return;}

        if(!xFinded && node.val == x){
            xDepth = depth;
            xParent = parent;
            xFinded = true;
            maxDepth = depth;
        }
        if(!yFinded && node.val == y){
            yDepth = depth;
            yParent = parent;
            yFinded = true;
            maxDepth = depth;
        }

        if(node.left!=null){find(node,node.left,x,y,depth+1);}
        if(node.right!=null){find(node,node.right,x,y,depth+1);}


    }

}
