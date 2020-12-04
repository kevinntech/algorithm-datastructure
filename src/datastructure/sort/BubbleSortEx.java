package datastructure.sort;

import java.util.Arrays;

public class BubbleSortEx {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 4, 9, 7};
        BubbleSortEx ex = new BubbleSortEx();
        ex.bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    * 버블 정렬에서 i는 반복 횟수를 의미하고 j는 비교 대상을 의미한다.
    * */
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < (n-i)-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
