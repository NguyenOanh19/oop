import java.util.Scanner;

public class SumOfSines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double degrees = sc.nextDouble();
        double radians = Math.toRadians(degrees);
        double res = Math.sin(2 * radians) + Math.sin(3 * radians);
        System.out.println(res);
    }
}
