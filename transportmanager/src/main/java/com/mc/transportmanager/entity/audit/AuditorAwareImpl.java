package com.mc.transportmanager.entity.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("SYSTEM");
        }
 
        if (authentication.getPrincipal().getClass() == String.class) {
            return Optional.of("SYSTEM");
        }

        return Optional.of(((UserDetails) authentication.getPrincipal()).getUsername());
    }
}