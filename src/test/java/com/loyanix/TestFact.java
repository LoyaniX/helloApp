package com.loyanix;

import com.loyanix.convert.Converter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestFact {

    @Test
    public void TestMorning() throws ParseException {
        Fact fact = new Fact("06:00:00");
        Assert.assertEquals(fact.getFact(), "morning");
    }

    @Test
    public void TestDay() throws ParseException {
        Fact fact = new Fact("09:00:00");
        Assert.assertEquals(fact.getFact(), "day");
    }

    @Test
    public void TestEvening() throws ParseException {
        Fact fact = new Fact("19:00:00");
        Assert.assertEquals(fact.getFact(), "evening");
    }

    @Test
    public void TestNight() throws ParseException {
        Fact fact = new Fact("23:00:00");
        Assert.assertEquals(fact.getFact(), "night");
    }
    @Test
    public void TestTime(){
        Date date = new Date();
        Fact fact = new Fact();
        Assert.assertEquals(fact.getTodayDate(),date);
    }
}
