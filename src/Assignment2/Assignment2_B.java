package Assignment2;

import java.util.Scanner;

public class Assignment2_B {

    private static long count;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n, k;
        int[] nums = new int[100001];
        while (in.hasNext()) {
            n = in.nextInt();
            k = in.nextInt();
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            mergeSort(nums, 0, n - 1);
            System.out.println(Math.max((count - k), 0));
            count = 0;
        }
    }

    public static void merge(int[] nums, int start, int end, int middle) {
        int m, n, k;
        m = start;
        n = middle + 1;
        k = 0;
        int[] temp = new int[end - start + 1];
        while (m <= middle && n <= end) {
            if (nums[m] <= nums[n]) {
                temp[k++] = nums[m++];
            }
            else if (nums[m] > nums[n]) {
                temp[k++] = nums[n++];
                count += middle - m + 1;
            }
        }
        while (m <= middle) {
            temp[k++] = nums[m++];
        }
        while (n <= end) {
            temp[k++] = nums[n++];
        }
        for (int l = 0; l < k; l++) {
            nums[start + l] = temp[l];
        }
    }

    public static void mergeSort(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        if (start < end) {
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            merge(nums, start, end, middle);
        }
    }
}


