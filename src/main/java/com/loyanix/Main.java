package com.loyanix;

import com.loyanix.convert.Converter;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    private static ResourceBundle resourceBundle;

    public static void main(String[] args) {
        Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("bundle", Converter.UTF_8);
        Fact fact = new Fact();
        try {
            String stage = fact.getFact();
            System.out.println(resourceBundle.getString(stage));
            logger.info(resourceBundle.getString(stage));
        } catch (ParseException e) {
            logger.error("Parse error", e);
            e.printStackTrace();
        }
    }
}
