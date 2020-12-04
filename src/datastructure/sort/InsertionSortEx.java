package datastructure.sort;

import java.util.Arrays;

public class InsertionSortEx {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 4, 9, 7};
        InsertionSortEx ex = new InsertionSortEx();
        ex.insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void insertionSort(int[] arr) {
        int i, j;
        int n = arr.length;

        for(i = 1; i < n; i++) {

            int temp = arr[i]; // 정렬 대상을 temp에 저장

            for(j = i-1; j >= 0; j--) {
                if(arr[j] > temp)       // 비교 대상(arr[j])이 정렬 대상(temp) 보다 크다면
                    arr[j+1] = arr[j];  // 비교 대상을 한 칸 뒤로 밀기
                else        // 그렇지 않으면 삽입 위치를 찾았으니 반복문을 종료한다.
                    break;
            }

            arr[j+1] = temp; // 찾은 위치에 정렬 대상을 삽입한다.
        }
    }

}
