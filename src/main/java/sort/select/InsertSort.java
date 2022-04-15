package sort.select;

import sort.CallBack;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/14
 */
public class InsertSort implements CallBack {
    public InsertSort() {
        System.out.println("插入排序");
    }

    public <T> void exchange(T a, T b) {
        T t = a;
        a = b;
        b = t;
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        for (int i = 1; i < ts.length; i++) {
            T t;
            int min = i;
            for (int j = i; j > 0 && ts[j].compareTo(ts[j - 1]) < 0; j--) {
                if (ts[j].compareTo(ts[min])>0){
                    t = ts[j];
                    ts[j] = ts[min];
                    ts[min] = t;
                }else {

                }
            }
        }
        return ts;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 2, 1, 4, 7, 6};
        InsertSort insertSort = new InsertSort();
        Integer[] sort = insertSort.sort(a);
        System.out.println(sort);
    }
}
