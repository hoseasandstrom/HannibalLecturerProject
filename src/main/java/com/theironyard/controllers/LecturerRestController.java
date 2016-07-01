package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRespository;
import com.theironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by hoseasandstrom on 7/1/16.
 */
@RestController
public class LecturerRestController {
    @Autowired
    LecturerRespository lecturers;

    @Autowired
    ReviewRepository reviews;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }


    @RequestMapping(path = "/lecturers", method = RequestMethod.GET) //getLecturer: "/lecturers"
    public Iterable<Lecturer> getLecturers() {
        Iterable<Lecturer> lectureList = lecturers.findAll();
        return lectureList;
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST) //createReview: '/reviews'
    public String postreviews(String author, String comment, int lecturerId, boolean isGood) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        Review review = new Review(author, comment, isGood, lecturer);
        reviews.save(review);
        return "redirect:/";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)//createReview: '/reviews'
    public Iterable<Review> getReviews(int lecturerId) {
        Iterable<Review> reviewList = reviews.findByLecturerIdOrderByAuthorAsc(lecturerId);
        return reviewList;
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST) //getLecturer: "/lecturers"
    public String postlecturers(String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
        return "redirect:/";
    }
}
