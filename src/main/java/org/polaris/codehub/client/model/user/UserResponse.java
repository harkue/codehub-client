package org.polaris.codehub.client.model.user;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<User> success;
    private List<User> failure;
}
