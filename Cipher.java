import java.util.Scanner;

public class Cipher {

    public static void main(String[] args) {
        // this is the scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        //plaintext is the String that pull out what's inside of scanner line
        String plaintext = scanner.nextLine();

        String encryptedText = encrypt(plaintext);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
    //method , return encrypt String.
    // need to use static because so can it can be use for reference from static context.
    public static String encrypt(String plaintext) {
        //stringbuilder is an obeject, empty string building that pull text from plaintext which it is append.
        StringBuilder encryptedText = new StringBuilder();
// use standard  for loop,  but in the reverse way. from last to beginning, it continue to loop until length index is >= 0; for example if length
// text is 9, then last index is 9-8, so it continue to loop everytime it -1, until it count i >=0; and it append the text
// into plaintext
        for (int i = plaintext.length() - 1; i >= 0; i--) {
            encryptedText.append(plaintext.charAt(i));
        }
                // change from string builder to string.
        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();

        // Decryption by reversing the ciphertext
        for (int i = ciphertext.length() - 1; i >= 0; i--) {
            decryptedText.append(ciphertext.charAt(i));
        }

        return decryptedText.toString();
    }
}
