package BT2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String sourceFileName = "src/BT2/source.txt";
            String targetFileName = "src/BT2/target.txt";

            File sourceFile = new File(sourceFileName);
            if (!sourceFile.exists()) {
                System.out.println("Tệp nguồn không tồn tại.");
                return;
            }

            File targetFile = new File(targetFileName);
            if (targetFile.exists()) {
                System.out.println("Tệp đích đã tồn tại. Vui lòng chọn một tên tệp đích khác.");
                return;
            }

            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(targetFile);

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                outputStream.write(bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Sao chép hoàn tất. Số byte sao chép: " + sourceFile.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
