package data_structures;

import java.util.*;
import java.io.*;

public class ReverseWord {
    static void print(BufferedWriter bw, Stack<Character> s) throws IOException {
        while (!s.isEmpty()) {
            bw.write(s.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean tag = false;
        Stack<Character> s = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                print(bw, s);
                tag = true;
                bw.write(ch);//< 출력
            } else if (ch == '>') {
                tag = false;
                bw.write(ch);//> 출력
            } else if (tag) {
                bw.write(ch);
            } else {//단어뒤집기1과 동일.
                if (ch == ' ') {
                    print(bw, s);
                    bw.write(ch);
                } else {
                    s.push(ch);
                }
            }
        }
        print(bw, s);//혹시 스택에 남아있는 것이 있다면 다 출력.
        bw.write("\n");
        bw.flush();
    }
}

