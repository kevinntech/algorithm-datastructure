package algorithm.basic_ps.string_array;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,8,11,21};
        int target = 10;

        /*  int[] nums = {-1, -2, -3, -4, -5};
            int target = -8;    */

        int[] result = solve(nums, target);

        for(int i : result)
            System.out.println(i);
    }

    public static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

		/*
		    요약 하자면, 반복문을 돌면서 이미 봤던 값은 Map에 저장하고 target과 현재 요소의 차이가
		    이미 봤던 값과 같다면 그것은 정답이다.

			(1) nums 배열을 for 문으로 반복 하면서

			(2) 만들어야 되는 숫자(target)와 nums 배열 요소의 차이를 구한 다음, 그 값이 Map에 있는지 확인한다.

                없다면 Map에 key : nums 배열 요소의 값 , value : nums 배열 요소의 인덱스를 저장한다.

			(3) Map에서 "만들어야 되는 숫자(target), nums 배열 요소의 차이"와 일치하는 것이 있다면

			    그 값은 내가 만들어야 되는 숫자가 될 수 있는 값이므로 인덱스를 반환한다.	*/

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                int value = map.get(target - nums[i]);
                result[0] = value;
                result[1] = i;
            }else {
                map.put(nums[i], i);
            }
        }

        return result;

    }
}
