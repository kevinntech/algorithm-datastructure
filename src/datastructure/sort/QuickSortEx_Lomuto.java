package datastructure.sort;

import java.util.Arrays;

public class QuickSortEx_Lomuto {
    public static void main(String[] args) {
        int[] arr = { 2, 8, 7, 1, 3, 5, 6, 4};
//        int[] arr = { 5, 1, 4, 2, 8, 2, 1, 4, 6, 1, 9, 6, 9, 5};

        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // 맨 오른쪽을 피벗으로 정한다.
        int left = low;

        for(int right = low; right < high; right++){
            if(arr[right] < pivot){     // 오른쪽(right) 값이 피벗 보다 작다면
                swap(arr, left, right); // 서로 스왑을 한다.
                left += 1;              // 스왑 이후에는 왼쪽(left) 포인터가 함께 이동한다.
            }
        }

        /*
        * 오른쪽 포인터가 끝에 도달하게 되면 피벗 값(4)을 기준으로 작은 값은 왼쪽에
        * 큰 값은 오른쪽에 분할되어 있고 피벗이 그 중앙으로 이동하게 된다.
        * */
        swap(arr, left, high); // 그리고 왼쪽 포인터의 위치로 피벗 아이템이 이동한다.
        return left; // 옮겨진 피벗의 위치 정보를 반환한다.
    }

    static void quickSort(int[] arr, int low, int high) { // arr: 정렬 대상이 담긴 배열의 주소, low : 시작 인덱스, high : 종료 인덱스
        // 서로 위치가 역전될 때까지는 계속 재귀로 반복하면서 정렬을 진행한다.
        if (low < high) {
            int pivot = partition(arr, low, high);  // 파티션을 나누고 새로운 피벗 값을 얻는다.

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