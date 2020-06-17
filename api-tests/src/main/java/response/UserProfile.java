package response;

import lombok.Data;
import model.Role;

@Data
public class UserProfile {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String profilePicture;
    private Role role;
}
