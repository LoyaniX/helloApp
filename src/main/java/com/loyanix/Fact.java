package com.loyanix;

import com.loyanix.convert.Converter;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Fact {

    private static final Logger logger = Logger.getLogger(Fact.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Date now;
    private String  morningString = "05:59:59";
    private String dayString = "08:59:59";
    private String eveningString = "18:59:59";
    private String nightString = "22:59:59";
    private Date morning;
    private Date day;
    private Date evening;
    private Date night;
    private Date todayDate;
    private ResourceBundle resourceBundle;

    public Fact() {
        todayDate = new Date();
        Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("bundle", Converter.UTF_8);
    }

    public Fact(String time) throws ParseException {
        todayDate = dateFormat.parse(time);
        Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("bundle", Converter.UTF_8);
    }

    public Date getTodayDate() {
        return todayDate;
    }

    public  String getFact() throws ParseException {
        now = dateFormat.parse(dateFormat.format(todayDate));
        morning  = dateFormat.parse(morningString);
        day  = dateFormat.parse(dayString);
        evening = dateFormat.parse(eveningString);
        night = dateFormat.parse(nightString);
        if(now.after(morning)&&now.before(day)){
            logger.info(resourceBundle.getString("morning"));
            System.out.println(resourceBundle.getString("morning"));
            return "morning";
        }else if(now.after(day)&&now.before(evening)){
            logger.info(resourceBundle.getString("day"));
            System.out.println(resourceBundle.getString("day"));
            return "day";
        }else if(now.after(evening)&&now.before(night)){
            logger.info(resourceBundle.getString("evening"));
            System.out.println(resourceBundle.getString("evening"));
            return "evening";
        }else {
            logger.info(resourceBundle.getString("night"));
            System.out.println(resourceBundle.getString("night"));
            return "night";
        }
    }

}
