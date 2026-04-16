package org.rishit.webcrawler;
import java.util.Set;
import java.util.concurrent.Phaser;

public class CrawlerTask implements Runnable {
    private final URLStore urlStore;
    private final URLFetcher urlFetcher;
    private final int maxDepth;
    private final int currentDepth;
    private final Phaser phaser;

    public CrawlerTask(URLStore urlStore, URLFetcher urlFetcher, int maxDepth, int currentDepth, Phaser phaser) {
        this.urlStore = urlStore;
        this.urlFetcher = urlFetcher;
        this.maxDepth = maxDepth;
        this.currentDepth = currentDepth;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            String url = urlStore.getNextUrl();
            System.out.println(Thread.currentThread().getName() + " " + url);

            if (url == null || currentDepth > maxDepth) {
                return;
            }

            Set<String> links = urlFetcher.fetchLinks(url);
            for (String link : links) {
                if (urlStore.addUrl(link)) {
                    phaser.register();
                    // Assuming WebCrawler has a static submitTask method as shown in the image
                    WebCrawler.submitTask(urlStore, urlFetcher, currentDepth + 1, maxDepth, phaser);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured!!");
        } finally {
            phaser.arriveAndDeregister();
        }
    }
}