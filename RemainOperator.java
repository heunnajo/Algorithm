package data_structures;
import java.util.*;
public class Remains {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
//		(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
//		(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
//		1.(A+B)%C
		System.out.println((A+B)%C);
//		2.((A%C) + (B%C))%C
		System.out.println(((A%C) + (B%C))%C);
//		3.(A×B)%C
		System.out.println((A*B)%C);
//		4.(B%C))%C
		System.out.println(((A%C) * (B%C))%C);
	}

}
