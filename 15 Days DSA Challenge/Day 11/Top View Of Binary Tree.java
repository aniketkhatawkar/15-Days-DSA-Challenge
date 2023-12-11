import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        List<Integer> result = getTopView(root);
        System.out.println("Top View: " + result);
    }

    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> topView = new ArrayList<>();
        if (root == null) {
            return topView;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap to maintain the order of keys

        queue.offer(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode currentNode = queue.poll();
            TreeNode node = currentNode.node;
            int horizontalDistance = currentNode.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, node.data); // Only add the first node encountered at each horizontal distance
            }

            if (node.left != null) {
                queue.offer(new QueueNode(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.offer(new QueueNode(node.right, horizontalDistance + 1));
            }
        }

        for (int value : map.values()) {
            topView.add(value);
        }

        return topView;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class QueueNode {
    TreeNode node;
    int horizontalDistance;

    QueueNode(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}