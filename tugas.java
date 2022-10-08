package test;

import java.util.ArrayList;
import java.util.Scanner;

public class tugas {
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String Plaintext, int key) {
        Plaintext = Plaintext.toLowerCase();
        String cipherText = "";
        for (int ii = 0; ii < Plaintext.length(); ii++) { // Mengambil index Posisi setiap Alfabet dari input Plaintext
            int charPosition = alphabet.indexOf(Plaintext.charAt(ii)); // Rumus Caesar Cypher Enkripsi
            int keyVal = (key + charPosition) % 26; // Mengenkripsi index Posisi
            char replaceVal = alphabet.charAt(keyVal); // Mengambil Alfabet sesuai index posisi Enkripsi
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int key) {
        cipherText = cipherText.toLowerCase();
        String Plaintext = "";
        for (int ii = 0; ii < cipherText.length(); ii++) { // Mengambil index Posisi setiap Alfabet dari Enkripsi
            int charPosition = alphabet.indexOf(cipherText.charAt(ii)); // Rumus Caesar Cypher Enkripsi
            int keyVal = (charPosition - key) % 26; // Mengdekripsi index Posisi
            if (keyVal < 0) {
                keyVal = alphabet.length() + keyVal;
            }
            char replaceVal = alphabet.charAt(keyVal);// Mengambil Alfabet sesuai index posisi Dekripsi
            Plaintext += replaceVal;
        }
        return Plaintext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Plaintext = new String();
        int key = 0;
        System.out.print("Text to Encryption:");
        Plaintext = sc.next();

        System.out.println("\n\nEnter Key:");
        key = sc.nextInt();
        String test = encrypt(Plaintext, key);
        System.out.println("Encrpyted Text:" + test);
        System.out.println("Decrypted Text:" + decrypt(test, key));
    }
}