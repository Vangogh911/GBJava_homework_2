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

public class Main {

    public static int[] bose_nelson(int[] data) {
        int m = 1;
        int j;
        while (m < data.length) {
            j = 0;
            while (j + m < data.length) {
                data = bose_nelson_merge(j, m, m, data);
                j = j + m + m;
                m = m + m;
            }
        }
        return data;
    }

    public static int[] bose_nelson_merge(int j, int r, int m, int[] data) {
        int buf;
        if (j + r < data.length) {
            if (m == 1) {
                if (data[j] > data[j + r]) {
                    buf = data[j];
                    data[j] = data[j + r];
                    data[j + r] = buf;
                } else {
                    m /= 2;
                    bose_nelson_merge(j, r, m, data);
                    if (j + r + m < data.length) {
                        bose_nelson_merge(j + m, r, m, data);
                        bose_nelson_merge(j + m, r - m, m, data);
                    }
                }
            }
        }
        return data;
    }


    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 0, 8, 6, 3, 1, 4};
        int[] sorted_arr = bose_nelson(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }
}