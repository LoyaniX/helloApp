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
    private String  morningString = "06:00:00";
    private String dayString = "09:00:00";
    private String eveningString = "19:00:00";
    private String nightString = "23:00:00";
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

    public  String getFact() throws ParseException {
        now = dateFormat.parse(dateFormat.format(todayDate));
        morning  = dateFormat.parse(morningString);
        day  = dateFormat.parse(dayString);
        evening = dateFormat.parse(eveningString);
        night = dateFormat.parse(nightString);
        if(now.after(morning)&&now.before(day)){
            logger.info(resourceBundle.getString("morning"));
            return resourceBundle.getString("morning");
        }else if(now.after(day)&&now.before(evening)){
            logger.info(resourceBundle.getString("day"));
            return resourceBundle.getString("day");
        }else if(now.after(evening)&&now.before(night)){
            logger.info(resourceBundle.getString("evening"));
            return resourceBundle.getString("evening");
        }else {
            logger.info(resourceBundle.getString("night"));
            return resourceBundle.getString("night");
        }
    }

}
