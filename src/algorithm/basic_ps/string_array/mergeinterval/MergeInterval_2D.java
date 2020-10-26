package algorithm.basic_ps.string_array.mergeinterval;

import java.util.*;

public class MergeInterval_2D {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                {2, 6},
                {1, 3},
                {15, 18},
                {8, 10}
        };

        int[][] output = merge(intervals);

        System.out.println(Arrays.deepToString(output));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        ArrayList<Interval> intervalList = new ArrayList<>();

        for(int[] temp : intervals){
            intervalList.add(new Interval(temp[0], temp[1]));
        }
        
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        //**

        List<Interval> result = new ArrayList<>();

        Interval before = intervalList.get(0);

        for(int i=1; i<intervalList.size(); i++){
            Interval current = intervalList.get(i);

            if(before.end >= current.start){
                before.end = Math.max(before.end, current.end);
            }else{
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)){
            result.add(before);
        }
        //**

        int[][] res = new int[result.size()][2];
        int count = 0;

        for(Interval temp : result){
            res[count][0] = temp.start;
            res[count][1] = temp.end;
            count++;
        }

        return res;
    }

}

class Interval{
    int start;
    int end;

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }

}