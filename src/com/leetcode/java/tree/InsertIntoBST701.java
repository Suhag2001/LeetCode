package src.com.leetcode.java.tree;

//701. Insert into a Binary Search Tree
public class InsertIntoBST701 {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val> root.val){
            root.right= insertIntoBST(root.right, val);
        }else if(val<root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(7);

        PrintTreeNode.printTreeInFormat(root);
        PrintTreeNode.printTreeInFormat(insertIntoBST(root,8 ));
    }
}
