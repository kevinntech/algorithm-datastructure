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

		/*	(1) nums 배열을 for 문으로 반복 하면서

			(2) 만들어야 되는 숫자(target)와 nums 배열 요소의 차이를 구한 다음, 그 값을 Map에 저장한다.

     			저장 할 때는 key : 차이 값 , value : nums 배열 요소의 인덱스를 저장한다.

			(3) Map에서 앞서 구한 "차이 값"과 일치하는 것이 있다면 그 값은 내가 만들어야 되는 숫자가

    			될 수 있는 값이므로 인덱스를 반환한다.	*/

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                int mapValue = map.get(nums[i]);
                result[0] = mapValue;
                result[1] = i;
            }else {
                map.put(target-nums[i], i);
            }
        }

        return result;

    }
}
