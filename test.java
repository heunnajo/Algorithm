import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end;
    Interval(){}
    Interval(int s, int e) {this.start = s; this.end = e;}
}
public class test {
    public static void main(String[] args) {
        //new와 생성자로 객체 생성하는 것 잊지 말기!!!
        //객체를 생성하고, 값을 넣는다!!
        // Interval in2 = new Interval(1,3);
        // Interval in1 = new Interval(2,6);
        // Interval in4 = new Interval(8,10);
        // Interval in3 = new Interval(15,18);

        Interval in2 = new Interval(1,4);
        Interval in1 = new Interval(4,5);
        //Interval in4 = new Interval(8,10);
        //Interval in3 = new Interval(15,18);

        //Interval[] intervals = {in1,in2,in3,in4};
        Interval[] intervals = {in1,in2};
        test a = new test();
        Interval[] result = a.solve(intervals);
        a.print(intervals);
    }

    public static void print(Interval[] intervals) {
        for(Interval i : intervals) {
            System.out.println(i.start + "," + i.end);
        }
    }

    public static Interval[] solve(Interval[] intervals) {
        //기저 사례
        if(intervals.length == 0 || intervals == null)
            return intervals;
        //0.그릇
        int leng = intervals.length;
        Interval[] result = new Interval[leng];
        //1. 시작 시간 기준으로 오름차순 정렬.
        Arrays.sort(intervals, Comp);

        // 2.앞 끝시간과 뒤 시작시간 비교해서 합치기!
        for (int i = 0; i < leng-1; i++) {
            if (intervals[i].end >= intervals[i + 1].start) {
                intervals[i].end = Math.max(intervals[i].end, intervals[i + 1].end);
            } else {
                result[i] = intervals[i];
            }

        }
        if(result.contains(intervals[leng-1])) {
            result[leng-1] = intervals[leng-1];
        }
        
        return result;
    }

    static Comparator<Interval> Comp = new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;//ascending order
        }
    };
}
