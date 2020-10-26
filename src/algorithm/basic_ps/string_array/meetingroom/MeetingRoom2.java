package algorithm.basic_ps.string_array.meetingroom;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();

        Interval in1 = new Interval(5,10);
        Interval in2 = new Interval(15,20);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1,in2,in3};
        System.out.println(a.solve(intervals));
    }

    // 시간을 합쳐서 Heap에 저장
    public int solve(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) // 에러 처리
            return 0;

        // 회의 시작 시간을 기준으로 배열을 정렬한다.
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        // 회의 종료 시간을 기준으로 최소 힙을 구성한다.
        Queue<Interval> queue = new PriorityQueue<Interval>(
                (a, b) -> (a.end - b.end));

        // 우선 순위 큐에 첫 번째 회의 시간을 저장한다. [0, 30]
        queue.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++) {

            // 우선 순위 큐는 이전 회의 중에서 회의 종료 시간이 제일 작은 것 부터 꺼내서 보여 주기만 한다. (큐에서 삭제 X)
            Interval before = queue.peek(); // [0, 30] -> [5, 10]

            // 이전 회의 종료 시간이 현재 회의 시작 시간 보다 작거나 같다면 시간을 합친다.
            if(before.end <= intervals[i].start) {
                before.end = intervals[i].end;
            }else {
                queue.offer(intervals[i]); // 시간을 합치는 경우가 아니면 현재 회의 시간을 우선 순위 큐에 넣는다.
            }

        }

        return queue.size();
    }

}


