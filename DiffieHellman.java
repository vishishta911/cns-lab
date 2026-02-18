import java.math.BigInteger;
import java.util.Scanner;

class DiffieHellman {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a prime number (p): ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter a primitive root modulo p (g): ");
        BigInteger g = sc.nextBigInteger();

        BigInteger a = new BigInteger("6");    // Alice private key
        BigInteger b = new BigInteger("15");   // Bob private key

        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        System.out.println("Alice's Public Key (A): " + A);
        System.out.println("Bob's Public Key (B): " + B);

        BigInteger k1 = B.modPow(a, p);
        BigInteger k2 = A.modPow(b, p);

        System.out.println("Alice's Secret Key: " + k1);
        System.out.println("Bob's Secret Key: " + k2);

        System.out.println("Key exchange successful. Shared secret key is established.");

        sc.close();
    }
}
