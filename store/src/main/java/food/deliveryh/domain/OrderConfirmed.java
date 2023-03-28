package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private Long id;

    public OrderConfirmed(Cook aggregate) {
        super(aggregate);
    }

    public OrderConfirmed() {
        super();
    }
}
