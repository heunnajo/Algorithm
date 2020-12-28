package graph;
import java.util.*;

class TreeNode2 {
	 int val;
	 TreeNode2 left;
	 TreeNode2 right;
	 TreeNode2() {}
	 TreeNode2(int val) { this.val = val; }
	 TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
	     this.val = val;
	     this.left = left;
	     this.right = right;
	 }
}
public class MaxDepthBT_BFS {

	public static void main(String[] args) {
		TreeNode2 root = new TreeNode2(3);
		root.left = new TreeNode2(1);
		root.right = new TreeNode2(4);
		root.left.left = new TreeNode2(5);
		root.left.right = new TreeNode2(8);
		root.left.left.left = new TreeNode2(7);
		
		System.out.println(solve(root));
	}

	public static int solve(TreeNode2 root) {//BFS = Queue
		if(root == null) return 0;
		//1.Queue 생성 
		Queue<TreeNode2> queue = new LinkedList<>();
		queue.offer(root);
		int maxdepth = 0;
		
		//2.반복문 돌린다! 
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode2 node = queue.poll();
				if(node.left != null) {queue.offer(node.left);}
				if(node.right != null) {queue.offer(node.right);}
			}
			maxdepth++;
		}
		return maxdepth;
	}

}
