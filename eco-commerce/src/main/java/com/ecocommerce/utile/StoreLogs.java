package com.ecocommerce.utile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

@Component
public class StoreLogs {
	private static Logger logger = LoggerFactory.getLogger(StoreLogs.class);
	
	private static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=ziuefzeuifhzuiefhz;"
			+ "AccountKey=uefhzeufhsdjsdsldjds;"
			+ "EndpointSuffix=core.windows.net";

	public StoreLogs() {
		
	}
	
	// Lancer tous les 70 sec
    @Scheduled(cron = "*/70 * * * * *" )
	public void storeParMin() {
		// Blob
		File sourceFile = null, downloadedFile = null;
		
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
		
		
		File file=new File("./");
		File fileSv = null;
		File files[]=  file.listFiles();
		for(File f:files){
		    if(f.getName().contains("logFile."+dateFormat.format(date))){
		        if(fileSv == null || Integer.parseInt(f.getName().split("-")[4].split("\\.")[0]) >
		        Integer.parseInt(fileSv.getName().split("-")[4].split("\\.")[0])) {
		        	sourceFile = f;
		        	logger.info("Recuperer les log: " + sourceFile.toString());
		        }
		    }
		}

		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container=null;

		
		try {   
			FileUtils.writeByteArrayToFile(sourceFile, CrypteFile.encrypt(sourceFile, "pass"));
			
			// Parse the connection string and create a blob client to interact with Blob storage
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference("logappcontainer");

			// Create the container if it does not exist with public access.
			logger.info("Creating container: " + container.getName());
			container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    

			//Creating a sample file
			//sourceFile = new File("logFile."+dateFormat.format(date)+".0.log");
			

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
		downloadedFile = new File("data/", sourceFile.getName());
		blob.downloadToFile(downloadedFile.getAbsolutePath());
		FileUtils.writeByteArrayToFile(downloadedFile, CrypteFile.decrypt(downloadedFile, "pass"));
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
			sourceFile.delete();
			logger.info("The program has completed successfully.");
		}
	}
	
}
