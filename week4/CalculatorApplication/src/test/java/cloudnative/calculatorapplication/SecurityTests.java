package cloudnative.calculatorapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SecurityTests {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void testGenerateAndValidateToken() {
        String username = "user";
        String token = jwtUtil.generateToken(username);

        assertNotNull(token);
        assertTrue(jwtUtil.validateToken(token, username));
    }

    @Test
    public void testExtractUsername() {
        String username = "testuser";
        String token = jwtUtil.generateToken(username);

        assertEquals(username, jwtUtil.extractUsername(token));
    }

//    @Test
//    public void testTokenExpiration() throws InterruptedException {
//        String username = "testuser";
//        String token = jwtUtil.generateToken(username);
//
//        assertTrue(jwtUtil.validateToken(token, username));
//
//        // Set a short expiration time for testing
//        ReflectionTestUtils.setField(jwtUtil, "expiration", 1L); // 1 second expiration
//
//        // Generate a new token with the short expiration
//        token = jwtUtil.generateToken(username);
//
//        Thread.sleep(1100); // Wait for 1.1 seconds
//
//        assertFalse(jwtUtil.validateToken(token, username));
//    }
}