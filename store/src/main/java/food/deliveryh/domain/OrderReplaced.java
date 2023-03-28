package food.deliveryh.domain;

import food.deliveryh.domain.*;
import food.deliveryh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderReplaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String option;
}
