package graph;
import java.util.*;

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3() {}
    TreeNode3(int val) { this.val = val; }
    TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaxDepthBT_DFS {//Stack!

	public static void main(String[] args) {
		TreeNode3 root = new TreeNode3(3);
		root.left = new TreeNode3(1);
		root.right = new TreeNode3(4);
		root.left.left = new TreeNode3(5);
		root.left.right = new TreeNode3(8);
		root.left.left.left = new TreeNode3(7);
		
		//System.out.println(onestack(root));
		System.out.println(twostack(root));
	}

	public static int twostack(TreeNode3 root) {
		if(root == null) return 0;
		
		//1.stack 2개 생성(노드 저장 스택, 깊이값 저장 스택) 
		Stack<TreeNode3> stack = new Stack<>();
		Stack<Integer> Vstack = new Stack<>();
		stack.push(root);
		Vstack.push(1);
		int depth = 0;
		//2.반복문 돌린다.
		while(!stack.isEmpty()) {
			int size = stack.size();
			depth = Vstack.pop();System.out.println("Depth:"+depth);
			//max = Math.max(max, depth);System.out.println("max:"+max);
			//System.out.print("Max(%d,%d)"+max+depth);
			for(int i=0;i<size;i++) {
				TreeNode3 node = stack.pop();
				if(node.left != null) {
					stack.push(node.left);
					Vstack.push(depth+1);
				}
				if(node.right != null) {
					stack.push(node.right);
					Vstack.push(depth+1);
				}
			}
		}
		return depth;
	}

	public static int onestack(TreeNode3 root) {
		if(root == null) return 0;
		
		//1.stack 생성
		Stack<TreeNode3> stack = new Stack<>();
		stack.push(root);
		int depth = 0;
		//2.반복문 돌린다!
		while(!stack.isEmpty()) {
			int size = stack.size();
			for(int i=0;i<size;i++) {
				TreeNode3 node = stack.pop();
				if(node.left != null) {stack.push(node.left);}
				if(node.right != null) {stack.push(node.right);}
			}
			depth++;
			System.out.println("depth :"+depth);
		}
		return depth;
	}
	

}
