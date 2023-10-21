package src.com.leetcode.java.tree;

import java.util.LinkedList;
import java.util.Queue;

public interface PrintTree {
    public static void printTreeInFormat(Node root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder result = new StringBuilder("[");

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean levelHasNonNull = false;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current != null) {
                    result.append(current.val);
                    levelHasNonNull = true;
                } else {
                    result.append("null");
                }

                if (i < levelSize - 1 || (i == levelSize - 1 && levelHasNonNull)) {
                    result.append(",");
                }

                if (current != null) {
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }

        result.append("]");
        System.out.println(result.toString());
    }

}
