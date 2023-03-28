package food.deliveryh.infra;

import food.deliveryh.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {

    @Autowired
    CookRepository cookRepository;

    @RequestMapping(
        value = "cooks/{id}/confirmor-or-reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook confirmOrReject(
        @PathVariable(value = "id") Long id,
        @RequestBody ConfirmOrRejectCommand confirmOrRejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/confirmOrReject  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.confirmOrReject(confirmOrRejectCommand);

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "cooks/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook start(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/start  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.start();

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "cooks/{id}/end",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook end(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/end  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.end();

        cookRepository.save(cook);
        return cook;
    }
}
