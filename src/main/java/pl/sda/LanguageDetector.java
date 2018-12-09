package pl.sda;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LanguageDetector {

    public static void main(String[] args) throws APIError, IOException {
      //  String language = detect("Masz małe ale fajne cycki");
    //    System.out.println("Język to " + language);

  //      String lines = readLinesFromFile("C:\\Users\\Robert\\Desktop\\chunichi.txt");
//        System.out.println(detect(lines));

//        List<String> filePaths = readAllFilePaths("C:\\Users\\Robert\\Desktop\\artykuły");

        detectLanguagesInFolder("C:\\Users\\Robert\\Desktop\\artykuły");
    }

    private static void detectLanguagesInFolder(String folderPath) throws APIError, IOException {

        List<String> filePaths = readAllFilePaths(folderPath);
        for(String filePath : filePaths) {
            String lines = readLinesFromFile(filePath);
            System.out.println(filePath + " " + detect(lines));
        }

    }

    private static String readLinesFromFile(String filePath) throws IOException {
        return new  String(Files.readAllBytes(Paths.get(filePath)));
    }

    private static List<String> readAllFilePaths (String path) {
        List<String> filePaths = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                filePaths.add(file.getAbsolutePath());
            }
        }
        return filePaths;
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
