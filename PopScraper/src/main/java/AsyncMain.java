import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncMain {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        // 1  took 3078ms
        // 10 took 1643ms
        // 20 took 1722ms
        // 50 took 1705ms
        int numThreads = 10;
        List<Future<Integer>> results = asyncScrape(numThreads);

        int total = 0;
        for (Future<Integer> result : results) {
            try {
                total += result.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("Total US Population: " + total);
        System.out.println("Took " + duration + "ms");
    }

    public static List<Future<Integer>> asyncScrape(int numThreads) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> results = new ArrayList<>();

        String url = "https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States#States";

        Document doc = Jsoup.connect(url).get();
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

            StateScrapeThread thread = new StateScrapeThread(stateUrl);
            Future<Integer> result = pool.submit(thread);
            results.add(result);
        }

        pool.shutdown();
        return results;
    }
}
