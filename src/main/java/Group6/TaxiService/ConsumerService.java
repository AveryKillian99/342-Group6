package Group6.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {
    @Autowired
    private ConsumerRepository consumerRepository;

    public List<Consumer> getAllConsumers(){return consumerRepository.findAll();}

    public Consumer getConsumerById(int consumerId) {
        return consumerRepository.findById(consumerId).orElse(null);
    }

    public Consumer addNewConsumer(Consumer consumer) {
        consumerRepository.save(consumer);
        return consumer;
    }

    public Consumer updateConsumer(int consumerId, Consumer consumer){
        Consumer existing  = getConsumerById(consumerId);

        existing.setConsumerName(consumer.getConsumerName());
        consumerRepository.save(existing);
        return existing;
    }

    public void deleteConsumerById(int consumerId){
        consumerRepository.deleteById(consumerId);}


}
