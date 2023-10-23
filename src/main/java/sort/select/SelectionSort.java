package sort.select;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/11/22
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 5, 4, 1, 2, 3, 7};
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            int maxPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minPos] > nums[j]) {
                    minPos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
