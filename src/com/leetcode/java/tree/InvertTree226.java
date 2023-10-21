package src.com.leetcode.java.tree;

public class InvertTree226 {

    public static TreeNode invertTree(TreeNode root) {

        if(root==null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);

        root.left = right ;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        PrintTreeNode.printTreeInFormat(root);
        PrintTreeNode.printTreeInFormat(invertTree(root));
    }
}
