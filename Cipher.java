/** Project: Solo lab 5 (cipher)
 * Purpose Details: Cipher created by students and presented
 * Course: IST242
 * Author: Ryan Zheng
 * Date Developed: 10/30/24
 * Last Date Changed: 11/13/24
 * Rev: 2
 */
import java.util.HashMap;
import java.util.Scanner;

/**
 * this  class cipher where we use two basic cipher,
 * at first we ask user to enter number. once we determine the number is even or odd.
 * once the number is even or odd determined, we use if condition to determine which cipher we use
 * if the number is odd, it will use reverse cipher function to encryption and decryption
 * if the number is even, it will use substitution function to encryption and decryption
 * @param
 */
public class Cipher {

    public static void main(String[] args) {
        // this is the scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is number?: ");
        int number = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter plaintext: ");
        // plaintext is the String that pulls out what's inside of scanner line
        String plaintext = scanner.nextLine();
        /**
         * in here we use if statement to see if the number is even or odd.
         * once we know even or odd, it will use condition to run the cipher method.
         */
        String result;
        if (number % 2 == 0) {
            result = convertto(plaintext);
            System.out.println("encrypt text: " + result);
            String decodedText = convertback(result);
            System.out.println("decrypted text: " + decodedText);
        } else {
            result = encrypt(plaintext);
            System.out.println("Encrypted text : " + result);
            String decryptedText = decrypt(result);
            System.out.println("Decrypted text: " + decryptedText);
        }
        scanner.close();
    }

    /**
     *
     * @param plaintext the text to be encrypted for the function
     * @return the encrypted string
     */
    // method , return encrypt String.
    // need to use static because so can it can be use for reference from static context.
    public static String encrypt(String plaintext) {
        // StringBuilder is an object, empty string building that pulls text from plaintext which it is append.
        StringBuilder encryptedText = new StringBuilder();
        // use counter control for loop, but in the reverse way. from last to beginning, it continues to loop until length index is >= 0;
        // for example if length text is 9, then last index is 9-8, so it continues to loop every time it -1, until it counts i >=0;
        // and it appends the text into plaintext, counter control if statement.
        for (int i = plaintext.length() - 1; i >= 0; i--) {
            encryptedText.append(plaintext.charAt(i));
        }
        // change from StringBuilder to string.
        return encryptedText.toString();
    }

    /**
     *
     * @param ciphertext the text to be encrypted for the function
     *
     * @return the encrypted string
     */
    public static String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();

        // Decryption by reversing the ciphertext
        for (int i = ciphertext.length() - 1; i >= 0; i--) {
            decryptedText.append(ciphertext.charAt(i));
        }

        return decryptedText.toString();
    }

    // mapping that convert to  according to the map corresponding string
    public static String convertto(String text) {
        // mapping for encryption
        //create a hashmap name toMap, where each character is going to be corresponding string
        HashMap<Character, String> toMap = new HashMap<>();
        toMap.put('A', "01"); toMap.put('B', "02");
        toMap.put('C', "03"); toMap.put('D', "04");
        toMap.put('E', "05"); toMap.put('F', "06");
        toMap.put('G', "07"); toMap.put('H', "08");
        toMap.put('I', "09"); toMap.put('J', "10");
        toMap.put('K', "11"); toMap.put('L', "12");
        toMap.put('M', "13"); toMap.put('N', "14");
        toMap.put('O', "15"); toMap.put('P', "16");
        toMap.put('Q', "17"); toMap.put('R', "18");
        toMap.put('S', "19"); toMap.put('T', "20");
        toMap.put('U', "21"); toMap.put('V', "22");
        toMap.put('W', "23"); toMap.put('X', "24");
        toMap.put('Y', "25"); toMap.put('Z', "26");
        toMap.put('1', "*1"); toMap.put('2', "*2");
        toMap.put('3', "*3"); toMap.put('4', "*4");
        toMap.put('5', "*5"); toMap.put('6', "*6");
        toMap.put('7', "*7"); toMap.put('8', "*8");
        toMap.put('9', "*9"); toMap.put('0', "*0");

        StringBuilder codeBuilder = new StringBuilder();
        text = text.toUpperCase();
        // for each loop, if
        //text.toCharArray() convert text string
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                codeBuilder.append(" ");
            } else if (toMap.containsKey(c)) {
                codeBuilder.append(toMap.get(c)).append(" ");
            }
        }

        return codeBuilder.toString().trim();
    }

    // Convert back from corresponding map back to original character
    public static String convertback(String text) {
        HashMap<String, Character> charMap = new HashMap<>();
        charMap.put("01", 'A'); charMap.put("02", 'B');
        charMap.put("03", 'C'); charMap.put("04", 'D');
        charMap.put("05", 'E'); charMap.put("06", 'F');
        charMap.put("07", 'G'); charMap.put("08", 'H');
        charMap.put("09", 'I'); charMap.put("10", 'J');
        charMap.put("11", 'K'); charMap.put("12", 'L');
        charMap.put("13", 'M'); charMap.put("14", 'N');
        charMap.put("15", 'O'); charMap.put("16", 'P');
        charMap.put("17", 'Q'); charMap.put("18", 'R');
        charMap.put("19", 'S'); charMap.put("20", 'T');
        charMap.put("21", 'U'); charMap.put("22", 'V');
        charMap.put("23", 'W'); charMap.put("24", 'X');
        charMap.put("25", 'Y'); charMap.put("26", 'Z');
        charMap.put("*1", '1'); charMap.put("*2", '2');
        charMap.put("*3", '3'); charMap.put("*4", '4');
        charMap.put("*5", '5'); charMap.put("*6", '6');
        charMap.put("*7", '7'); charMap.put("*8", '8');
        charMap.put("*9", '9'); charMap.put("*0", '0');

        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            if (charMap.containsKey(word)) {
                result.append(charMap.get(word));
            } else {
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
