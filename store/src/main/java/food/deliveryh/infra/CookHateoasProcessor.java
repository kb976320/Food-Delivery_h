package food.deliveryh.infra;

import food.deliveryh.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Cook>> {

    @Override
    public EntityModel<Cook> process(EntityModel<Cook> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/confirmor-or-reject"
                )
                .withRel("confirmor-or-reject")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/start")
                .withRel("start")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/end")
                .withRel("end")
        );

        return model;
    }
}
