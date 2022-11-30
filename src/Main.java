// def bose_nelson(data):
//     m = 1
//     while m < len(data):
//         j = 0
//         while j + m < len(data):
//             bose_nelson_merge(j, m, m)
//             j = j + m + m
//         m = m + m
//     return data
//
// def bose_nelson_merge(j, r, m):
//     if j + r < len(data):
//         if m == 1:
//             if data[j] > data[j + r]:
//                 data[j], data[j + r] = data[j + r], data[j]
//         else:
//             m = m // 2
//             bose_nelson_merge(j, r, m)
//             if j + r + m < len(data):
//                 bose_nelson_merge(j + m, r, m)
//             bose_nelson_merge(j + m, r - m, m)
//     return data

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] fill_arr(int length, int min, int max){
        Random random = new Random();
        int[] arr = new int[length];
        int diff = Math.abs(max - min);
        if (min > max){
            min = max;
        }
        for (int i = 0; i < arr.length; i++){
            arr[i] = min + random.nextInt(diff + 1);
        }
        return arr;
    }

    public static void mergeSort(int[] src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }
    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]){
                src[k++] = left[i++];
            } else {
                src[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }


    public static void main(String[] args) {
        int[] arr = fill_arr(10, 0, 100);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
