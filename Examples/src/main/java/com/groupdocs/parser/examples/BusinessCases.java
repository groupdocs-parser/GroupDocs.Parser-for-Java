package com.groupdocs.parser.examples;

import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.TextExtractor;

public class BusinessCases {
	//ExStart:WordStatistic
	class WordStatistic {
	    public WordStatistic(String fileName, int minWordlength) throws java.lang.Exception {
	        ExtractorFactory factory = new ExtractorFactory();
	        java.util.Map<String, Integer> statistic = new java.util.HashMap<String, Integer>();

	        TextExtractor extractor = factory.createTextExtractor(fileName);
	        if (extractor == null) {
	            System.out.println("The document's format is not supported");
	            return;
	        }

	        try {
	            String line = null;
	            do {
	                line = extractor.extractLine();
	                if (line != null) {
	                    String[] words = line.split("[ ,;.]");
	                    for (String w : words) {
	                        String word = w.trim().toLowerCase();
	                        if (word.length() > minWordlength) {
	                            int value = !statistic.containsKey(word) ? 0 : statistic.get(word);
	                            statistic.put(word, value + 1);
	                        }
	                    }
	                }
	            }
	            while (line != null);
	        } finally {
	            if (extractor != null) {
	                extractor.close();
	            }
	        }

	        System.out.println("Top words:");

	        for (int i = 0; i < 10; i++) {
	            int count = -1;
	            String maxKey = null;
	            for (String key : statistic.keySet()) {
	                if (statistic.get(key) > count) {
	                    count = statistic.get(key);
	                    maxKey = key;
	                }
	            }

	            if (maxKey == null) {
	                break;
	            }

	            System.out.println(String.format("%s: %d", maxKey, count));
	            statistic.remove(maxKey);
	        }
	    }
	}
	//ExEnd:WordStatistic
	
	//ExStart:FileViewer
	class FileViewer {
	    public FileViewer(String fileName, boolean formatted) throws java.lang.Exception {
	        int linesPerPage = 25;
	        ExtractorFactory factory = new ExtractorFactory();

	        TextExtractor extractor = formatted
	                ? factory.createFormattedTextExtractor(fileName)
	                : factory.createTextExtractor(fileName);

	        if (extractor == null) {
	            System.out.println("The document's format is not supported");
	            return;
	        }

	        try {
	            String line = null;
	            do {
	                System.out.println(fileName);

	                int lineNumber = 0;
	                do {
	                    line = extractor.extractLine();
	                    lineNumber++;
	                    if (line != null) {
	                        System.out.println(line);
	                    }
	                }
	                while (line != null && lineNumber < linesPerPage);

	                System.out.println();
	                System.out.println("Press q and Enter to exit or Enter to move to the next page");
	            }
	            while (line != null && System.in.read() != 'q');
	        } finally {
	            extractor.close();
	        }
	    }
	}
	//ExEnd:FileViewer


}
