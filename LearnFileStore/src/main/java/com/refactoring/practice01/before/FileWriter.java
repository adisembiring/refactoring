package com.refactoring.practice01.before;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Adi on 12/26/2014.
 */
public class FileWriter {
    private final OutputStream outputStream;

    public FileWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        outputStream.write(content.getBytes());
    }
}
