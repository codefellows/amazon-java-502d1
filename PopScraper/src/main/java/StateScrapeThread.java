import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Callable;

public class StateScrapeThread implements Callable {
    private String url;

    StateScrapeThread(String url) {
        this.url = url;
    }

    @Override
    public Object call() throws Exception {
        int pop = 0;

        long start = System.currentTimeMillis();
        Document doc = Jsoup.connect(this.url).get();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Net request time " + duration);

        Element infobox = doc.selectFirst(".infobox.geography");
        Elements rows = infobox.select("tr");

        // iterate through every row in the info box
        for (Element row : rows) {
            // look for a header that says Population
            Element th = row.selectFirst("th");
            if (th != null && th.text().contains("Population")) {
                // access the next row and grab the population text
                String value = row.nextElementSibling().select("td").text();

                // pick out just the number from the text, and convert to an int
                value = value.split(" ")[0];
                value = value.replace(",", "");
                pop = Integer.parseInt(value, 10);
            }
        }
        return pop;
    }
}
