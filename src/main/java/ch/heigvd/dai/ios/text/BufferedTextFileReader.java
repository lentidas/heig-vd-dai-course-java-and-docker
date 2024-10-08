package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file using a buffered reader around
 * a file reader. It manages the reader and the buffered reader properly with a try-with-resources
 * block.
 */
public class BufferedTextFileReader implements Readable {

  private static String END_OF_LINE = "\n";

  @Override
  public void read(String filename) {
    try (InputStream fileStream = new FileInputStream(filename);
        Reader reader = new InputStreamReader(fileStream, StandardCharsets.US_ASCII);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line + END_OF_LINE);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
