package com.ecocommerce;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

@SpringBootApplication
public class EcoCommerceApplication {
	
	private static Logger logger = LoggerFactory.getLogger(EcoCommerceApplication.class);
	
	public static final String storageConnectionString = "a completer avec vos id";

	public static void main(String[] args) {
		SpringApplication.run(EcoCommerceApplication.class, args);
		
		
		// Blob
		File sourceFile = null, downloadedFile = null;

		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container=null;

		try {    
			// Parse the connection string and create a blob client to interact with Blob storage
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference("logappcontainer");

			// Create the container if it does not exist with public access.
			logger.info("Creating container: " + container.getName());
			container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    

			//Creating a sample file
			sourceFile = new File("app.log");
			logger.info("Recuperer les log: " + sourceFile.toString());

			//Getting a blob reference
			CloudBlockBlob blob = container.getBlockBlobReference(sourceFile.getName());

			//Creating blob and uploading file to it
			logger.info("Uploading the sample file ");
			blob.uploadFromFile(sourceFile.getAbsolutePath());

			//Listing contents of container
			for (ListBlobItem blobItem : container.listBlobs()) {
				logger.info("URI of blob is: " + blobItem.getUri());
		}

		// Download blob. In most cases, you would have to retrieve the reference
		// to cloudBlockBlob here. However, we created that reference earlier, and 
		// haven't changed the blob we're interested in, so we can reuse it. 
		// Here we are creating a new file to download to. Alternatively you can also pass in the path as a string into downloadToFile method: blob.downloadToFile("/path/to/new/file").
		downloadedFile = new File("data/", "app.log");
		blob.downloadToFile(downloadedFile.getAbsolutePath());
		} 
		catch (StorageException ex)
		{
			logger.info(String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
		}
		catch (Exception ex) 
		{
			logger.info(ex.getMessage());
		}
		finally 
		{
			logger.info("The program has completed successfully.");
		}
	}
}


