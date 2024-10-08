package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation writes the file using a buffered writer
 * around a file writer. It manages the writer and the buffered writer properly with a
 * try-with-resources block.
 */
public class BufferedTextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    try (OutputStream fileStream = new FileOutputStream(filename);
        Writer writer = new OutputStreamWriter(fileStream, StandardCharsets.US_ASCII);
        BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
      for (int i = 0; i < sizeInBytes; ++i) {
        bufferedWriter.write(i);
      }
      bufferedWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
