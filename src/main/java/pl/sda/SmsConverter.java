package pl.sda;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SmsConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        convert(message);
    }

    static String convert(String message) {
        List<String> tableFromScannedMessage = Pattern.compile(" ")
                .splitAsStream(message)
                .collect(Collectors.toList());
        //System.out.println(tableFromScannedMessage);
        //String[] tableFromScannedMessage = message.split(" ");

        String stringsWithUpperCase = "";
        for (String word : tableFromScannedMessage) {
            //wyrwałem pierwszą literę i zrobiłem ją dużą.
            //stringsWithUpperCase = word.substring(0, 1).toUpperCase();
            stringsWithUpperCase += word.toUpperCase().charAt(0);
            if (word.length() >= 2) {
                //dodaję resztę napisu do wcześniej zwiększonej litery.
                stringsWithUpperCase += word.substring(1);
            }
        }
        System.out.println(stringsWithUpperCase);

        /*String stringFromListedMessage = String.join("", stringsWithUpperCase);
        System.out.println(stringFromListedMessage);*/
        return null;
    }
}

