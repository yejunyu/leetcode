package practise.link;

import java.util.*;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/11/15
 **/
public class A {

    static class User {
        int id;
        String name;
        int pid;
        List<User> children;

        public User(int id, String name, int pid) {
            this.id = id;
            this.name = name;
            this.pid = pid;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", pid=" + pid +
                    ", children=" + children +
                    '}';
        }
    }

    /**
     * [
     * {"id": 1, "name": "部门1", "pid": 0},
     * {"id": 2, "name": "部门2", "pid": 1},
     * {"id": 3, "name": "部门3", "pid": 1},
     * {"id": 4, "name": "部门4", "pid": 3},
     * {"id": 5, "name": "部门5", "pid": 4},
     * {"id": 6, "name": "部门6", "pid": 3}
     * ]
     */

    public static List<User> tree(List<User> parents) {
        List<User> newArr = new ArrayList<>();
        Map<Integer, User> map = new HashMap<>();
        parents.forEach(item -> {
            item.children = new ArrayList<>();
            Integer key = item.id;
            map.put(key, item);
        });
        System.out.println(map);
        parents.forEach(item->{
            User p = map.get(item.pid);
            if (p!=null){
                p.children.add(item);
            }else {
                newArr.add(item);
            }
        });
        return newArr;
    }


    public static void main(String[] args) {
        User user1 = new User(1, "部门1", 0);
        User user2 = new User(2, "部门2", 1);
        User user3 = new User(3, "部门3", 1);
        User user4 = new User(4, "部门4", 3);
        User user5 = new User(5, "部门5", 4);
        User user6 = new User(6, "部门6", 5);
        List<User> parents = Arrays.asList(user1, user2, user3, user4, user5, user6);
        List<User> tree = tree(parents);
        System.out.println(tree);
    }
}
