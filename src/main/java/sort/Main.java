package sort;

import sort.bubble.BubbleSort;
import sort.quick.QuickSort;
import sort.select.InsertSort;
import sort.select.SelectSort;

import java.util.Arrays;


/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/6/6
 */
public class Main {

    public static void main(String[] args) {
        int size = 50000;
        Integer[] arr = RandomNumber.createSortNumber(size, 10, 20000);
        Integer[] arr1 = Helper.copyArr(arr);
        Integer[] arr2 = Helper.copyArr(arr);
        Integer[] arr3 = Helper.copyArr(arr);
//        System.out.println("排序前: " + Arrays.toString(arr));
        Helper.getTime(new SelectSort(), arr);
        Helper.getTime(new BubbleSort(), arr1);
        Helper.getTime(new QuickSort(), arr2);
        Helper.getTime(new InsertSort(), arr3);
//        Helper.getTime(new MergeSort(), arr3);
    }
}
