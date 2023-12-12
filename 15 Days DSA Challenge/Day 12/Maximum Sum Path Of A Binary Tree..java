public class Main {

     public static void main(String[] args) {
         BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
         root1.left = new BinaryTreeNode<>(2);
         root1.right = new BinaryTreeNode<>(3);
         root1.left.left = new BinaryTreeNode<>(4);
 
         System.out.println("Sample Output 1: " + maxPathSum(root1));
 
         BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(2);
         root2.left = new BinaryTreeNode<>(4);
         root2.right = new BinaryTreeNode<>(-1);
         root2.left.left = new BinaryTreeNode<>(3);
         root2.left.right = new BinaryTreeNode<>(6);
 
         System.out.println("Sample Output 2: " + maxPathSum(root2));
     }
 
     static class BinaryTreeNode<T> {
         public T data;
         public BinaryTreeNode<T> left;
         public BinaryTreeNode<T> right;
 
         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     }
 
     private static int maxSum;
 
     public static int maxPathSum(BinaryTreeNode<Integer> root) {
         maxSum = Integer.MIN_VALUE;
         findMaxPath(root);
         return maxSum;
     }
 
     private static int findMaxPath(BinaryTreeNode<Integer> node) {
         if (node == null) return 0;
 
         int leftSum = Math.max(0, findMaxPath(node.left));
         int rightSum = Math.max(0, findMaxPath(node.right));
 
         maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
 
         return Math.max(leftSum, rightSum) + node.data;
     }
 }
 