package com.groupdocs.parser.examples;

import com.groupdocs.parser.HyperlinkProperties;
import com.groupdocs.parser.IStructuredExtractor;
import com.groupdocs.parser.ListProperties;
import com.groupdocs.parser.ParagraphProperties;
import com.groupdocs.parser.ParagraphStyle;
import com.groupdocs.parser.StructuredHandler;
import com.groupdocs.parser.TableProperties;
import com.groupdocs.parser.TextProperties;
import com.groupdocs.parser.WordsTextExtractor;

public class StructuredHandlers {
	// ExStart:extractHeadersFromDocumentUsingStructuredHandler
	public static class Headers {
		public Headers()
		{}
		private class Handler extends StructuredHandler {

			// Handle List event to prevent processing of lists
			@Override
			protected void onStartList(ListProperties properties) {
				properties.setSkipElement(true); // ignore lists
			}

			// Handle Table event to prevent processing of tables
			@Override
			protected void onStartTable(TableProperties properties) {
				properties.setSkipElement(true); // ignore tables
			}

			// Handle ElementText event to process a text
			@Override
			protected void onText(TextProperties properties, String value) {
				sb.append(value);
			}

			// Handle Paragraph event to process a paragraph
			@Override
			protected void onStartParagraph(ParagraphProperties properties) {
				int h1 = (int) ParagraphStyle.Heading1;
				int h6 = (int) ParagraphStyle.Heading6;

				int style = properties.getStyle();
				if (h1 <= style && style <= h6) {
					if (sb.length() > 0) {
						sb.append("\r\n");
					}

					// make an indention for the header (h1 - no indention)
					sb.append(new String(new char[style - h1]).replace('\0', ' '));
				} else {
					// skip paragraph if it's not a header or a title
					properties.setSkipElement(properties.getStyle() != ParagraphStyle.Title);
				}
			}
		}

		private StringBuilder sb = new StringBuilder();
		/**
		 * Extracts headers from a document
		 * 
		 */
		public void extractHeader(java.io.InputStream stream) {
			IStructuredExtractor extractor = new WordsTextExtractor(stream);
			Handler handler = new Handler();

			// Extract a text with its structure
			extractor.extractStructured(handler);

			System.out.println(sb.toString());
		}
		
	}
	
	// ExEnd:extractHeadersFromDocumentUsingStructuredHandler

	// ExStart:extractHyperlinksFromDocumentUsingStructuredHandler
	public static class Hyperlinks {
		public Hyperlinks(){}
		private class Handler extends StructuredHandler {
			// Handle Hyperlink event to process a starting of a hyperlink
			@Override
			protected void onStartHyperlink(HyperlinkProperties properties) {
				sb = new StringBuilder();
				currentLink = properties.getLink();
			}

			// Handle ElementClose event to process a closing of a hyperlink
			@Override
			protected void onEndElement() {
				if (get_Item(0).getClass() == HyperlinkProperties.class) // closing
																			// of
																			// hyperlink
				{
					if (sb != null) {
						hyperlinks.add(String.format("%s (%s)", sb.toString(), currentLink));
					}
					sb = null;
					currentLink = null;
				}
			}

			// Handle ElementText event to process a text
			@Override
			protected void onText(TextProperties properties, String value) {
				if (sb != null) // if hyperlink is open
				{
					sb.append(value);
				}
			}
		}

		java.util.List<String> hyperlinks = new java.util.ArrayList<String>();
		StringBuilder sb = null;
		String currentLink = null;

		public void extract(java.io.InputStream stream) {
			IStructuredExtractor extractor = new WordsTextExtractor(stream);
			Handler handler = new Handler();

			// Extract a text with its structure
			extractor.extractStructured(handler);

			for (String hl : hyperlinks) {
				System.out.println(hl);
			}
		}
	}
	// ExEnd:extractHyperlinksFromDocumentUsingStructuredHandler
}
