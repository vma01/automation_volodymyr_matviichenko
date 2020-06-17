package model;

import lombok.Builder;
import lombok.Data;
import utils.UserPermissions;

import java.util.List;

@Builder
@Data
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private Role role;
    private List<UserPermissions> permission;
}
