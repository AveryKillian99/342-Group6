package Group6.TaxiService;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Consumer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int consumerId;

    @Column(nullable = false)
    private String consumerName;

    @Column(nullable = false)
    private String consumerEmail;

    @Column(nullable = false)
    private String consumerPassword;


    public Consumer(int consumerId, String consumerName, String consumerType){
        this.consumerId = consumerId;
        this.consumerName = consumerName;
        this.consumerEmail = consumerEmail;
        this.consumerPassword = consumerPassword;

    }

    public Consumer(String consumerName, String consumerType){
        this.consumerName = consumerName;
    }

    public Consumer(){

    }

    // Constructors, Getters, and Setters (add for reviews as well)


    public int getConsumerId(){return consumerId;}

    public void setConsumerId(int consumerId){this.consumerId=consumerId;}

    public String getConsumerName(){return consumerName;}

    public void setConsumerName(String consumerName){this.consumerName = consumerName;}

    public String getConsumerEmail(){return consumerEmail;}

    public void setConsumerEmail(String consumerEmail){this.consumerEmail=consumerEmail;}

    public String getConsumerPassword(){return consumerPassword;}

    public void setConsumerPassword(String consumerPassword){this.consumerPassword=consumerPassword;}


}