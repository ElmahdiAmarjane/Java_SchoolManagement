package cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

public class CloudinaryUploader {
    private static final String CLOUD_NAME = "dqnl2u4e8";  // Replace with your Cloudinary cloud name
    private static final String API_KEY = "273678865369586";  // Replace with your Cloudinary API key
    private static final String API_SECRET = "OG7o1AxeOpq7t1uy7OuNescvBpc";  // Replace with your Cloudinary API secret

    private Cloudinary cloudinary;

    // Constructor to initialize Cloudinary instance with your credentials
    public CloudinaryUploader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", CLOUD_NAME,
            "api_key", API_KEY,
            "api_secret", API_SECRET
        ));
    }

    // Method to upload a file (any type: image, pdf, word, excel)
    public String uploadFile(String filePath) {
        try {
            File file = new File(filePath);
            // Uploading file and using 'resource_type' as 'auto' to detect file type
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "resource_type", "auto"  // Automatically detects file type (image, pdf, docx, etc.)
            ));
            return (String) uploadResult.get("url");  // Get the URL of the uploaded file
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Method to download the file from Cloudinary URL
    public void downloadAnnonceFile(String fileUrl, String downloadPath) {
        try {
            // Create a URL object from the Cloudinary file URL
            URL url = new URL(fileUrl);
            // Open the input stream to read the file from the URL
            InputStream in = url.openStream();
            // Create an output stream to write the file locally
            OutputStream out = new FileOutputStream(downloadPath);

            // Use a buffer to efficiently transfer data
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Close streams after download
            in.close();
            out.close();

            System.out.println("File downloaded to: " + downloadPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to download the file.");
        }
    }

    

    // Main method to test file upload
//    public static void main(String[] args) {
//        CloudinaryUploader uploader = new CloudinaryUploader();
//
//        // Example for uploading an Excel file
//        String fileUrl = uploader.uploadFile("C:/Users/lenovo/Desktop/ENSIASD_S1/Classeur1.xlsx");
//
//        if (fileUrl != null) {
//            System.out.println("File uploaded to: " + fileUrl);
//        } else {
//            System.out.println("File upload failed!");
//        }
//    }
}
