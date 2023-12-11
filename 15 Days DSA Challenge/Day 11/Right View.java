import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        
    }

    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            BinaryTreeNode<Integer> rightMost = null;

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<Integer> node = queue.poll();

                // Capture the rightmost node at each level
                if (i == levelSize - 1) {
                    rightMost = node;
                }

                // Add children to the queue for the next level traversal
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add the rightmost node value to the result
            if (rightMost != null) {
                rightView.add(rightMost.data);
            }
        }
        return rightView;
    }
}
