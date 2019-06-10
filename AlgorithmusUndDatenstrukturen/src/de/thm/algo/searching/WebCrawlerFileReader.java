package de.thm.algo.searching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import de.thm.algo.searching.common.Element;
import de.thm.algo.searching.common.SearchDataStructure;

public class WebCrawlerFileReader {
	
	/** Path to the folder with all input files. */
	private final String path;
	
	/** Data structure that the read keywords are inserted into. */
	private final SearchDataStructure data;
	
	/** Maximum number of keywords to be read. */
	private final int readLimit;
	
	public WebCrawlerFileReader(String path, SearchDataStructure data) {
		this(path, data, Integer.MAX_VALUE);
	}

	public WebCrawlerFileReader(String path, SearchDataStructure data, int readLimit) {
		this.path = path;
		this.data = data;
		this.readLimit = readLimit;
	}


	/** Reads all files in our own Webcrawler format. */
	public void read() {
		int totalNoOfSites = 0;
		int totalNoOfKeywords = 0;

		for (File file : (new File(path)).listFiles()) {
			if (totalNoOfKeywords >= readLimit) break;
			final String filename = file.getName();
			if (!filename.startsWith("sites-") || !filename.endsWith(".txt")) continue;
			System.out.print("open " + filename + " to read data... ");
			final long startTimeNs = System.nanoTime();
			Scanner scanner;
			try {
				scanner = new Scanner(file);
				scanner.useLocale(Locale.US); // to read floats with a dot (e.g. "1.0")
			} catch (FileNotFoundException e) {
				System.out.println("NOT FOUND.");
				continue;
			}
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {				
				totalNoOfSites++;
				String url = scanner.next();
				scanner.next();
				scanner.nextFloat();
				int noOfKeywords = scanner.nextInt();
				for (int j = 0; j < noOfKeywords; j++) {
					String keyword = scanner.next();
					scanner.nextInt();
					Element element = data.find(keyword);
					if (element == null) {
						totalNoOfKeywords++;
						element = new Element(keyword);
						data.insert(element);
					}
					element.addExtra(url);
					if (totalNoOfKeywords >= readLimit) break;
				}
				if (totalNoOfKeywords >= readLimit) break;
				skipLinks(scanner);				
			}
			final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
			System.out.println("DONE (" + elapsedTimeMs + " ms). #sites: " + totalNoOfSites + ", #keywords: " + totalNoOfKeywords);
		}
	}
	
	/** Skips all links in the input since we do not need them here. */
	private void skipLinks(Scanner scanner) {
		int noOfLinks = scanner.nextInt();
		for (int i = 0; i < noOfLinks; i++) {
			scanner.next();
			int noOfKeywords = scanner.nextInt();
			for (int j = 0; j < noOfKeywords; j++) {
				scanner.next();
				scanner.nextInt();					
			}
		}
	}

}
