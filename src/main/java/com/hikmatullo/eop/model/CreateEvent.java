package com.hikmatullo.eop.model;

import com.hikmatullo.eop.etity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateEvent {
    private User user;
}
