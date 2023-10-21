package src.com.leetcode.java.tree;

class PopulatingNext117 {
    public static Node connect(Node root) {
        if (root == null) return root;
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            Node dummy = new Node(-1);
            Node prev = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            levelStart = dummy.next;
            dummy.next = null;
        }
        return root;
    }


//    public static void printTree(Node root) {
//        if (root != null) {
//            System.out.print(root.val + " ");
//            printTree(root.left);
//            printTree(root.right);
//        }
//    }

    // Function to print the tree in the specified format excluding trailing null values


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        PrintTree.printTreeInFormat(root);

        PrintTree.printTreeInFormat(connect(root));

    }
}