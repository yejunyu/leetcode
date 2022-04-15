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

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        for (int i = 0; i < ts.length; i++) {
            T min = ts[i];
            for (int j = i + 1; j < ts.length; j++) {
                if (ts[j].compareTo(min) < 0) {
                    min = ts[j];
                    T temp = ts[i];
                    ts[i] = ts[j];
                    ts[j] = temp;
                }
            }
        }
        return ts;
    }
}
