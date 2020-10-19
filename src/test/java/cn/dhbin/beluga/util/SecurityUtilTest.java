package cn.dhbin.beluga.util;

import cn.dhbin.beluga.upms.model.PermUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecurityUtilTest {

    @BeforeEach
    public void setup() {
        PermUser permUser = new PermUser();
        permUser.setAuthorities(Collections.emptyList());
        permUser.setId(1L);
        permUser.setUsername("beluga");
        Authentication authentication = new UsernamePasswordAuthenticationToken(permUser, "");
        SecurityContextHolder.setContext(new SecurityContextImpl(authentication));

    }

    @Test
    void getUserId() {
        Long userId = SecurityUtil.getUserId();
        assertEquals(1L, userId);
    }

    @Test
    void getCurrentPermUser() {
        PermUser currentPermUser = SecurityUtil.getCurrentPermUser();
        assertEquals("beluga", currentPermUser.getUsername());
        assertEquals(1L, currentPermUser.getId());
    }

}