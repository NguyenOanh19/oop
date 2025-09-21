import java.util.Scanner;

public class UseThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] name = new String[3];
        for(int i=0;i<3;i++){
            name[i] = sc.next();
        }
        System.out.println("Hi, " + name[2] + ", " + name[1] + ", and " + name[0] + '.');
    }
}
