package com.ronitCodes.crudDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    // Define the Field
    // Annotate the private field
    // Create a Constructor
    // Getter and Setter Method
    // toString Method to Print the Object

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review() {

    }

    public Review(String comment){
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
