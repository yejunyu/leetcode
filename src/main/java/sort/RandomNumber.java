package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class RandomNumber {

    public static Integer[] createSortNumber(int size, int minNum, int maxNum) {
        Integer[] numArr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            // +1 代表左闭右闭区间
            numArr[i] = minNum + random.nextInt(maxNum - minNum + 1);
        }
        return numArr;
    }

    public static int[] createSortNumber(int size) {
        Integer[] sortNumber = createSortNumber(size, 1, 10000);
        return Arrays.stream(sortNumber).mapToInt(i -> i.intValue()).toArray();
    }
}
