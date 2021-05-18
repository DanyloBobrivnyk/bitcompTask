package com.bitcomp;

import com.bitcomp.entity.ParseResult;
import com.bitcomp.parser.dom.DOMParser;

import java.io.File;


public class Main {

    public static void main(String[] args) {
            if(args.length > 1)
            {
                try
                {
                    ClassLoader classLoader = Main.class.getClassLoader();
                    File file = new File(classLoader.getResource(args[0]).getFile());

                    ParseResult parseResult = DOMParser.parse(file.getPath(), args[1]);
                    System.out.println(parseResult);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
    }
}
