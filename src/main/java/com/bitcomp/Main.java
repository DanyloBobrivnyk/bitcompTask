package com.bitcomp;

import com.bitcomp.dom.DOMParser;


public class Main {

    public static void main(String[] args) {
            if(args.length > 1)
            {
                try
                {
                    DOMParser.parse("src/main/resources/" + args[0], args[1]);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
    }
}
