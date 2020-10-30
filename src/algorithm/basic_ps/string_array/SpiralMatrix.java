package algorithm.basic_ps.string_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {  { 1, 2, 3 },
//                            { 4, 5, 6 },
//                            { 7, 8, 9 } };

        int[][] matrix = {  { 1,2,3,4 },
                            { 5,6,7,8 },
                            { 9,10,11,12 } };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return nums;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while(nums.size() < size){

            // 오른쪽 방향으로 이동 (left -> right)
            for(int i = left; i <= right && nums.size() < size; i++){
                nums.add(matrix[top][i]);
            }
            top++;

            // 아래쪽 방향으로 이동 (top -> bottom)
            for(int i = top; i <= bottom && nums.size() < size; i++){
                nums.add(matrix[i][right]);
            }
            right--;

            // 왼쪽 방향으로 이동 (right -> left)
            for(int i = right; i >= left && nums.size() < size; i--){
                nums.add(matrix[bottom][i]);
            }
            bottom--;

            // 위쪽 방향으로 이동 (bottom -> top)
            for(int i = bottom; i >= top && nums.size() < size; i--){
                nums.add(matrix[i][left]);
            }
            left++;

        }

        return nums;

    }
}