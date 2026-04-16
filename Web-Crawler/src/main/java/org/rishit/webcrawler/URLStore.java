package org.rishit.webcrawler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class URLStore {
    private final ConcurrentHashMap<String,Boolean> visitedUrl = new ConcurrentHashMap<String, Boolean>();
    private final BlockingQueue<String> UrlQueue = new LinkedBlockingQueue<>();

    public boolean addUrl(String url){
        if(visitedUrl.putIfAbsent(url,true) == null){
            UrlQueue.offer(url);
            return true;
        }
        return false;
    }

    public String getNextUrl() throws InterruptedException{
        return UrlQueue.poll();
    }

    public boolean isQueueEmpty(){
        return UrlQueue.isEmpty();
    }
}
