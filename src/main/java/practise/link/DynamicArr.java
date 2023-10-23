package practise.link;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/11/18
 **/
public interface DynamicArr<E> {
    /**
     * 元素个数
     *
     * @return
     */
    int size();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    void add(E element);

    /**
     * 返回index定位置对应元素
     *
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 在指定index位置插入E元素
     *
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 往index位置添加元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index位置元素
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看index位置元素
     *
     * @param element
     * @return1
     */
    int indexOf(E element);

    /**
     * 清除所有元素
     */
    void clear();
}
