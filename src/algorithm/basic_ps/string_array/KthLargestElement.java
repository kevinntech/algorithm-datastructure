package algorithm.basic_ps.string_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest_array(nums, k));
        System.out.println(findKthLargest_pq(nums, k));
    }

    // 첫 번째 방식 (배열 이용)
    public static int findKthLargest_array(int[] nums, int k) {
        int length = nums.length; // 길이 6
        Arrays.sort(nums);

        return nums[length-k];
    }

    // 두 번째 방식 (우선순위 큐 이용)
    public static int findKthLargest_pq(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }

        int index = 1;
        int result = 0;

        while(index <= k){
            result = queue.poll();
            index++;
        }

        return result;
    }
}
