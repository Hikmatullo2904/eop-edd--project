package com.hikmatullo.eop.listener;

import com.hikmatullo.eop.model.CreateEvent;
import com.hikmatullo.eop.model.UpdateEvent;
import com.hikmatullo.eop.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateListener {
    private final UserRepository userRepository;
    @EventListener(UpdateEvent.class)
    public void onApplicationEvent(UpdateEvent event) {
        log.info("UpdateListener");
        event.getUser().setUpdatedAt(Instant.now());

        userRepository.save(event.getUser());
    }


    @EventListener(CreateEvent.class)
    public void onApplicationEvent(CreateEvent event) {
        log.info("CreateListener");
        event.getUser().setCreatedAt(Instant.now());
        userRepository.save(event.getUser());
    }
}
