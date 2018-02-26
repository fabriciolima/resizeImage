
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestImage {

    public static void main(String[] args) {

    	try {
    	String google = "http://www.google.com/search?q=";
    	String search = "stackoverflow";
    	String charset = "UTF-8";
    	String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

    	Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");
		

    	for (Element link : links) {
    	    String title = link.text();
    	    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
    	    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

    	    if (!url.startsWith("http")) {
    	        continue; // Ads/news/etc.
    	    }

    	    System.out.println("Title: " + title);
    	    System.out.println("URL: " + url);
    	}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}