package com.Group6.BackendApiProgress.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int consumerId;

    @Column(nullable = false)
    private String consumerName;

    // Other fields as necessary

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Prevent the requests from being serialized in the consumer
    private List<Request> requests;

    // Constructors, Getters, and Setters

    public Consumer() {}

    public Consumer(String consumerName) {
        this.consumerName = consumerName;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}

