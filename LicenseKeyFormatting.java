class LicenseKeyFormatting {
    public static void main(String[] args) {
        String S = "5F3z-2e-9-w";
        int K = 4;
        
        System.out.println(solve(S,K));
    }
    public static String solve(String s, int K) {
        //1.새로운 String 객체를 생성하여 input String에서 대쉬 제거, 대문자 변환한다.
        String S2 = s.replace("-","");//String은 character로 이루어져있기 때문에 각각의 char는 ' '라 생각햇지만 오답. 그래서 ""
        S2 = S2.toUpperCase();
        //2.StringBuilder 생성하여 1에서 생성한 String 데이터 추가한다.
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S2.length();i++) {
            sb.append(S2.charAt(i));
        }
        //3.StringBuilder의 뒤에서부터 K만큼 끊어 대쉬 추가한다. insert(int,'-');
        int leng = sb.toString().length();
        for(int i=k; i<leng;i=i+k) {
            sb.insert(leng-i,'-');
        }
        //4.StringBuilder를 String으로 변환하여 리턴한다.
        return sb.toString();
    }
}