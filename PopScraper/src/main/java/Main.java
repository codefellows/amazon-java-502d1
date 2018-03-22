import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        scrape();

        long duration = System.currentTimeMillis() - start;
        System.out.println("Took " + duration + "ms");
    }

    public static void scrape() throws IOException {
        String url = "https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States#States";

        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.title());
        Element table = doc.selectFirst("table tbody");
        Elements rows = table.select("tr");

        int totalPopulation = 0;
        int count = 0;
        for (Element row : rows) {
            count++;
            if (count <= 2) {
               continue;
            }

            Element link = row.selectFirst("a");
            String stateUrl = link.absUrl("href");
            Document stateDoc = Jsoup.connect(stateUrl).get();

            totalPopulation += getPopulation(stateDoc, link.text());
        }
        System.out.println("Total US Population: " + totalPopulation);
    }

    public static int getPopulation(Document doc, String state) {
        int pop = 0;

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
