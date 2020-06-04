package net.etfbl.leetcode.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTree {

	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  private TreeNode root;
	  
	  public BinaryTree(TreeNode root) {
		  this.root = root;
	  }
	  
	  public int getMaxDepth() {
		  if (root == null)
			  return 0;

		  Stack<TreeNode> stack = new Stack<>();
		  Map<TreeNode, Integer> levels = new HashMap<>();
		  stack.push(root);
		  levels.put(root, 1);

		  TreeNode temp = null;		  
		  while (!stack.isEmpty()) {
			  temp = stack.pop();

			  if (temp.left != null) {
				  stack.push(temp.left);
				  levels.put(temp.left, levels.get(temp) + 1);
			  }
			  if (temp.right != null) {
				  stack.push(temp.right);
				  levels.put(temp.right, levels.get(temp) + 1);
			  }
		  }
		  
		  return levels.values().stream().max(Comparator.naturalOrder()).orElse(0);
	  }
	  
	  private int maxDepth;
	  
	  public int getMaxDepthRec() {
		  if (root == null)
			  return 0;
		  
		  getMaxDepthRec(root, 1);
		  
		  return maxDepth;
	  }
	  
	  private void getMaxDepthRec(TreeNode localRoot, int depth) {
		  /* leaf */
		  if (localRoot.left == null && localRoot.right == null)
			  maxDepth = (depth > maxDepth)? depth : maxDepth;
		  
		  if (localRoot.left != null)
			  getMaxDepthRec(localRoot.left, depth + 1);
		  if (localRoot.right != null)
			  getMaxDepthRec(localRoot.right, depth + 1);
	  }
	  
	  public static void main(String[] args) {
		  TreeNode root = new TreeNode(3);
		  TreeNode left = new TreeNode(9);
		  TreeNode leaf1 = new TreeNode(15);
		  TreeNode leaf2 = new TreeNode(7);
		  TreeNode right = new TreeNode(20);
		  right.left = leaf1;
		  right.right = leaf2;
		  
		  root.left = left;
		  root.right = right;
		  
		  BinaryTree tree = new BinaryTree(root);
		  
		  System.out.println(tree.getMaxDepthRec());
		  
	  }
	 

}