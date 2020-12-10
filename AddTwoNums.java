package java_basic;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNums {
	 //Definition for singly-linked list.
	 
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(2);
		
		ListNode result = addTwoNumbers(l1,l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.자료구조 생성
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;//정답이 되는 curr링크드리스트의 주소는 더미노드 주소로 고정!
		ListNode p = l1, q = l2;
        int carry = 0, sum = 0;
        
        //2.자릿수별로 더해서 sum을 저장한다!
        while(p != null || q != null) {//p가 null이 아니거나 q가 null이 아니라면(둘 중 하나라도 null이 아니면)
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            sum = x+y+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p.next != null) p = p.next;
            if(q.next != null) q = q.next;   
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
