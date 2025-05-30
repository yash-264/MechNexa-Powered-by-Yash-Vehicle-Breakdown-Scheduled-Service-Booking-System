package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Services;


import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisOtpService {

    private static final long OTP_EXPIRY_MINUTES = 5;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveOtp(String email, String otp) {
        redisTemplate.opsForValue().set("otp:" + email, otp, OTP_EXPIRY_MINUTES, TimeUnit.MINUTES);
    }

    public String getOtp(String email) {
        return (String) redisTemplate.opsForValue().get("otp:" + email);
    }

    public void deleteOtp(String email) {
        redisTemplate.delete("otp:" + email);
    }

    public void saveUser(String email, User user) {
        redisTemplate.opsForValue().set("user:" + email, user, OTP_EXPIRY_MINUTES, TimeUnit.MINUTES);
    }

    public User getUser(String email) {
        return (User) redisTemplate.opsForValue().get("user:" + email);
    }

    public void deleteUser(String email) {
        redisTemplate.delete("user:" + email);
    }

}

