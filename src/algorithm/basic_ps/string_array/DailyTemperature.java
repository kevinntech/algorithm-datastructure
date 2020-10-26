package algorithm.basic_ps.string_array;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(nums);

        System.out.println(Arrays.toString(res));
    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();         // 스택 생성
        int[] result = new int[T.length];  // 정답을 저장 할 배열

        for(int i=0; i<T.length; i++){
            // 스택에 데이터가 있고 현재 온도(temperatures[i])가 스택에 저장된 이전 온도 보다 더 높으면
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();    // 스택에서 꺼낸 다음
                result[index] = i - index;  // 이전 온도에서 따뜻해질 때 까지 기다려야 하는 날짜를 지정한다. result[0] = 1-0
            }

            stack.push(i); // Stack에는 temperatures 배열의 인덱스를 저장한다.
        }

        return result;
    }
}