package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Generator;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component

public class OtpGenerator {


    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
