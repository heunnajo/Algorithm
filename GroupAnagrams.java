package java_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] list =  {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(list));
	}
    public static List<List<String>> groupAnagrams(String[] strs) {
        //0.기저사례 제외
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        //1.그릇 생성
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        for(String str : strs) {
            //2-1.String을 char[]로 바꾼다.
            //2-2.Arrays.sort()를 이용하여 2-1을 정렬한다!
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            //3.정렬한 char 배열의 값은 String이 되고, 이것은 map의 key가 된다.
            //3-1. char[]를 다시 String으로 바꾼다.
            //3-2. 3-1을 map의 key로 만든다(저장한다).
            String key = String.valueOf(charArray);
        
            //4.Map(key,value) = Map(String,List<String>)
            if(map.containsKey(key)) {//key값으로 aet가 존재한다면!
                map.get(key).add(str);
            }else {//처음엔 else문 실행!
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
