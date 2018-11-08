package com.loyanix;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fact {

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

    public Fact() {
        todayDate = new Date();
    }

    public Fact(String time) throws ParseException {
        todayDate = dateFormat.parse(time);
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
            return "morning";
        }else if(now.after(day)&&now.before(evening)){
            return "day";
        }else if(now.after(evening)&&now.before(night)){
            return "evening";
        }else {
            return "night";
        }
    }

}
