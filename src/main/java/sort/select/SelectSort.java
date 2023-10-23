package sort.select;

import sort.CallBack;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/14
 */
public class SelectSort implements CallBack {
    public SelectSort() {
        System.out.println("选择排序");
    }

    // 10000个数据235ms
    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        for (int i = 0; i < ts.length - 1; i++) {
            int minPos = i;
            int maxPos = ts.length-1-i;
            for (int j = i + 1; j < ts.length - i - 1; j++) {
                minPos = ts[j].compareTo(ts[minPos]) < 0 ? j : minPos;
                maxPos = ts[j].compareTo(ts[maxPos]) > 0 ? j : maxPos;
            }
            swap(ts, i, minPos);
            swap(ts, ts.length - 1 - i, maxPos);
        }
        return ts;
    }

    private <T extends Comparable<T>> void swap(T[] ts, int i, int j) {
        T temp = ts[i];
        ts[i] = ts[j];
        ts[j] = temp;
    }
}
