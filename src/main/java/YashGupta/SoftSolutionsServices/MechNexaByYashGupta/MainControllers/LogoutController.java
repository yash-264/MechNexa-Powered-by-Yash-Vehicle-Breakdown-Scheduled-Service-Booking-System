package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.MainControllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("logout/mech/nexa")
public class LogoutController {

    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    @PostMapping()
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return new ResponseEntity<>("User is not authenticated", HttpStatus.UNAUTHORIZED);
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new ResponseEntity<>("Invalid Authorization header", HttpStatus.BAD_REQUEST);
        }

        String token = authHeader.substring(7);
        blacklistedTokens.add(token);

        String uniqueId = authentication.getName();

        return ResponseEntity.ok( uniqueId + " has been logged out.");
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}



