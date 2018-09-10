package com.groupdocs.parser.examples;

import java.io.BufferedReader;
import java.io.InputStream;

import com.groupdocs.parser.CellsMediaTypeDetector;
import com.groupdocs.parser.Container;
import com.groupdocs.parser.ContainerEnumerator;
import com.groupdocs.parser.DbContainer;
import com.groupdocs.parser.EmailConnectionInfo;
import com.groupdocs.parser.EmailContainer;
import com.groupdocs.parser.EmailTextExtractor;
import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.GroupDocsParserException;
import com.groupdocs.parser.IContainerFactory;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.MediaTypeDetector;
import com.groupdocs.parser.MetadataNames;
import com.groupdocs.parser.PersonalStorageContainer;
import com.groupdocs.parser.TextExtractor;
import com.groupdocs.parser.ZipContainer;

public class Containers {
	// ExStart:SourceOSTDocumentFilePath
	private final static String OST_FILE_PATH = "sample.ost";
	private final static String ZIP_FILE_PATH = "sample.zip";
	private final static String DB_FILE_PATH = "sample.sqlite";
	// ExEnd:SourceOSTZIPDocumentFilePath
	/**
	 * Creates containers
	 * 
	 */
	public static void createContainer() {
		try {
			// ExStart:createContainer
			// Create a factory
			ExtractorFactory factory = new ExtractorFactory(null, new CellsMediaTypeDetector());

			// Try to create a container from the file
			Container container = factory.createContainer(Common.mapSourceFilePath(OST_FILE_PATH));
			if (container == null) {
				System.out.println("The document format is not supported");
			}

			// Try to create a container from the stream
			Container container2 = factory.createContainer(Common.mapSourceFilePath(OST_FILE_PATH));
			if (container == null) {
				System.out.println("The document format is not supported");
			}

			// Create load options
			LoadOptions loadOptions = new LoadOptions("text/plain", java.nio.charset.Charset.forName("UTF-8"));
			// Try to create a container from the stream with load options
			Container container3 = factory.createContainer(Common.mapSourceFilePath(OST_FILE_PATH), loadOptions);
			if (container == null) {
				System.out.println("The document format is not supported");
			}
			// ExEnd:createContainer
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts messages from OST-container.
	 * 
	 */
	public static void extractMessagesFromOST() {
		try {
			// ExStart:extractMessagesFromOST
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Create a container
			try (PersonalStorageContainer container = new PersonalStorageContainer(
					Common.mapSourceFilePath(OST_FILE_PATH))) {
				// Iterate over container's entities
				for (int i = 0; i < container.getEntities().size(); i++) {
					System.out.println("Name: " + container.getEntities().get(i).getName()); // name
																								// of
																								// the
																								// file
					System.out.println("Path: " + container.getEntities().get(i).getPath().toString()); // path
																										// of
																										// the
																										// file
					System.out.println("MediaType :" + container.getEntities().get(i).getMediaType()); // media
																										// type
																										// of
																										// the
																										// file
					System.out.println("Date: " + container.getEntities().get(i).getDate().toString()); // date
																										// when
																										// the
																										// file
																										// was
																										// added
																										// to
																										// the
																										// archive
					System.out.println("Size: " + container.getEntities().get(i).getSize()); // uncompressed
																								// size
																								// of
																								// the
																								// file
					System.out.println("Subject: " + container.getEntities().get(i).get_Item(MetadataNames.SUBJECT)); // subject
																														// of
																														// the
																														// email
					System.out.println("From: " + container.getEntities().get(i).get_Item(MetadataNames.EMAIL_FROM)); // "from"
																														// addresses
																														// of
																														// the
																														// email
					System.out.println("To: " + container.getEntities().get(i).get_Item(MetadataNames.EMAIL_TO)); // "to"
																													// addresses
																													// of
																													// the
																													// email

					// Try to create a text extractor for the file of the
					// container
					TextExtractor extractor = factory.createTextExtractor(container.getEntities().get(i).openStream());
					System.out.println("Content:");
					// If the text extractor is supported (extractor != null),
					// then extract a text from the document
					System.out.println(
							extractor != null ? extractor.extractAll() : "The document format is not supported");
				}
			}
			// ExEnd:extractMessagesFromOST
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Enumerates all the entities of the group of containers.
	 * 
	 */
	public static void enumerateAllEntitiesOfGroupOfContainers() {
		try {
			// ExStart:enumerateAllEntitiesOfGroupOfContainers
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Create a container
			try (PersonalStorageContainer container = new PersonalStorageContainer(
					Common.mapSourceFilePath(OST_FILE_PATH))) {
				IContainerFactory containerFactory = null;
				MediaTypeDetector containerMediaTypeDetector = null;
				// Create a container enumerator
				ContainerEnumerator enumerator = new ContainerEnumerator(containerFactory, containerMediaTypeDetector,
						container);
				// Get the entity
				Container.Entity entity = enumerator.nextElement();
				// Iterate over files
				while (entity != null) {
					// Try to create a text extractor
					TextExtractor extractor = factory.createTextExtractor(entity.openStream());
					// If the text extractor is supported (extractor != null),
					// then
					// extract a text from the document
					System.out.println(extractor == null ? "document isn't supported" : extractor.extractAll());
					// Get the entity for the next iteration
					entity = enumerator.nextElement();
				}
			}
			// ExEnd:enumerateAllEntitiesOfGroupOfContainers
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Shows the usage of EmailConnectionInfo class for Exchange, POP, and IMAP
	 * email servers
	 * 
	 */
	public static void createEmailConnectionInfo() {
		try {
			// ExStart:createEmailConnectionInfo
			// Exchange Web Service:
			EmailConnectionInfo ewsInfo = EmailConnectionInfo.createEwsConnectionInfo(
					"https://outlook.office365.com/ews/exchange.asmx", "username", "password", "domain");
			// or if domain is not required:
			EmailConnectionInfo ewsInfoNoDomain = EmailConnectionInfo
					.createEwsConnectionInfo("https://outlook.office365.com/ews/exchange.asmx", "username", "password");
			// POP:
			EmailConnectionInfo popInfo = EmailConnectionInfo.createPopConnectionInfo("pop-mail.outlook.com", 995,
					"username", "password");
			// IMAP:
			EmailConnectionInfo imapInfo = EmailConnectionInfo.createImapConnectionInfo("imap-mail.outlook.com", 993,
					"username", "password");

			// ExEnd:createEmailConnectionInfo
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Retrieves list of all email from Exchange Web Service
	 * 
	 */
	public static void getListOfEmailsFromEWS() {
		try {
			// ExStart:getListOfEmailsFromEWS
			// Exchange Web Service:
			EmailConnectionInfo ewsInfo = EmailConnectionInfo.createEwsConnectionInfo(
					"https://outlook.office365.com/ews/exchange.asmx", "username", "password", "domain");
			// Create an email container
			try (EmailContainer container = new EmailContainer(ewsInfo)) {
				// Iterate over emails
				for (Container.Entity entity : container.getEntities()) {
					System.out.println("Folder: " + entity.getPath().toString()); // A
																					// folder
																					// at
																					// server
					System.out.println("Subject: " + entity.get_Item(MetadataNames.SUBJECT)); // A
																								// subject
																								// of
																								// email
					System.out.println("From: " + entity.get_Item(MetadataNames.EMAIL_FROM)); // "From"
																								// address
					System.out.println("To: " + entity.get_Item(MetadataNames.EMAIL_TO)); // "To"
																							// addresses
				}
			}
			// ExEnd:getListOfEmailsFromEWS
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Retrieves an email from Exchange Web Service
	 * 
	 */
	public static void retrieveAnEmailFromEWS() {
		try {
			// ExStart:retrieveAnEmailFromEWS
			// Exchange Web Service:
			EmailConnectionInfo ewsInfo = EmailConnectionInfo.createEwsConnectionInfo(
					"https://outlook.office365.com/ews/exchange.asmx", "username", "password", "domain");
			// Create an email container
			try (EmailContainer container = new EmailContainer(ewsInfo)) {
				// Iterate over emails
				for (Container.Entity entity : container.getEntities()) {
					// Create a stream with the content of email
					java.io.InputStream stream = entity.openStream();
					// Create a text extractor for email
					try (TextExtractor extractor = new EmailTextExtractor(stream)) {
						// Extract all the text from email
						System.out.println(extractor.extractAll());
					}
				}
			}
			// ExEnd:retrieveAnEmailFromEWS
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Enumerates all entities in a ZIP archive
	 * 
	 */
	public static void enumerateFileInZIPArchive() {
		try {
			// ExStart:enumerateFileInZIPArchive
			try (ZipContainer container = new ZipContainer(Common.mapSourceFilePath(ZIP_FILE_PATH))) {

				for (int i = 0; i < container.getEntities().size(); i++) {
					System.out.println("Name: " + container.getEntities().get(i).getName());
					System.out.println("Path: " + container.getEntities().get(i).getPath().toString());
					System.out.println("Media type: " + container.getEntities().get(i).getMediaType());
				}
			}
			// ExEnd:enumerateFileInZIPArchive
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Reads file in a ZIP archive
	 * 
	 */
	public static void readConcreteFileInZIPArchive() {
		try {
			// ExStart:readConcreteFileInZIPArchive
			try (ZipContainer container = new ZipContainer(Common.mapSourceFilePath(ZIP_FILE_PATH))) {

				// Create a factory
				ExtractorFactory extractorFactory = new ExtractorFactory();

				try (TextExtractor extractor = extractorFactory
						.createTextExtractor(container.getEntities().get(0).openStream())) {
					System.out.println(extractor.extractAll());
				}
			}
			// ExEnd:readConcreteFileInZIPArchive
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Reads file in a ZIP archive
	 * 
	 */
	public static void retrieveAllEntitiesInZIPArchiveByName() {
		try {
			// ExStart:retrieveAllEntitiesInZIPArchiveByName
			try (ZipContainer container = new ZipContainer(Common.mapSourceFilePath(ZIP_FILE_PATH))) {

				// Create a factory
				ExtractorFactory extractorFactory = new ExtractorFactory();

				// Try to get "container.xml" entity from "META-INF" folder
				Container.Entity containerEntry = container.getEntity("META-INF\\container.xml");
				// If the entity isn't found
				if (containerEntry == null) {
					throw new GroupDocsParserException("File not found");
				}

				// Try to create a text extractor
				TextExtractor extractor = extractorFactory.createTextExtractor(containerEntry.openStream());
				try {
					// Extract a text (if the document type is supported)
					System.out.println(extractor == null ? "Document type isn't supported" : extractor.extractAll());
				} finally {
					// Cleanup
					if (extractor != null) {
						extractor.dispose();
					}
				}
			}
			// ExEnd:retrieveAllEntitiesInZIPArchiveByName
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Reads text from database
	 * 
	 */
	public static void extractTextFromDatabase() {
		try {
			// ExStart:extractTextFromDatabase_18.9
			String connectionString = Common.getConnectionString(DB_FILE_PATH);
			DbContainer container = new DbContainer(java.sql.DriverManager.getConnection(connectionString));
			try  {
				// Iterate over entities
				for (Container.Entity entity : container.getEntities()) {
					// Print a table name
					System.out.println(entity.getName());
					// Print a media type
					System.out.println(entity.getMediaType());
					// Create a stream reader for CSV document: OpenStream
					// method converts a table to the CSV file and returns it as
					// Stream
					java.io.InputStreamReader reader = new java.io.InputStreamReader(entity.openStream());
					try {
						BufferedReader br = new BufferedReader(reader);

						// Read a line
						String line = br.readLine();
						// Loop to the end of the file
						while (line != null) {
							// Print a line from the document
							System.out.println(line);
							// Read the next line
							line = br.readLine();
						}
					} finally {
						reader.close();
					}

				}
			} finally {
				container.dispose();
			}
			// ExEnd:extractTextFromDatabase_18.9
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
