package stack;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {this.val = x;}
	//TreeNode(int x, TreeNode left, TreeNode right) {this.val = x; this.left = left; this.right = right;}
}
public class BT_LevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		solve(root);
	}

	public static List<List<Integer>> solve(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			//큐 크기 체크! 
			int size = queue.size();
			//정답 담을 그릇 생성 
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++) {
				TreeNode node = queue.poll();//3삭제. 큐는 비어있지만 아래에서 left와 right로 다시 채워짐! 
				list.add(node.val);//3
				if(node.left != null) {
					queue.offer(node.left);//4
				}
				if(node.right != null) {
					queue.offer(node.right);//5
				}
			}
			result.add(list);
		}
		return result;
	}

}
