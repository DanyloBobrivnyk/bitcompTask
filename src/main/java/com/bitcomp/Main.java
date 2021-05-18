package com.bitcomp;

import com.bitcomp.entity.ParseResult;
import com.bitcomp.parser.dom.DOMParser;

import java.io.File;
import java.io.InputStream;


public class Main {

    public static void main(String[] args) {
            if(args.length > 1)
            {
                try
                {
                    Main app = new Main();
                    String fileName = args[0];

                    InputStream is = app.getFileFromResourceAsStream(fileName);

                    ParseResult parseResult = DOMParser.parse(is, args[1]);
                    System.out.println(parseResult);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
    }

    public InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
