package com.groupdocs.parser.examples.Tools;

import com.groupdocs.parser.CellsMediaTypeDetector;
import com.groupdocs.parser.CompositeMediaTypeDetector;
import com.groupdocs.parser.MediaTypeDetector;
import com.groupdocs.parser.MediaTypeNames;
import com.groupdocs.parser.NoteMediaTypeDetector;
import com.groupdocs.parser.examples.Common;

public class MediaTypeDetectors {
	private final static String FILE_PATH = "sample.xlsx";

	/**
	 * Detects media type by content.
	 * 
	 */
	public static void detectMediaTypeByContent() {
		try {
			// ExStart:detectMediaTypeByContent 
			// Create a media type detector
			CellsMediaTypeDetector detector = new CellsMediaTypeDetector();
			// Detect the media type by the content of the stream
			String mediaType = detector.detect(new java.io.FileInputStream(Common.mapSourceFilePath(FILE_PATH)));
			// Print the detected media type (if detected)
			System.out.println(mediaType == null ? "Can't detect a media type" : mediaType);
			// ExEnd:detectMediaTypeByContent
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Detects media type by extension of file.
	 * 
	 */
	public static void detectMediaTypeByExtension() {
		try {
			// ExStart:detectMediaTypeByExtension
			// Create a media type detector
			CellsMediaTypeDetector detector = new CellsMediaTypeDetector();
			// Detect the media type by the content of the stream
			String mediaType = detector.detect(Common.mapSourceFilePath(FILE_PATH));
			// Print the detected media type (if detected)
			System.out.println(mediaType == null ? "Can't detect a media type" : mediaType);
			// ExEnd:detectMediaTypeByExtension
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Detects whether the media type is supported by the detector.
	 * 
	 */
	public static void IsMediaTypeSupportedByDetector() {
		try {
			// ExStart:IsMediaTypeSupportedByDetector
			// Create a media type detector
			CellsMediaTypeDetector detector = new CellsMediaTypeDetector();
			// Write true if the detector supports Excel files
			System.out.println(detector.supports(MediaTypeNames.Application.EXCEL));
			// ExEnd:IsMediaTypeSupportedByDetector
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Detects media type of OneNote section
	 * 
	 */
	public static void detectMediaTypeOfOneNoteSection() {
		try {
			// ExStart:detectMediaTypeOfOneNoteSection
			// Create a media type detector
			NoteMediaTypeDetector detector = new NoteMediaTypeDetector();
			// Detect the media type by the content of the stream
			String mediaType = detector.detect(Common.mapSourceFilePath(FILE_PATH));
			// Print the detected media type (if detected)
			System.out.println(mediaType == null ? "Can't detect a media type" : mediaType);
			// ExEnd:detectMediaTypeOfOneNoteSection
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Detects media type using CompositeMediaTypeDetector
	 * 
	 */
	public static void detectMediaTypeUsingCompositeMediaTypeDetector() {
		try {
			// ExStart:detectMediaTypeUsingCompositeMediaTypeDetector_18.12
			 // Get a default composite media type detector
			MediaTypeDetector detector = CompositeMediaTypeDetector.DEFAULT;

			// Detect a media type
			String mediaType = detector.detect(Common.mapSourceFilePath(FILE_PATH));
			// Print the detected media type (if detected)
			System.out.println(mediaType == null ? "Can't detect a media type" : mediaType);
			// ExEnd:detectMediaTypeUsingCompositeMediaTypeDetector_18.12
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
