package pl.sda;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LanguageDetector {

    public static void main(String[] args) throws APIError, IOException {
        String language = detect("Masz małe ale fajne cycki");
        System.out.println("Język to " + language);

        String lines = readLinesFromFile("C:\\Users\\Robert\\Desktop\\chunichi.txt");
        System.out.println(detect(lines));
    }

    private static String readLinesFromFile(String filePath) throws IOException {
        return new  String(Files.readAllBytes(Paths.get(filePath)));
    }

    private static String detect (String words) throws APIError {
        DetectLanguage.apiKey = "477892d2b3537e3ec4351b2d1db19ca0";
        List<Result> results = DetectLanguage.detect(words);


        Result result = results.get(0);

        System.out.println("Language: " + result.language);
        System.out.println("Is reliable: " + result.isReliable);
        System.out.println("Confidence: " + result.confidence);
        return result.language;
    }
}
