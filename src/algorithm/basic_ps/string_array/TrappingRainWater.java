package algorithm.basic_ps.string_array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
    public static int trap(int[] height) {
        int result =0;
        if(height == null || height.length <= 2) // height 배열의 길이가 2 보다 작다면 붙어 있다는 것이므로 문제를 풀 수 없음
            return result;

        int[] left = new int[height.length];  // 왼쪽에서 부터 최대 벽 높이 배열
        int[] right = new int[height.length]; // 오른쪽에서 부터 최대 벽 높이 배열

        // 왼쪽에서 부터 최대 벽 높이 구하기
        int max = height[0];
        left[0] = max;
        for(int i = 1; i < height.length; i++) {
            if(max < height[i]) { // Max 값 갱신
                max = height[i];
            }

            left[i] = max;
        }

        // 오른쪽에서 부터 최대 벽 높이
        // 배열의 오른쪽에서 부터 구한다.
        max = height[height.length-1];
        right[height.length-1] = max;
        for(int i = height.length - 2; i >= 0; i--) {
            if(max < height[i]) { // Max 값 갱신
                max = height[i];
            }

            right[i] = max;
        }

        for(int i = 0; i < height.length; i++) {
            result += Math.min(left[i],right[i]) - height[i];
        }

        return result;
    }
}