package pl.sda;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class JSoupParser {
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.wp.pl/");
        Document document = connect.get();
        Elements allH1 = document.select("h3");
        for(Element elem: allH1) {
            System.out.println(elem.text());
        }

        System.out.println(document.getAllElements());
    }
}
