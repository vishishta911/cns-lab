import java.util.*;
class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine();
        int n = s.length();

        int[] p = new int[n], c = new int[n];
        int[][] k = new int[n][n];

        for (int i = 0; i < n; i++)
            p[i] = s.charAt(i) - 'A';

        System.out.println("Enter key matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                k[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i] += k[i][j] * p[j];

        System.out.print("Cipher text: ");
        for (int i = 0; i < n; i++)
            System.out.print((char) ('A' + c[i] % 26));

        sc.close();
    }
}
