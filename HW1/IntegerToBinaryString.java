import java.util.Scanner;

public class IntegerToBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0) {
            System.out.println("0");
            return;
        }
        String binaryString = "";
        while (n!=0) {
            int reminder = n % 2;
            binaryString += Integer.toString(reminder);
            n /= 2;
        }
        String res = "";
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            res += binaryString.charAt(i);
        }
        System.out.println(res);
    }
}
