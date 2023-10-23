package sort.bubble;

import sort.RandomNumber;

import java.util.Arrays;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/11/23
 **/
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] nums = RandomNumber.createSortNumber(1000);
        sort(nums);
        print(nums);
    }

    static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }


    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
