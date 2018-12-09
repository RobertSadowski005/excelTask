package pl.sda;


import java.util.Scanner;

public class SumOfNumbersInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringMixOfIntegersAndChars = scanner.nextLine();
        //calculate(stringMixOfIntegersAndChars);

        calculate2(stringMixOfIntegersAndChars);
    }

    private static void calculate2(String stringMixOfIntegersAndChars) {

        String newValue = "";
        for (int i =0;i < stringMixOfIntegersAndChars.length(); i++){
            if (Character.isDigit(stringMixOfIntegersAndChars.charAt(i))){
                newValue+=stringMixOfIntegersAndChars.charAt(i);
            }
            else newValue+=" ";
        }
        newValue=newValue.replaceAll("  ", " ");
        String[] numbers = newValue.split(" ");

        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) continue;
            Integer cosTam = Integer.parseInt(number);
            sum+=cosTam;
        }
        System.out.println(sum);
    }

//    private static void calculate(String stringOfSomething) {
//        int sum = 0;
//        int temp = 0;
//        for (int i = 0; i < stringOfSomething.length(); i++) {
//            if (Character.isDigit(stringOfSomething.charAt(i))) {
//                temp = temp + Character.getNumericValue(stringOfSomething.charAt(i));
//                temp = temp * 10;
//            }
//            sum = sum + Character.getNumericValue(stringOfSomething.charAt(i));
//        }
//        System.out.println(sum);
//    }


}
