class JewelStones {
    public static void main(String[] args) {
        String J = "a,A", S = "a,A,A,b,b,b,b";
        System.out.println("The number of jewels : " + solve(J,S));
        //int result = solve(s1,s2);굳이 변수 안만들어도 될 정도로 간단.
    }
    public static int solve(String jew, String stone) {
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        
        //1.HashSet에 jewel 문자열을 담는다.
        for(char jewelChar : jew.toCharArray()) {
            set.add(jewelChar);//a,A가 HashSet에 담긴다.
            System.out.println("char in HashSet :"+jewelChar);
        }
        //2. stone에 jewel이 얼마나 들어있는지 체크한다!
        for(char stoneChar : stone.toCharArray()) {
            System.out.println("stoneChar :"+stoneChar);
            if(set.contains(stoneChar) {
                cnt++;
            }
        }
        return cnt;
    }
}