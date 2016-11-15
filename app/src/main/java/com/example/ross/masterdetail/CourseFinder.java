package com.example.ross.masterdetail;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by BrendanMcLaughlin on 10/27/16.
 */

public class CourseFinder {

    public static ArrayList<ArrayList> allCourses = new ArrayList<>();
    public static ArrayList<MyCourse> springCourses = new ArrayList<>();
    public static ArrayList<MyCourse> fallCourses = new ArrayList<>();

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MyCourse> ITEMS = new ArrayList<MyCourse>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MyCourse> ITEM_MAP = new HashMap<String, MyCourse>();

    private static final int COUNT = 25;

//    static {
//        // Add some sample items.
//        addItem(createDummyItem("CSC105", "Intro to CS", "An introduction to computer science"));
//        addItem(createDummyItem("CSC206", "Operating systems", "Discusses low level programming"));
//        addItem(createDummyItem("ENG105", "Intro to Literary Studies", "An introduction to poetry and fiction"));
//    }

    private static void addItem(MyCourse item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MyCourse createDummyItem(String id, String content, String course, String section,
                                            String title1, String dept, String credits, String faculty,
                                            String location, String beginDate, String endDate, String building,
                                            String room, String start_time, String end_time, String mtg_beg_date,
                                            String mtg_end_date, String days) {
        return new MyCourse(id,content,course,section,title1,dept,credits,faculty,location,beginDate,
                endDate,building,room,start_time,end_time,mtg_beg_date,mtg_end_date,days);
    }

//    private static String makeDetails(String details) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(details);
//        for (int i = 0; i < details; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MyCourse {
        public final String id;
        public final String content;
        public final String course;
        public final String section;
        public final String title1;
        public final String dept;
        public final String credits;
        public final String faculty;
        public final String location;
        public final String beginDate;
        public final String endDate;
        public final String building;
        public final String room;
        public final String start_time;
        public final String end_time;
        public final String mtg_beg_date;
        public final String mtg_end_date;
        public final String days;

        public MyCourse(String id, String content, String course, String section, String title1, String dept, String credits, String faculty,
                        String location, String beginDate, String endDate, String building, String room, String start_time,
                        String end_time, String mtg_beg_date, String mtg_end_date, String days) {
            this.id = id;
            this.content = content;
            this.course = course;
            this.section = section;
            this.title1 = title1;
            this.dept = dept;
            this.credits = credits;
            this.faculty = faculty;
            this.location = location;
            this.beginDate = beginDate;
            this.endDate = endDate;
            this.building = building;
            this.room = room;
            this.start_time = start_time;
            this.end_time = end_time;
            this.mtg_beg_date = mtg_beg_date;
            this.mtg_end_date = mtg_end_date;
            this.days = days;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static void fill(ArrayList<MyCourse> courses){
        //Fill up ITEMS
        System.out.println(courses.get(0).title1);
        for (int i = 0; i < courses.size() ; i++) {
            System.out.println("IN LOOP");
            System.out.println(courses.get(i).title1);
            addItem(createDummyItem(courses.get(i).id, courses.get(i).content, courses.get(i).course, courses.get(i).section,
                    courses.get(i).title1, courses.get(i).dept, courses.get(i).credits, courses.get(i).faculty, courses.get(i).location,
                    courses.get(i).beginDate, courses.get(i).endDate, courses.get(i).building, courses.get(i).room, courses.get(i).start_time,
                    courses.get(i).end_time, courses.get(i).mtg_beg_date, courses.get(i).mtg_end_date, courses.get(i).days));
        }
        System.out.println("OUT OF LOOP");

    }

    public void loadCourses() {
        String generate_URL = "https://cars.endicott.edu/schedule/schedule.html";
        String inputLine = null;
        StringBuffer jsonBuffer = new StringBuffer();
        try {
            URL data = new URL(generate_URL);

            /* Open connection */
            /* comment below line in case of Proxy */
            HttpURLConnection con = (HttpURLConnection) data.openConnection();
            /* Read webpage coontent */
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            /* Read line by line */
            while ((inputLine = in.readLine()) != null) {
                jsonBuffer.append(inputLine);
                //System.out.println(inputLine);
            }
            /* close BufferedReader */
            in.close();
            /* close HttpURLConnection */
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println(jsonBuffer);
        String finalJson = jsonBuffer.toString();


        try {
            JSONObject sessionsObj = new JSONObject(finalJson);
            JSONArray sessionsAry = sessionsObj.getJSONArray("sessions");
            JSONObject springSession = new JSONObject(sessionsAry.getJSONObject(0).toString());
            JSONObject fallSession = new JSONObject(sessionsAry.getJSONObject(1).toString());
            JSONArray springAry = springSession.getJSONArray("classes");
            JSONArray fallAry = fallSession.getJSONArray("classes");

//            System.out.println(springAry.getJSONObject(0));
//            System.out.println(fallAry.getString(10));
            // added a comment

            Gson gson = new Gson();

            for (int i = 0; i < springAry.length() ; i++) {

                JsonElement element = new JsonParser().parse(springAry.getString(i));
                MyCourse course = gson.fromJson(element, MyCourse.class);
                springCourses.add(course);
            }
//            System.out.println("\n\n");
//            System.out.println("SPRING COURSES:");
//            System.out.println("==================================================");
//            for (Course course: springCourses) {
//                System.out.println(course.getTitle1());
//
//            }
            for (int i = 0; i < fallAry.length() ; i++) {

                JsonElement element = new JsonParser().parse(fallAry.getString(i));
                MyCourse course = gson.fromJson(element, MyCourse.class);
                fallCourses.add(course);
            }
//            System.out.println("\n\n");
//            System.out.println("FALL COURSES:");
//            System.out.println("==================================================");
//            for (Course course: fallCourses) {
//                System.out.println(course.getTitle1());
//
//            }

            allCourses.add(springCourses);
            allCourses.add(fallCourses);

            //System.out.println(springCourses.get(0).title1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.fill(springCourses);
    }
}
