package com.example.user.projectone;

public class job {
    int id;
    String namejob;
    String timejob;
    String colorjob;

    public job(int id, String namejob, String timejob, String colorjob) {
        this.id = id;
        this.namejob = namejob;
        this.timejob = timejob;
        this.colorjob = colorjob;
    }

    public job(String namejob, String timejob, String colorjob) {
        this.namejob = namejob;
        this.timejob = timejob;
        this.colorjob = colorjob;
    }
}
