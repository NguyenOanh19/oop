public class SumOfTwoDice {
    public static void main(String[] args) {
        int min = 1, max = 6;
        int a = (int) (Math.random() * (max - min + 1)) + min;
        int b = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println(a + b);
    }
}
