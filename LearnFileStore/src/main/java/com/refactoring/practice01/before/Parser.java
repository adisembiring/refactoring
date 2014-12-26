package com.refactoring.practice01.before;

/**
 * Created by Adi on 12/26/2014.
 */
/**
 * Please review the class below and suggest improvements. How would
 * you refactor this class if it would be in a real-life project?
 * There are many problems here, both high-level design mistakes,
 * and low-level implementation bugs. We're interested to see high-level
 * problems first, since they are most critical. The more mistakes
 * you can spot, the better programmer you are.
 */

import java.io.*;

/**
 * This class is thread safe.
 */
public class Parser {
    private final File file;

    public Parser(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File should not null");
        }
        this.file = file;
    }

    public synchronized String getContent() throws IOException {
        InputStream i = null;
        try {
            i = openInputStream();
            return new FileReader(i).read();
        } finally {
            closeQuietly(i);
        }
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        InputStream i = null;
        try {
            i = openInputStream();
            return new FileReader(i).readWithoutUnicode();
        } finally {
            closeQuietly(i);
        }
    }

    public synchronized void saveContent(String content) throws IOException {
        OutputStream o = null;
        try {
            o = openOutputStream();
            new FileWriter(o).write(content);
        } finally {
            closeQuietly(o);
        }
    }

    private FileInputStream openInputStream() throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canRead() == false) {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        return new FileInputStream(file);
    }

    public FileOutputStream openOutputStream() throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canWrite() == false) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        return new FileOutputStream(file);
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
        }
    }
}
