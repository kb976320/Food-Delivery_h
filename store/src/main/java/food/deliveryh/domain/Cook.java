package food.deliveryh.domain;

import food.deliveryh.StoreApplication;
import food.deliveryh.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String foodId;

    private String option;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void confirmOrReject(ConfirmOrRejectCommand confirmOrRejectCommand) {
        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();
    }

    public void start() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void end() {
        CookEnede cookEnede = new CookEnede(this);
        cookEnede.publishAfterCommit();
    }

    public static void loadOrderInfo(OrderReplaced orderReplaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderReplaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
