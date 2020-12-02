package java_basic;

import java.util.HashMap;

public class AnagramsMapping {

	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		int [] result = anagramMappings(A, B);
		print(result);
	}
	
	public static void print(int[] result) {
		for(int i=0; i< result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	public static int[] anagramMappings(int[] A, int[] B) {
	    int leng = A.length;
	    int[] res = new int[leng];
	    HashMap<Integer,Integer> map = new HashMap<>();
	    for(int i=0;i<leng;i++){
	        map.put(B[i],i);
	    }
	    for(int i=0;i<leng;i++){
	        res[i] = map.get(A[i]);
	    }        
	    return res;
	}

}
