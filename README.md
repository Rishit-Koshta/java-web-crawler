# 🌐 Multithreaded Web Crawler (Java)

A **concurrent web crawler built in Java** that recursively explores web pages, extracts hyperlinks, and processes them in parallel using multiple threads.

This project showcases real-world backend concepts like **multithreading, synchronization, concurrent data structures, and task coordination**.

---

## 🚀 Features

* 🔗 Crawls web pages starting from a seed URL
* 🔁 Recursive crawling with configurable depth
* ⚡ Multi-threaded execution using `ExecutorService`
* 🧠 Prevents duplicate visits using `ConcurrentHashMap`
* 📦 Thread-safe URL management with `BlockingQueue`
* ⏱️ Task synchronization using `Phaser`
* 🌐 HTML parsing and link extraction

---

## 🛠️ Tech Stack

* **Java**
* **Jsoup** – HTML parsing
* Java Concurrency Utilities:

  * `ExecutorService`
  * `Phaser`
  * `ConcurrentHashMap`
  * `BlockingQueue`

---

## 📂 Project Structure

```bash
src/main/java/com/rishit/webcrawler/
├── WebCrawler.java      # Main entry point
├── CrawlerTask.java     # Worker thread logic
├── URLFetcher.java      # Fetches and parses links
└── URLStore.java        # Manages visited URLs & queue
```

---

## ⚙️ How It Works

1. User inputs:

   * Seed URL
   * Maximum crawl depth
   * Number of worker threads

2. The crawler:

   * Adds the seed URL to a thread-safe queue
   * Multiple worker threads process URLs concurrently
   * Each page is parsed to extract hyperlinks
   * New, unvisited links are added to the queue
   * Crawling continues until depth limit is reached

3. `Phaser` ensures all threads complete execution before shutdown.

---

## ▶️ How to Run

### 🔹 Using Maven (Recommended)

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.rishit.webcrawler.WebCrawler"
```

---

### 🔹 Using IDE

1. Import project into IntelliJ / Eclipse
2. Ensure Maven dependencies are loaded
3. Run `WebCrawler.java`

---

## 🧪 Example

```
Enter your url
https://example.com

Enter the depth of the crawler
2

Enter the number of workers
5
```

---

## 🧠 Key Concepts Demonstrated

* Multithreading & Parallel Processing
* Thread Pool Management
* Synchronization using `Phaser`
* Concurrent Data Structures
* Graph Traversal (BFS-style crawling)
* HTML Parsing

---

## ⚠️ Limitations

* Does not respect `robots.txt`
* No rate limiting
* No persistent storage
* Basic error handling

---

## 📈 Learning Outcomes

* Understanding how web crawlers work
* Handling concurrency in real-world systems
* Designing efficient and scalable applications
* Managing shared resources safely across threads

---

## 📜 License

This project is open-source and available under the MIT License.

---

## 🙌 Acknowledgment

Inspired by the working principles of search engines and distributed systems.

---
