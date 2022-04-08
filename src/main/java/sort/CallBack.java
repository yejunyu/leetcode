package sort;

/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/6/6
 */
public interface CallBack {
    /**
     * 排序
     * @param ts 原始数组
     * @param <T> 数据类型
     * @return 排序后的数组
     */
    <T extends Comparable<T>> T[] sort(T[] ts);
}
