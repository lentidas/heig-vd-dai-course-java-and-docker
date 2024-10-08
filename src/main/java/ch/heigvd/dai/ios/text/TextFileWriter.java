package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer fileWriter = null;

    /*
    Personal note after trying to understand what this write() does:
    What we are writing depends on the charset chosen!
    UTF-8 is capable of encoding all 1,112,064[2] valid Unicode code points using a variable-width
    encoding of one to four one-byte (8-bit) code units (ref: https://en.wikipedia.org/wiki/UTF-8).
    This means that when writing ints, these would be encoded as characters in UTF-8 and they would
    occupy a variable size. Consequently, when asking for 1024 bytes we would end with a file with
    around 1.8 KB.
    To solve this we need to either cast the int to a byte before writing while only doing half ot
    the iterations or simply use the US_ASCII encoding.
     */
    try {
      fileWriter = new FileWriter(filename, StandardCharsets.US_ASCII);

      /*
      Personal note after trying to understand what this write() does:
      What we are writing depends on the charset chosen!
      UTF-8 is capable of encoding all 1,112,064[2] valid Unicode code points using a variable-width
      encoding of one to four one-byte (8-bit) code units
      (ref: https://en.wikipedia.org/wiki/UTF-8).
      This means that when writing ints, these would be encoded as characters in UTF-8 and they
      would occupy a variable size. Consequently, when asking for 1024 bytes we would end with a
      file with around 1.8 KB.
      To solve this we need to either cast the int to a byte before writing while only doing half of
      the iterations or simply use the US_ASCII encoding.
       */
      for (int i = 0; i < sizeInBytes; ++i) {
        fileWriter.write(i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileWriter != null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
