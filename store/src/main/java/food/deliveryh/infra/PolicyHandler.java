package food.deliveryh.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.deliveryh.config.kafka.KafkaProcessor;
import food.deliveryh.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookRepository cookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReplaced'"
    )
    public void wheneverOrderReplaced_LoadOrderInfo(
        @Payload OrderReplaced orderReplaced
    ) {
        OrderReplaced event = orderReplaced;
        System.out.println(
            "\n\n##### listener LoadOrderInfo : " + orderReplaced + "\n\n"
        );

        // Sample Logic //
        Cook.loadOrderInfo(event);
    }
}
