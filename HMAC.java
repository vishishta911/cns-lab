import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
import java.util.Base64;

class HMAC {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String msg = sc.nextLine();

        System.out.print("Enter the secret key: ");
        String key = sc.nextLine();

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec sk = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(sk);

        String res = Base64.getEncoder()
                .encodeToString(mac.doFinal(msg.getBytes()));

        System.out.println("Message: " + msg);
        System.out.println("MAC (HMAC-SHA256): " + res);

        sc.close();
    }
}
