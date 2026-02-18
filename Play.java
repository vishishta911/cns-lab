import java.util.*;

class Play {
    static char[][] m = new char[5][5];

    static void keyMatrix(String key) {
        key = key.replace("j", "i");
        String s = "";

        for (char c : key.toCharArray())
            if (s.indexOf(c) == -1) s += c;

        for (char c = 'a'; c <= 'z'; c++)
            if (c != 'j' && s.indexOf(c) == -1) s += c;

        int k = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                m[i][j] = s.charAt(k++);
    }

    static int[] find(char c) {
        if (c == 'j') c = 'i';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (m[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    static String encrypt(String pt) {
        pt = pt.replace("j", "i");
        String s = "";

        for (int i = 0; i < pt.length(); i++) {
            s += pt.charAt(i);
            if (i < pt.length() - 1 && pt.charAt(i) == pt.charAt(i + 1))
                s += "x";
        }
        if (s.length() % 2 != 0) s += "x";

        System.out.println(s);

        String ct = "";
        for (int i = 0; i < s.length(); i += 2) {
            int[] a = find(s.charAt(i));
            int[] b = find(s.charAt(i + 1));

            if (a[0] == b[0])
                ct += "" + m[a[0]][(a[1] + 1) % 5] + m[b[0]][(b[1] + 1) % 5];
            else if (a[1] == b[1])
                ct += "" + m[(a[0] + 1) % 5][a[1]] + m[(b[0] + 1) % 5][b[1]];
            else
                ct += "" + m[a[0]][b[1]] + m[b[0]][a[1]];
        }
        return ct;
    }

    public static void main(String[] args) {
        String key = "monarchy";
        String pt = "instruments";

        keyMatrix(key);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }

        System.out.println();
        System.out.println(encrypt(pt));
        
    }
}
