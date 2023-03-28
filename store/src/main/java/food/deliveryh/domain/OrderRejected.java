package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;

    public OrderRejected(Cook aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}
