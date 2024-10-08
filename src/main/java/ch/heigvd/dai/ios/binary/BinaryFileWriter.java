package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A class that writes binary files. This implementation writes the file byte per byte. It manages
 * the file output stream properly with a try-catch-finally block.
 */
public class BinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    OutputStream fileOutputStream = null;

    try {
      fileOutputStream = new FileOutputStream(filename);

      /*
      Personal note after trying to understand what this write() does:
      We are writing a byte (8 bits) every time, although we are working with int, which are 4 bytes long.
      I think when writing each byte, we are only saving the low weight bits and ignoring the 3 bytes of heavier
      weight.
       */
      for (int i = 0; i < sizeInBytes; ++i) {
        fileOutputStream.write(i);
      }
      // You can uncomment the following line to understand the comment above.
      // fos.write(0b1100000100010001);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileOutputStream != null) {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
