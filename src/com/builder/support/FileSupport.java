package com.builder.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSupport {
    public static File prepareFile(String path, boolean readable, boolean writable) {
        return prepareFile(path, readable, writable, true);
    }

    public static File prepareFile(String path, boolean readable, boolean writable, boolean reset) {
        File file = new File(path);
        if(!file.exists()) {
            try { file.createNewFile(); }
            catch (IOException e) {
                System.out.print(path +"file creation error");
            }
        }else {
            if(reset) {
                file.delete();
                try { file.createNewFile(); }
                catch (IOException e) {
                    System.out.print(path +"file creation error");
                }
            }
        }
        if(!file.canRead()) { file.setReadable(readable); }
        if(!file.canWrite()) { file.setWritable(writable); }
        return file;
    }

    public static File prepareDirectory(String path) {
        File directory = new File(path);
        if(!directory.exists()) {
            directory.mkdir();
        }
        return directory;
    }


    public static void writeLine(File file, String line) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(line);
            writer.close();
        } catch (IOException e) {
            System.out.print("cannot create writer");
            return;
        }
    }


    public static String replaceTemplatePlaceHolderInBulk(String template, String[] placeHolders, String[] newValues) {
        for(int i = 0; i < placeHolders.length && i < newValues.length; i++) {
            template = replaceTemplatePlaceHolder(template, placeHolders[i], newValues[i]);
        }
        return template;
    }

    public static String replaceTemplatePlaceHolderInBulk(String template, String[] placeHolders, String newValue) {
        for(String placeHolder : placeHolders) {
            template = replaceTemplatePlaceHolder(template, placeHolder, newValue);
        }
        return template;
    }

    public static String replaceTemplatePlaceHolder(String template, String placeHolder, String newValue) {
        return template.replaceAll(placeHolder, newValue);
    }

    public static String getTemplate(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                sb.append(scanner.nextLine() + "\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("file canot be found?");
        }
        return sb.toString();
    }
}
