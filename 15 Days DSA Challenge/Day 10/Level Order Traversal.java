import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

    }

    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        //Your code goes here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode node = queue.poll();
                result.add((Integer)node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
