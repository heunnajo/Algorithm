package java_basic;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
//		int[] nums = {0,0};
//		int[] nums = {9,9,9};
//		int[] nums = {9,8,9};
//		int[] nums = {1,2,9,9};
//		int[] nums = {0,0,1};
		System.out.println(plusOne(nums));
	}
	public static int[] plusOne(int[] digits) {
        //0. 담을 그릇 생성
        int carry = 1;
        int index = digits.length-1;
        //1. 기저 사례 제외
        
        //2. 반복문 돌리기. 알고리즘 돌리기.
        while(index >= 0 && carry > 0) {
            digits[index] = (digits[index]+1)%10;//1의 자리만을 저장할 것이기 때문에!!
            if(digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;//반복문 탈출!
            }
            
            --index;
        }
        
        //예외. carry=1인데 반복문을 탈출한 경우!(새로운 자리가 필요한 경우)
        if(carry == 1) {
            digits = new int[digits.length+1];//[0,0,0,0]
            digits[0] = 1;
        }
        return digits;
    }

}
