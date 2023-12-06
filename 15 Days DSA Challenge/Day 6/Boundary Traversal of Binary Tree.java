import java.util.ArrayList;
import java.util.List;

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

public class Main {
    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        result.add(root.data);
        traverseLeftBoundary(root.left, result);
        traverseLeaves(root.left, result);
        traverseLeaves(root.right, result);
        traverseRightBoundary(root.right, result);

        return result;
    }

    private static void traverseLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        result.add(node.data);
        if (node.left != null)
            traverseLeftBoundary(node.left, result);
        else
            traverseLeftBoundary(node.right, result);
    }

    private static void traverseRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        if (node.right != null)
            traverseRightBoundary(node.right, result);
        else
            traverseRightBoundary(node.left, result);

        result.add(node.data);
    }

    private static void traverseLeaves(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        traverseLeaves(node.left, result);

        if (node.left == null && node.right == null)
            result.add(node.data);

        traverseLeaves(node.right, result);
    }
}
