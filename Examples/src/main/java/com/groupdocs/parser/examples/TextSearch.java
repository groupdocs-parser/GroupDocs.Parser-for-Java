package com.groupdocs.parser.examples;

import com.groupdocs.parser.ListSearchHandler;
import com.groupdocs.parser.RegexSearchOptions;
import com.groupdocs.parser.SearchHighlightOptions;
import com.groupdocs.parser.SearchOptions;
import com.groupdocs.parser.WordsTextExtractor;

public class TextSearch {
	// ExStart:SourceDocumentFilePath
	private final static String FILE_PATH = "sample.docx";
	// ExEnd:SourceDocumentFilePath

	/**
	 * Searches text in a document.
	 * 
	 */
	public static void searchText() {
		// ExStart:searchText
		// Create a text extractor
		try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
			// Create a search handler. It is used to store search results
			ListSearchHandler handler = new ListSearchHandler();
			// Create search options with the fixed length highlight
			SearchOptions searchOptions = new SearchOptions(SearchHighlightOptions.createFixedLengthOptions(10));
			// Perform the search for two keywords
			extractor.search(searchOptions, handler, null,
					java.util.Arrays.asList(new String[] { "test text", "keyword" }));

			// If the handler contains data
			if (handler.getList().size() > 0) {
				/// Iterate over search results
				for (int i = 0; i < handler.getList().size(); i++) {
					System.out.println(handler.getList().get(i).getLeftText()); // text
																				// before
																				// the
																				// found
																				// text
					System.out.println("_");
					System.out.println(handler.getList().get(i).getFoundText()); // found
																					// text
																					// ("test
																					// text"
																					// or
																					// "keyword")
					System.out.println("_");
					System.out.println(handler.getList().get(i).getRightText()); // text
																					// after
																					// the
																					// found
																					// text
					System.out.println("---");
				}
			} else {
				System.out.println("Not found");
			}
		}
		// ExEnd:searchText
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Searches whole word in a document.
	 * 
	 */
	public static void searchWholeWord() {
		// ExStart:searchWholeWord
		// Create a text extractor
		try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
			// Create a search handler. It is used to store search results
			ListSearchHandler handler = new ListSearchHandler();
			// Create search options with the fixed length highlight
			SearchOptions searchOptions = new SearchOptions(SearchHighlightOptions.createFixedLengthOptions(10), true,
					true);
			// Perform the search for two keywords
			extractor.search(searchOptions, handler, null, java.util.Arrays.asList(new String[] { "keyword", "test" }));

			// If the handler contains data
			if (handler.getList().size() > 0) {
				/// Iterate over search results
				for (int i = 0; i < handler.getList().size(); i++) {
					System.out.println(handler.getList().get(i).getLeftText()); // text
																				// before
																				// the
																				// found
																				// text
					System.out.println("_");
					System.out.println(handler.getList().get(i).getFoundText()); // found
																					// text
																					// ("test"
																					// or
																					// "keyword")
					System.out.println("_");
					System.out.println(handler.getList().get(i).getRightText()); // text
																					// after
																					// the
																					// found
																					// text
					System.out.println("---");
				}
			} else {
				System.out.println("Not found");
			}
		}
		// ExEnd:searchWholeWord
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Searches with regular expression in a document.
	 * 
	 */
	public static void searchWithRegularExpression() {
		// ExStart:searchWithRegularExpression
		// Create a text extractor
		try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
			// Create a search handler. It is used to store search results
			ListSearchHandler handler = new ListSearchHandler();
			// Create search highlight options with the fixed length highlight
			// Perform the search with the regular expression
			extractor.searchWithRegex("19[0-9]{2}", handler,
					new RegexSearchOptions(SearchHighlightOptions.createFixedLengthOptions(10)));

			// If the handler contains data
			if (handler.getList().size() > 0) {
				/// Iterate over search results
				for (int i = 0; i < handler.getList().size(); i++) {
					System.out.println(handler.getList().get(i).getLeftText()); // text
																				// before
																				// the
																				// found
																				// text
					System.out.println("_");
					System.out.println(handler.getList().get(i).getFoundText()); // found
																					// text
					System.out.println("_");
					System.out.println(handler.getList().get(i).getRightText()); // text
																					// after
																					// the
																					// found
																					// text
					System.out.println("---");
				}
			} else {
				System.out.println("Not found");
			}
		}
		// ExEnd:searchWithRegularExpression
 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
