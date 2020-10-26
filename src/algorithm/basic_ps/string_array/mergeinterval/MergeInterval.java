package algorithm.basic_ps.string_array.mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {

        Interval interval2 = new Interval(2, 6);
        Interval interval1 = new Interval(1, 3);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        List<Interval> list = merge(intervals);
        print(list);

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) // 예외 처리
            return intervals;

        List<Interval> result = new ArrayList<>();

        // List를 start 값을 기준으로 정렬한다.
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // 첫 번째 간격(Interval)을 꺼낸다.
        Interval before = intervals.get(0); // [1, 3]

        for(int i=1; i<intervals.size(); i++){
            Interval current = intervals.get(i); // 현재 간격을 꺼낸다.

            // 이전 간격의 end 값(3)이 현재 간격의 start 값(2) 보다 크거나 같다면
            if(before.end >= current.start){
                before.end = Math.max(before.end, current.end); // 하나로 합친다.
            }else{
                result.add(before); // 하나로 합쳤다면 result에 넣는다.
                before = current; // [8, 10]이 before가 된다.
            }
        }

        if(!result.contains(before)){ // 마지막에 남은 before를 결과(result)에 넣어준다.
            result.add(before);
        }

        return result;
    }

    public static void print(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }
}
