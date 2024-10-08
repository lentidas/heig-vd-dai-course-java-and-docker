# Report

## Repository

https://github.com/lentidas/heig-vd-dai-course-java-ios-practical-content

## Results

Times are in milliseconds and are the average of 3 runs.

| Implementation    | 1 B               | 1 KiB    | 1 MiB             | 5 MiB             |
|-------------------|-------------------|----------|-------------------|-------------------|
| `BINARY`          | 70.7              | 67.0     | 1373.3            | 6020.3            |
| `BUFFERED_BINARY` | 68.3              | 67.7     | 77.7              | 97.3              |
| `TEXT`            | 74.7              | 70.7     | 120.7             | 242.7             |
| `BUFFERED_TEXT`   | 69.3              | 68.7     | 108.7             | 169.7             |
| **Winner**        | `BUFFERED_BINARY` | `BINARY` | `BUFFERED_BINARY` | `BUFFERED_BINARY` |

## Conclusions

The `BUFFERED_BINARY` implementation is the fastest one globally, although the difference is
negligible for the 1 B and 1 KiB files. I also note that for bigger sizes the `BINARY`
implementation becomes costly which can be justified by the required system calls on each byte that
is written, comparatively to the buffered implementations that write in chunks every time the buffer
is filled.

The difference between binary data and text data is how the data is stored in the file. Binary data
is read or written as bytes, while text data is read or written as characters. The latter depends on
the encoding, which can affect how the characters are read. For example, writing a file in UTF-8 and
reading it as UTF-16 will not show what was stored. Comparatively, reading an ASCII file as UTF-8
will show the same content, and vice versa, as long as we only use the characters available in the
ASCII encoding.

A character encoding is a way to represent a character in binary for it to be written and then read
from a file.

This benchmark is important because first it showcases the importance of using buffered streams when
writing to files. Second, it shows the difference between writing binary and text data to a file,
and how the encoding can affect the data that is read.