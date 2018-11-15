package rot13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Cipher {

    // Шифровать
    public static String encrypt(String text) {
        if (text.isEmpty()) {
            throw new RuntimeException("Text is empty");
        }

        String res = "";
        for (int i = 0; i < text.length(); i++) {
            res += encryptChar(text.charAt(i));
        }

        return res;
    }

    // Расшифровать
    public static String decrypt(String text) {
        if (text.isEmpty()) {
            throw new RuntimeException("Text is empty");
        }

        String res = "";
        for (int i = 0; i < text.length(); i++) {
            res += decryptChar(text.charAt(i));
        }

        return res;
    }

    // Шифровать символ
    private static char encryptChar(char c) {
        //return c == Character.MAX_VALUE ? '\0' : (char)(c + 1);

        if (c >= 'a' && c <= 'm') {
            c += 13;
        } else if (c >= 'A' && c <= 'M') {
            c += 13;
        } else if (c >= 'n' && c <= 'z') {
            c -= 13;
        } else if (c >= 'N' && c <= 'Z') {
            c -= 13;
        }
        try (FileWriter fw = new FileWriter("out.txt");
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return c;

    }

    // Расшифровать символ
    private static char decryptChar(char c) {
        //return c == '\0' ? Character.MAX_VALUE : (char)(c - 1);

        if (c >= 'a' && c <= 'm') {
            c += 13;
        } else if (c >= 'A' && c <= 'M') {
            c += 13;
        } else if (c >= 'n' && c <= 'z') {
            c -= 13;
        } else if (c >= 'N' && c <= 'Z') {
            c -= 13;
        }

        return c;

    }
}
