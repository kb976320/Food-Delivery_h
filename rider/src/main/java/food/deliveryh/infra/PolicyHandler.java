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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_LoadDeliveryInfo(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReplaced'"
    )
    public void wheneverOrderReplaced_LoadDeliveryInfo(
        @Payload OrderReplaced orderReplaced
    ) {
        OrderReplaced event = orderReplaced;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + orderReplaced + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryInfo(event);
    }
}
