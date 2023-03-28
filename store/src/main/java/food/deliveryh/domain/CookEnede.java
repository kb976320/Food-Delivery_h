package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookEnede extends AbstractEvent {

    private Long id;

    public CookEnede(Cook aggregate) {
        super(aggregate);
    }

    public CookEnede() {
        super();
    }
}
