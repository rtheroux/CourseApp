package com.example.ross.masterdetail;

/**
 * Created by BrendanMcLaughlin on 10/27/16.
 */

public class Course {
    private String course;
    private String section;
    private String title1;
    private String dept;
    private String credits;
    private String faculty;
    private String location;
    private String beginDate;
    private String endDate;
    private String building;
    private String room;
    private String start_time;
    private String end_time;
    private String mtg_beg_date;
    private String mtg_end_date;
    private String days;

    public Course(String course, String section, String title1, String dept, String credits, String faculty,
                  String location, String beginDate, String endDate, String building, String room, String start_time,
                  String end_time, String mtg_beg_date, String mtg_end_date, String days) {
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMtg_beg_date() {
        return mtg_beg_date;
    }

    public void setMtg_beg_date(String mtg_beg_date) {
        this.mtg_beg_date = mtg_beg_date;
    }

    public String getMtg_end_date() {
        return mtg_end_date;
    }

    public void setMtg_end_date(String mtg_end_date) {
        this.mtg_end_date = mtg_end_date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
