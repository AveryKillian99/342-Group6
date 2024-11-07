package com.Group6.BackendApiProgress.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int producerId;

    @Column(nullable = false)
    private String producerName;


    public Producer(int producerId, String producerName, String producerType){
        this.producerId = producerId;
        this.producerName = producerName;
    }

    public Producer(String producerName, String producerType){
        this.producerName = producerName;
    }

    public Producer(){

    }

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProducerReview> producerReviews;

    // Constructors, Getters, and Setters (add for reviews as well)
    public List<ProducerReview> getReviews() { return producerReviews; }
    public void setReviews(List<ProducerReview> producerReviews) { this.producerReviews = producerReviews; }


    public int getProducerId(){return producerId;}

    public void setProducerId(int producerId){this.producerId=producerId;}

    public String getProducerName(){return producerName;}

    public void setProducerName(String producerName){this.producerName = producerName;}


}
