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


/**
 * Created by BrendanMcLaughlin on 10/27/16.
 */

public class CourseFinder {

    ArrayList<Course> springCourses = new ArrayList<>();
    ArrayList<Course> fallCourses = new ArrayList<>();

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
                Course course = gson.fromJson(element, Course.class);
                springCourses.add(course);
            }
            System.out.println("\n\n");
            System.out.println("SPRING COURSES:");
            System.out.println("==================================================");
            for (Course course: springCourses) {
                System.out.println(course.getTitle1());

            }
            for (int i = 0; i < fallAry.length() ; i++) {

                JsonElement element = new JsonParser().parse(fallAry.getString(i));
                Course course = gson.fromJson(element, Course.class);
                fallCourses.add(course);
            }
            System.out.println("\n\n");
            System.out.println("FALL COURSES:");
            System.out.println("==================================================");
            for (Course course: fallCourses) {
                System.out.println(course.getTitle1());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
