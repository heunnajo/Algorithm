package linkedlist;
import java.util.*;

class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2() {}
	ListNode2(int a) {val = a;}
	ListNode2(int a, ListNode2 next) {this.val = a; this.next = next;}
}
public class ReverseList {

	public static void main(String[] args) {
		ListNode2 ln = new ListNode2(1);
		ln.next = new ListNode2(2);
		ln.next.next = new ListNode2(3);
		ln.next.next.next = new ListNode2(4);
		ln.next.next.next.next = new ListNode2(5);
		
		ListNode2 result = solve(ln);
		print(result);
		
	}

	public static void print(ListNode2 result) {
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static ListNode2 solve(ListNode2 ln) {
		ListNode2 curr = ln;
        ListNode2 prev = null;
        
        while(curr != null) {
            ListNode2 nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;//제일 끝 노드를 가리킨다!
	}

}
