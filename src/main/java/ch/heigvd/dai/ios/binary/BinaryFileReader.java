package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    InputStream fileInputStream = null;

    try {
      fileInputStream = new FileInputStream(filename);

      int readByte;
      while ((readByte = fileInputStream.read()) != -1) {
        System.out.println(readByte);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileInputStream != null) {
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
