package datastructure.sort;

import java.util.Arrays;

public class QuickSortEx {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 8, 2, 1, 4, 6, 1, 9, 6, 9, 5};

        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int partition(int arr[], int low, int high) {
        int pivotIndex = (low + high) / 2; // 피벗의 위치(index)를 중간으로 선택한다.
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, high); // 피벗을 가장 오른쪽에 있는 값과 교환 합니다.

        int storeIndex = low;

        for(int i = low; i < high; i++){
            if(arr[i] < pivotValue){
                swap(arr, i, storeIndex);
                storeIndex += 1;
            }
        }

        // 위에 있는 for문으로 인해 storeIndex 이전까지는 피벗 값 보다 작은 수가 있도록 이동 하였기 때문에

        swap(arr, storeIndex, high); // 가장 오른쪽으로 이동 시켰던 값과 옮겨진 피벗 위치(storeIndex)에 있는 값을 교환 합니다.
        return storeIndex; // 옮겨진 피벗의 위치 정보를 반환
    }

    static void quickSort(int[] arr, int low, int high) { // arr: 정렬 대상이 담긴 배열의 주소, low : 시작 인덱스, high : 종료 인덱스
        // 피벗 값을 가장 오른쪽(high)으로 옮긴 다음, 피벗 값을 제외한 나머지를 영역을 나누어 정렬하기 때문에 low<high 일 것 같음...
        if (low < high) {
            int pivot = partition(arr, low, high);  // 피벗을 구한 다음, 두개의 영역으로 나눠서

            // 피벗의 인덱스 값(pivot)을 기준으로 두 개의 영역으로 나눈다.
            quickSort(arr, low, pivot - 1); // 왼쪽 영역을 정렬
            quickSort(arr,pivot + 1, high); // 오른쪽 영역을 정렬
        }
    }

    static void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}