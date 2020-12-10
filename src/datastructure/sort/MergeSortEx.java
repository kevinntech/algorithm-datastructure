package datastructure.sort;

import java.util.Arrays;

public class MergeSortEx {
    static void mergeTwoArea(int[] a, int start, int end) { // start 번째 부터 end 번째까지 배열을 합치는 함수

        int mid = (start + end) / 2;
        int i = start;    // 왼쪽 영역의 시작 지점
        int j = mid+1; // 오른쪽 영역의 시작 지점
        int k = 0;       // 임시 배열 b의 인덱스 (임시 배열 명을 temp라고 변경 하는 것도 괜찮을 듯...)
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) { // i는 mid까지 반복하며 j는 end까지 반복한다.
            if (a[i] <= a[j]) {
                temp[k++] = a[i++]; // i번째의 수가 j번째의 수보다 작으면 임시 배열 b에 i번째 수를 넣어준다.
            } else {
                temp[k++] = a[j++]; // 그게 아니면 j번째 수가 더 작으므로 임시 배열 b에 j번째 수를 넣어준다.
            }
        }

        /*  두 영역 중 남아 있는 수가 있다면 왼쪽 영역 또는 오른쪽 영역의 남아있는 수를
            임시 배열로 이동  (아래 두 개의 while문 중 하나만 실행 됨) */
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }

//        System.out.println("=====================================");
//        System.out.println("[start : " + start + ", end : " + end + "]" + ", 임시 배열 길이 : "  + b.length);
//        System.out.println("=====================================");

        for (i = start; i <= end; i++) {
            a[i] = temp[i - start]; // 임시 배열의 내용을 원래 배열에 덮어 쓴다.
        }

    }

    static void mergeSort(int[] a, int start, int end) { // start 번째 부터 end 번째까지 정렬 하는 함수
        if (start == end) return;      // start와 end가 같다는 것은 “수의 개수가 1개”라는 것을 의미하며 이는 정렬할 필요가 없다는 것을 의미하기에 함수 종료

        int mid = (start + end) / 2; // 중간 지점을 계산한다.

        // 두 개의 영역으로 나누어 각각을 정렬한다.
        mergeSort(a, start, mid);    // start~mid에 위치한 데이터 정렬 (왼쪽 부분 정렬)
        mergeSort(a, mid + 1, end); // mid+1~end에 위치한 데이터 정렬 (오른쪽 부분 정렬)

        mergeTwoArea(a, start, end); // start부터 end번째 까지 배열을 병합한다.
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 3, 7, 1, 5, 4, 6 };
//        int[] arr = { 5, 1, 4, 2, 8, 2, 1, 4, 6, 1, 9, 6, 9, 5};

        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
