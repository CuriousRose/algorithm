package think;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args) throws Exception {
        String basePath = "C:\\Users\\weshare\\Desktop\\black\\";
        String[] files = {"brdt.log", "gf.log", "gzt.log", "tddt.log"};

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\weshare\\Desktop\\black\\test.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);

        zipOutputStream.setComment("A test of Java Zipping");

        for (String file : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(basePath + file));
            zipOutputStream.putNextEntry(new ZipEntry(file));
            int c;
            while ((c = bufferedReader.read()) != -1) {
                bufferedOutputStream.write(c);
            }
            bufferedReader.close();
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\weshare\\Desktop\\black\\test.zip");
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            fileOutputStream = new FileOutputStream("C:\\Users\\weshare\\Desktop\\" + zipEntry.getName());
            int x;
            while ((x = bufferedInputStream.read()) != -1) {
                fileOutputStream.write(x);
            }
            fileOutputStream.close();
        }
        bufferedInputStream.close();

        ZipFile zipFile = new ZipFile("C:\\Users\\weshare\\Desktop\\black\\test.zip");
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            zipEntry = (ZipEntry) enumeration.nextElement();
            System.out.println(zipEntry);
        }
    }
}
