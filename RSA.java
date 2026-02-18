import java.security.*;
import javax.crypto.Cipher;
import java.util.*;
import java.util.Base64;

class RSA {
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String pt=sc.nextLine();

        KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        KeyPair kp=kpg.generateKeyPair();

        Cipher c=Cipher.getInstance("RSA");

        c.init(Cipher.ENCRYPT_MODE,kp.getPublic());
        String et=Base64.getEncoder()
                .encodeToString(c.doFinal(pt.getBytes()));
        System.out.println("Encrypted: "+et);

        c.init(Cipher.DECRYPT_MODE,kp.getPrivate());
        System.out.println("Decrypted: "+
            new String(c.doFinal(Base64.getDecoder().decode(et))));
        sc.close();
    }
}
