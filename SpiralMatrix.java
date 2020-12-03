package java_basic;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}
    public static List<Integer> spiralOrder(int[][] matrix) {
        //1. 그릇 생성
        int rowStart = 0,colStart = 0;
        int rowEnd = matrix.length-1;//3-1=2.
        int colEnd = matrix[0].length-1;//4-1=3.
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            //right. 행고정, 열증가
            for(int i=colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            //down. 열고정, 행증가
            for(int i=rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            //left. 행고정, 열감소!
            if(rowStart <= rowEnd) {
                for(int i=colEnd; i >= colStart ;i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;//rowStart < rowEnd!!!
            //up. 열고정, 행감소!
            if(colStart <= colEnd) {
                if(rowStart <= rowEnd) {
                    for(int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colStart]);
                    }
                }
            }
            colStart++;//colStart < colEnd!!!
            // //2nd right. 행고정, 열증가!
            // for(int i= colStart; i <= colEnd ; i++) {
            //     result.add(matrix[rowStart][i]);
            // }
      }  
        return result;
    }
	
}
