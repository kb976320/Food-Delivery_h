package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookPicked extends AbstractEvent {

    private Long id;

    public CookPicked(Delivery aggregate) {
        super(aggregate);
    }

    public CookPicked() {
        super();
    }
}
