package fileUpload;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("/Users/pavankumar_k11/Desktop/degree.jpg");
		System.out.println(file.canRead());
		System.out.println(file.getTotalSpace());
	}

}
