import java.util.*;
class Tnode{
	int left,right;
	Tnode(int left,int  right){
		this.left = left;
		this.right = right;
	}
}
public class TreeTraversal {
	static void preorder(Tnode[] a,int x) {
		if(x == -1) return;
		System.out.print((char)(x+'A'));
		preorder(a,a[x].left);
		preorder(a,a[x].right);
	}
	static void inorder(Tnode[] a,int x) {
		if(x==-1) return;
		inorder(a,a[x].left);
		System.out.print((char)(x+'A'));
		inorder(a,a[x].right);
	}
	static void postorder(Tnode[] a,int x) {
		if(x==-1) return;
		postorder(a,a[x].left);
		postorder(a,a[x].right);
		System.out.print((char)(x+'A'));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Tnode[] a = new Tnode[26];
		for(int i=0;i<n;i++) {
			int x = sc.next().charAt(0)-'A';
			int y = sc.next().charAt(0);
			int z = sc.next().charAt(0);
			int left = -1;
			int right = -1;
			if(y != '.') {
				left = y-'A';
			}
			if(z != '.') {
				right = z-'A';
			}
			a[x] = new Tnode(left,right);
		}
		preorder(a,0);
		System.out.println();
		inorder(a,0);
		System.out.println();
		postorder(a,0);
		System.out.println();
	}

}