import java.util.*;
class Ceas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        System.out.print("Encrypted text: ");
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                c = (char) ((c - 'a' + 3) % 26 + 'a');
            System.out.print(c);
        }
        sc.close();
    }
}
