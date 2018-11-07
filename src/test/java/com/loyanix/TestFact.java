package com.loyanix;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class TestFact {

    @Test
    public void TestMorning() throws ParseException {
        Fact fact = new Fact("06:00:00");
        Assert.assertEquals(fact.getFact(), "Доброе утро, Мир!");
    }

    @Test
    public void TestDay() throws ParseException {
        Fact fact = new Fact("09:00:00");
        Assert.assertEquals(fact.getFact(), "Добрый день, Мир!");
    }

    @Test
    public void TestEvening() throws ParseException {
        Fact fact = new Fact("19:00:00");
        Assert.assertEquals(fact.getFact(), "Добрый вечер, Мир!");
    }

    @Test
    public void TestNight() throws ParseException {
        Fact fact = new Fact("23:00:00");
        Assert.assertEquals(fact.getFact(), "Доброй ночи, Мир!");
    }
    @Test
    public void TestTime(){
        Date date = new Date();
        Fact fact = new Fact();
        Assert.assertEquals(fact.getTodayDate(),date);
    }
}
