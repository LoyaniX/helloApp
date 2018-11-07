package com.loyanix;

import org.apache.log4j.Logger;

import java.text.ParseException;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Fact fact = new Fact();
        try {
            fact.getFact();
        } catch (ParseException e) {
            logger.error("Parse error", e);
            e.printStackTrace();
        }
    }
}
