import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Testes {
	
	
	// This will find something on google images based on the search parameters and grab the first image
	public static void main(String[] args) {
		try {
        
/*		// can only grab first 100 results
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "https://www.google.com/search?site=imghp&tbm=isch&source=hp&q=kittens&gws_rd=cr";

		List<String> resultUrls = new ArrayList<String>();
		
		final String authUser = "f092-4";
		final String authPassword = "q1w2e3r4";
		Authenticator.setDefault(
		   new Authenticator() {
		      @Override
		      public PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(
		               authUser, authPassword.toCharArray());
		      }
		   }
		);

		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);

		
		URL url2 = new URL("http://www.example.com/");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 8080)); // or whatever your proxy is
		HttpURLConnection uc = (HttpURLConnection)url2.openConnection(proxy);

		  uc.connect();


		    Document doc = Jsoup.connect(url)
		    					.proxy(proxy)
		    					.userAgent(userAgent).referrer("https://www.google.com/").get();

		    Elements elements = doc.select("div.rg_meta");

		    JSONObject jsonObject;
		    for (Element element : elements) {
		        if (element.childNodeSize() > 0) {
		            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());
		            resultUrls.add((String) jsonObject.get("ou"));
		        }
		    }

		    System.out.println("number of results: " + resultUrls.size());

		    for (String imageUrl : resultUrls) {
		    	System.out.println(imageUrl+" -> "+imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length()));
		    	saveProxy(imageUrl, imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length()));
		    }

*/
			//saveImage("http://www4.trt23.jus.br/portal/arquivo/intranet/img/2018-02/vt_campanha_doacao_de_sangue_mp4_snapshot_00_32_2018_02_22_10_24_48-fit-1600x400.jpg", "aaaa.jpg");
			//saveImageByUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kitten_in_Rizal_Park%2C_Manila.jpg/1200px-Kitten_in_Rizal_Park%2C_Manila.jpg", "bbbb.jpg");
			
			javaxt.io.Image newImage = new javaxt.io.Image("images/1.png");
        	newImage.setHeight(50); //set width, adjusts height to maintain aspect ratio
        	//ImageIO.write( newImage.getRenderedImage(), "JPG", new File("images/1a200.jpg"));
        	ImageIO.write( newImage.getRenderedImage(), "PNG", new File("images/1a50.jpg"));
//        	newImage.setHeight(50); //set height, adjusts width to maintain aspect ratio
//        	newImage.resize(75, 150); //set width and height to whatever you want
			
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void saveImageByUrl(String urlString, String fileName){
		
		BufferedImage image = null;
		try{
			URL url = new URL(urlString);
			image = ImageIO.read(url);
			File toCreate = new File("images/"+fileName);
			ImageIO.write(image, "jpg", toCreate);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		
		final String authUser = "f092-4";
		final String authPassword = "q1w2e3r4";
		Authenticator.setDefault(
		   new Authenticator() {
		      @Override
		      public PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(
		               authUser, authPassword.toCharArray());
		      }
		   }
		);

		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);
		System.setProperty("http.proxyHost","proxy");
		System.setProperty("http.proxyPort","8080");
		
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "proxyHost", "proxy" );
		System.getProperties().put( "proxyPort", "8080" );

		//URL url2 = new URL(imageUrl);
		URL oracle = new URL(imageUrl);
	    HttpURLConnection httpcon = (HttpURLConnection) oracle.openConnection();
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

	    BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

	    
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 8080)); // or whatever your proxy is
//		HttpURLConnection uc = (HttpURLConnection)url2.openConnection(proxy);
//		uc.setRequestProperty(userAgent, imageUrl);
//		  uc.connect();

		
		
	    //URL url = new URL(imageUrl);
	    
	    //InputStream is = url.openStream();
	    //InputStream is = url2.openStream();
	    OutputStream os = new FileOutputStream(destinationFile);

	    byte[] b = new byte[2048];
	    int length;
	    String inputLine;
	    while ((inputLine = in.readLine()) != null)
	        System.out.println(inputLine);
	    in.close();

//	    while ((length = is.read(b)) != -1) {
//	        os.write(b, 0, length);
//	    }

//	    is.close();
	    os.close();
	}

	public static void saveProxy(String imageUrl, String file) {
        try {
            // This is where you'd define the proxy's host name and port.
        	SocketAddress address = new InetSocketAddress("proxy", 8080);

        	// Create an HTTP Proxy using the above SocketAddress.
        	Proxy proxy = new Proxy(Proxy.Type.HTTP, address);

        	URL url = new URL(imageUrl);

        	// Open a connection to the URL using the proxy information.
        	InputStream inStream = url.openConnection(proxy).getInputStream();

        	// BufferedImage image = ImageIO.read(url);
        	// Use the InputStream flavor of ImageIO.read() instead.
        	BufferedImage image = ImageIO.read(inStream);

        	ImageIO.write(image, "JPG", new File("images/"+file));
        	
        	
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
