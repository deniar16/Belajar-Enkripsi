/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enkripsi;

/**
 *
 * @author DeNiSa
 */
public class SubtitutionCipher {

    public static final char[] abjad = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};

    public static String getEncryptWithKeyFromTime(String password, int keyHour, int keyMinute) {
        char[] passwordArray = password.toCharArray();
        String encryptPassword = "";
        int posisi = 0;
        int indexKarakter = 0;
        for (char charPasswd : passwordArray) {
            if (charPasswd != ' ') {
                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));
                if (indexKarakter % 2 == 0) {
                    posisi = posisi + (keyMinute % 52);
                    if (posisi >= 52) {
                        posisi = posisi - 52;
                    }
                } else if (indexKarakter % 2 == 1) {
                    posisi = posisi + (keyHour % 52);
                    if (posisi >= 52) {
                        posisi = posisi - 52;
                    }
                }
                encryptPassword += abjad[posisi];

            } else {
                encryptPassword += " ";
            }
            indexKarakter = indexKarakter + 1;
        }
        return encryptPassword;
    }

    public static String getDecryptWithKeyTime(String encryptPassword, int keyHour, int keyMinute) {
        char[] passwordArray = encryptPassword.toCharArray();
        String decryptPassword = "";
        int posisi = 0;
        int indexKarakter = 0;
        for (char charPasswd : passwordArray) {

            if (charPasswd != ' ') {

                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));
                if (indexKarakter % 2 == 0) {
                    posisi = posisi - (keyMinute % 52);
                    if (posisi < 0) {
                        posisi = 52 + posisi;
                    }
                } else if (indexKarakter % 2 == 1) {
                    posisi = posisi - (keyHour % 52);
                    if (posisi < 0) {
                        posisi = 52 + posisi;
                    }

                }
                decryptPassword += abjad[posisi];
            } else {
                decryptPassword += " ";
            }
            indexKarakter = indexKarakter + 1;
        }

        return decryptPassword;
    }

    public static String getEncryptPassword(String password, int key) {
        char[] passwordArray = password.toCharArray();
        String encryptPassword = "";
        int posisi = 0;
        for (char charPasswd : passwordArray) {
            if (charPasswd != ' ') {
                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));

                posisi = posisi + (key % 52);
                if (posisi > 52) {
                    posisi = posisi - 52;
                }

                encryptPassword += abjad[posisi];

            } else {
                encryptPassword += " ";
            }
        }
        return encryptPassword;
    }

    public static String getDecryptPassword(String encryptPassword, int key) {
        char[] passwordArray = encryptPassword.toCharArray();
        String decryptPassword = "";
        int posisi = 0;
        for (char charPasswd : passwordArray) {

            if (charPasswd != ' ') {
                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));
                posisi = posisi - (key % 52);
                if (posisi < 0) {
                    posisi = 52 + posisi;
                }
                decryptPassword += abjad[posisi];
            } else {
                decryptPassword += " ";
            }
        }

        return decryptPassword;
    }
}
