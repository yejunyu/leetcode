package practise.lesson1dot2;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/11
 */
public class Point2D {

    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(Point2D p2) {
        return Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2));
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D(1,0);
        Point2D p2 = new Point2D(4,4);
        double distance = p1.getDistance(p2);
        System.out.println(distance);
    }
}
