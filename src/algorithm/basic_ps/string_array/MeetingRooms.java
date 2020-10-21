package algorithm.basic_ps.string_array;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end =0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms a = new MeetingRooms();

/*
        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1, in2, in3};
 */
        Interval in1 = new Interval(7,10);
        Interval in2 = new Interval(2,4);

        Interval[] intervals = {in1, in2};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals) {
        // 일단, 시작 시간을 기준으로 정렬한다.
        /* 불가능한 경우
            0 ------------------------------ 30
                   5-----10
                            15----------20

            beforeEndTime > afterStartTime
        */

        /* 가능한 경우
                       7---10
               2----4

            beforeEndTime < afterStartTime
        */
        Arrays.sort(intervals, new Ascending());

        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].end > intervals[i].start)
                return false;
        }

        return true;
    }

    public void print(Interval[] intervals) {
        for(int i=0; i<intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start+" "+in.end);
        }
    }

}

class Ascending implements Comparator<Interval>{

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o1.end;
    }
}

