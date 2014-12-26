package com.refactoring.practice01.before;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Adi on 12/26/2014.
 */
public class FileReader {

    private final InputStream inputStream;

    public FileReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String read() throws IOException {
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = inputStream.read()) > 0) {
            output.append((char) data);
        }
        return output.toString();
    }

    public String readWithoutUnicode() throws IOException {
        String output = "";
        int data;
        while ((data = inputStream.read()) > 0) {
            if (data < 0x80) {
                output += (char) data;
            }
        }
        return output;
    }
}
