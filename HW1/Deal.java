import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Deal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[SUITS.length * RANKS.length];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[i * SUITS.length + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < n * 5) {
            int random = (int) (Math.random() * (SUITS.length * RANKS.length));
            if (numbers.contains(random)==false) {
                numbers.add(random);
                System.out.println(deck[random]);
            }
            if (numbers.isEmpty()==false && numbers.size() % 5==0) {
                System.out.println("");
            }
        }
    }
}
