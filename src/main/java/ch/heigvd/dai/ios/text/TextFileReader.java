package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
    Reader fileReader = null;

    try {
      fileReader = new FileReader(filename, StandardCharsets.US_ASCII);

      int readByte;
      while ((readByte = fileReader.read()) != -1) {
        System.out.println(readByte);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
