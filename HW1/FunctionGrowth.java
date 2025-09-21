import java.util.Scanner;

public class FunctionGrowth {
    public static void main(String[] args) {
        System.out.println("ln(n)\tn\tnln(n)\tn^2\tn^3\t2^n");
        for(int i=32;i<=2048;i*=2){
            System.out.print((int)Math.log(i));
            System.out.print("\t");
            System.out.print(i);
            System.out.print("\t");
            System.out.print(i*(int)Math.log(i));
            System.out.print("\t");
            System.out.print(i*i);
            System.out.print("\t");
            System.out.print(i*i*i);
            System.out.print("\t");
            System.out.println((int)Math.pow(2,i));
        }
    }
}
