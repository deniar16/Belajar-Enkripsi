/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enkripsi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author DeNiSa
 */
public class Enkripsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int jam = calendar.get(Calendar.HOUR_OF_DAY);
        int menit = calendar.get(Calendar.MINUTE);
        System.out.println("Sekarang Jam: " + jam + ", menit : " + menit);
        System.out.println("Subtitution Cipher, jika angka (ganjil) geser sesuai jam, jika angka (genap) geser sesuai menit");
        
        String password = "ab";
        String encrypt = SubtitutionCipher.getEncryptWithKeyFromTime(password, jam, menit);
        String decrypt = SubtitutionCipher.getDecryptWithKeyTime(encrypt, jam, menit);

        System.out.println("Password : " + password);
        System.out.println("Encrypt : " + encrypt);
        System.out.println("Decrypt : " + decrypt);

        System.out.println("=================================================================================================");
        
        String password2 = "MerCuBuaNa";
        String encrypt2 = SubtitutionCipher.getEncryptWithKeyFromTime(password2, jam, menit);
        String decrypt2 = SubtitutionCipher.getDecryptWithKeyTime(encrypt2, jam, menit);

        System.out.println("Password : " + password2);
        System.out.println("Encrypt : " + encrypt2);
        System.out.println("Decrypt : " + decrypt2);
    }

}
