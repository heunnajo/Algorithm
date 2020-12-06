package java_basic;
import java.util.*;
public class UniqueEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = {"test.email+alex@leetcode.com",
		           "test.e.mail+bob.cathy@leetcode.com",
		           "testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}
	public static int numUniqueEmails(String[] emails) {
        //0. 그릇 생성
        Set<String> uniqueEmails = new HashSet<String>();
        //1. String 배열(emails) 안의 각각의 String(각각의 이메일) 로컬네임과 도메인 네임을 나눠서 구한다.
      //2. 1을 합쳐서 Set에 넣는다.
        for(String email : emails) {
            String localName = getLocalname(email);//1
            String domainName = getDomainname(email);//1
            uniqueEmails.add(localName + '@' + domainName);//2
        }
        //3. Set의 크기를 리턴(이메일 주소는 중복X,순서상관X)
        return uniqueEmails.size();
    }
    
    private static String getLocalname (String email) {
        //1. 새로운 String 생성(StringBuilder)
        StringBuilder sb = new StringBuilder();
        //2. emails의 철자하나하나를 다 뽑아내서 새로운 String에 저장한다.
        //String은 char로 이루어져있기에, charAt(i) 데이터는 char이다!
        //char->String->StringBuilder에 저장! 
        for(int i = 0; i<email.length();i++) {
            //규칙들과 @ 만났을 때 먼저 필터링한 다음에 String 저장 처리!
            if (email.charAt(i) == '.') {
				continue;
			}
			if (email.charAt(i) == '+') {
				break;
			}
			if (email.charAt(i) == '@') {
				break;
			}
            //String 인풋 철자 하나하나 = char이다! 그러므로
            //(핵심0char->String->StringBuilder 에 저장!
            String str = String.valueOf(email.charAt(i));//char를 String으로 형변환!
            sb.append(str);
        }
        return sb.toString();//StringBuilder를 String으로 리턴!
    }
    private static String getDomainname (String email) {
        return email.substring(email.indexOf('@')+1);
    }

}
