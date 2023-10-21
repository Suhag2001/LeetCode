package src.com.leetcode.java.tree;

public class IsSameTree100 {
    public static boolean dfs(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;

        boolean left = dfs(p.left , q.left);
        boolean right = dfs(p.right , q.right);

        return left && right;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);


        PrintTreeNode.printTreeInFormat(root1);
        System.out.println(dfs(root1 , root2));
    }
}
