package src.com.leetcode.java.tree;

public class InorderSuccessor285 {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode x){
        TreeNode successor = null;
        TreeNode curr = root;
        while (curr != null){
            if(curr.val > x.val){
                successor  = curr;
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        return successor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right =new TreeNode(9);
        root.right.right = new TreeNode(15);
        TreeNode x = new TreeNode(8);

        PrintTreeNode.printTreeInFormat(inorderSuccessor(root,x));

    }
}
