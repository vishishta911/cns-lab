import javax.crypto.*;
import java.util.Base64;

class DES {
    public static void main(String[] args) throws Exception {

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey k = kg.generateKey();

        Cipher c = Cipher.getInstance("DES");

        String pt = "Hello";
        System.out.println("Plain Text: " + pt);

        c.init(Cipher.ENCRYPT_MODE, k);
        String et = Base64.getEncoder()
                .encodeToString(c.doFinal(pt.getBytes()));
        System.out.println("Encrypted: " + et);

        c.init(Cipher.DECRYPT_MODE, k);
        String dt = new String(c.doFinal(
                Base64.getDecoder().decode(et)));
        System.out.println("Decrypted: " + dt);
    }
}
