package java_basic;

public class TrappingWater {

	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));
	}
	public static int trap(int[] height) {
        int result = 0;
        //0.기저사례 제외!
        if(height==null || height.length <= 2)
            return result;
        //1.담을 그릇 생성
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        
        //2. left와 right 배열에 데이터 넣기
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i< height.length; i++) {
            if(max < height[i]) {
                max = height[i];
                left[i] = height[i];
            }
            else {
                left[i] = max;
            }
        }
        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i >= 0; i--) {
            if(max < height[i]) {
                max = height[i];
                right[i] = height[i];
            }
            else {
                right[i] = max;
            }
        }
        //3. left와 right 둘중 작은 값을 선택!
        //자신의 높이만큼 뺀 값들을 더한 것이 result가 된다!
        for(int i=0;i < height.length;i++) {
            result += Math.min(left[i],right[i]) - height[i];
        }
        return result;
    }

}
