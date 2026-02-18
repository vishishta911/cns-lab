import java.util.*;
class Substi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "qwertyuioplkjhgfdsazxcvbnm";

        System.out.print("Enter text: ");
        String s = sc.nextLine();

        System.out.print("Cipher text: ");
        for (char c : s.toCharArray())
            System.out.print(b.charAt(a.indexOf(c)));

        sc.close();
    }
}
