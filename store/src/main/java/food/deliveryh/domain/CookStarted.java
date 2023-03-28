package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;

    public CookStarted(Cook aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
