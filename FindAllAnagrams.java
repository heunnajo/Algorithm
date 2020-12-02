package java_basic;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

	public static void main(String[] args) {
		FindAllAnagrams a = new FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(a.findAnagrams(txt, pat));
	}
	public List<Integer> findAnagrams(String s, String p) {
        //1. 담을 그릇 생성
        List<Integer> result = new ArrayList<>();
        //기저사례 제외!
        if(s==null||s.length()==0||p==null||p.length()==0||s.length()<p.length())
		 return result;
        //2.String s와 pattern에 해당하는 알파벳 배열을 생성하여 
        int[] pAlpha = new int[256];
        int[] sAlpha = new int[256];
        
        //2의 frequency를 기록한다.
        for(int i=0; i < p.length();i++) {
            pAlpha[p.charAt(i)]++;
        }
        //3.String s에 patttern의 크기만큼, 1씩 이동한다. i는 시작점,j는 끝점
        for(int i=0; i< s.length()-p.length()+1;i++) {//starting point만 기록할 것이기 때문에 s-p사이즈만큼
            for(int j=0; j<p.length();j++) {//window 크기!
                sAlpha[s.charAt(i+j)]++;
            }
            if(check(pAlpha,sAlpha)){
                result.add(i);
            }
        }
        return result;
    }
	private boolean check(int[] pAlpha, int[] sAlpha) {
        for(int i=0;i<pAlpha.length;i++) {
            if(pAlpha[i] != sAlpha[i])
                return false;
        }
        return true;
    }

}
