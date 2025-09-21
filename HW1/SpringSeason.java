import java.util.Scanner;

public class SpringSeason {
    public boolean check(int m, int d){
        if(m < 3 || m > 6)
            return false;
        switch (m){
            case 3:
                if(d < 20 || d > 31)
                    return false;
                break;
            case 4:
                if(d < 0 || d > 30)
                    return false;
                break;
            case 5:
                if(d < 0 || d > 31)
                    return false;
            case 6:
                if(d < 0 || d > 20)
                    return false;
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextByte(), d = sc.nextByte();
        SpringSeason ss = new SpringSeason();
        System.out.println(ss.check(m,d));
    }
}
