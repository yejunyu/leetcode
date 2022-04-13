package sort.quick;

import sort.CallBack;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/8
 */
public class QuickSort implements CallBack {

    <T extends Comparable<T>> void quickSort(T[] ts, int l, int r) {
        // i,j两个指针, t 用来左右交换, temp 用来存基准数
        int i, j;
        T t, temp;
        if (l > r) {
            return;
        }
        temp = ts[l];
        i = l;
        j = r;
        while (i < j) {
            while (ts[j].compareTo(temp) >= 0 && i < j) {
                j--;
            }
            while (ts[i].compareTo(temp) <= 0 && i < j) {
                i++;
            }
            if (i < j) {
                t = ts[i];
                ts[i] = ts[j];
                ts[j] = t;
            }
        }
        ts[l] = ts[i];
        ts[i] = temp;
        quickSort(ts, l, i - 1);
        quickSort(ts, i + 1, r);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        quickSort(ts, 0, ts.length-1);
        return ts;
    }
}
