package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenBlackListService {


    public class TokenBlacklistService {

        @Autowired
        private StringRedisTemplate redisTemplate;

        public void blacklistToken(String token, long expirationMillis) {
            redisTemplate.opsForValue().set(token, "blacklisted", expirationMillis, TimeUnit.MILLISECONDS);
        }

        public boolean isTokenBlacklisted(String token) {
            return Boolean.TRUE.equals(redisTemplate.hasKey(token));
        }

    }

}
