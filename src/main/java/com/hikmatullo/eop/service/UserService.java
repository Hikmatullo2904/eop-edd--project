package com.hikmatullo.eop.service;

import com.hikmatullo.eop.etity.User;
import com.hikmatullo.eop.model.CreateEvent;
import com.hikmatullo.eop.model.UpdateEvent;
import com.hikmatullo.eop.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public void save(User user) {
        userRepository.save(user);
        publisher.publishEvent(new CreateEvent(user));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void update(Long id, User user) {
        Optional<User> byId =
                userRepository.findById(id);
        if(byId.isEmpty())
            throw new RuntimeException("User not found");

        User user1 = byId.get();
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        userRepository.save(user1);

        publisher.publishEvent(new UpdateEvent(user1));
    }
}
