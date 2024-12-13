package Group6.TaxiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService service;


    @GetMapping("/{consumerId}")
    public Consumer getConsumerById(@PathVariable int consumerId){
        return service.getConsumerById(consumerId);
    }
    @PostMapping("/new")
    public Consumer addNewConsumer(@RequestBody Consumer consumer) {
        return service.addNewConsumer(consumer);
    }

    @PutMapping("/update/{consumerId}")
    public Consumer updateconsumer(@PathVariable int consumerId, @RequestBody Consumer consumer){
        Consumer updatedConsumer = service.updateConsumer(consumerId, consumer);
        return updatedConsumer;  // return updated consumer directly
    }


    @DeleteMapping("/delete/{consumerId}")
    public List<Consumer> deleteConsumerById(@PathVariable int consumerId){
        service.deleteConsumerById(consumerId);
        return service.getAllConsumers();
    }

}
