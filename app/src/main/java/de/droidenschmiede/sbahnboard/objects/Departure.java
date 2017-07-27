package de.droidenschmiede.sbahnboard.objects;

import java.util.ArrayList;

/**
 * Created by vabene1111 on 27.07.2017.
 * Departure Object
 */

public class Departure {
    JourneyDetailRef JourneyDetailRef;
    Product Product;
    Notes Notes;

    public String name;
    String type;
    String stop;
    String stopid;
    String stopExtId;
    String prognosisType;
    public String time;
    String date;
    String track;
    String rtTime;
    String rtDate;
    String rtTrack;
    public String direction;
    String trainNumber;
    String trainCategory;

    public class Product{
        String name;
        String num;
        String line;
        String catOut;
        String catIn;
        String catCode;
        String catOutS;
        String catOutL;
        String operatorCode;
        String operator;
        String admin;
    }

    public class JourneyDetailRef{
        String ref;
    }

    public class Notes{
        ArrayList<Note> Notes;
    }

    public class Note{
        String value;
        String key;
        String type;
        int priority;
        int routeIdxFrom;
        int routeIdxTo;

    }
}
