package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.MainControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check")
public class HealthCheck {


    @GetMapping
    public ResponseEntity<?> check(){

        return new ResponseEntity<>("GoMehanic Backend Is Working", HttpStatus.OK);
    }
}
