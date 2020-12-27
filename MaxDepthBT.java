package graph;
import java.util.*;

class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
public class MaxDepthBT {//recursive call

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.left.left.left = new TreeNode(7);
		
		System.out.println(solve(root));
	}
	
	public static int solve(TreeNode root) {
		if(root == null) return 0;
		
		int left = solve(root.left);
		int right = solve(root.right);
		return Math.max(left, right)+1;
	}

}
