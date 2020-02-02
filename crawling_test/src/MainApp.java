import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {

	private static String URL = "https://www.linkedin.com/jobs/search/?";
//	private static String URL = "https://www.linkedin.com/jobs/search/?f_E=1%2C2&geoId=100604989&keywords=software%20developer&location=South%20Australia%2C%20Australia&sortBy=DD";

	public static void main(String[] args) throws IOException {
		String KEY_WORD = "software%20developer";
//		System.out.println("URL :: " + URL + getParameter(KEY_WORD));
//		//1. bring Document
		Document doc = Jsoup.connect(URL + getParameter(KEY_WORD)).get();
//		Document doc = Jsoup.connect(URL).get();
		
		//2. bring list
//		System.out.println("" + doc.toString());
		Elements elements = doc.select(".result-card");
		
//		System.out.println("" + elements.text());
		
//		3. listing the information
		int idx = 0;
		for(Element element : elements) {
			
//			System.out.println(++idx + " : " + element.toString());
			System.out.println(++idx + " : " + element.text());
			System.out.println("==========================================\n\n");
		}
	}

	
	/**
	 * URL 
	 * @param KEY_WORD
	 * @param PAGE
	 * @return
	 */
	public static String getParameter(String KEY_WORD) {
		return "f_E=1%2C2"
				      + "&geoId=100604989"
				      + "&keywords=" + KEY_WORD
				      + "&location=South%20Australia%2C%20Australia"
				      + "&sortBy=DD";

	}
	
}
