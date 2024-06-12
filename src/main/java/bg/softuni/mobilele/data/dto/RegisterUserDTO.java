package bg.softuni.mobilele.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {
    @NotEmpty(message = "{users.register.firstName.notEmpty}")
    @Size(min = 2, max = 20,
        message = "{users.register.firstName.length}")
    private String firstName;
    @NotEmpty (message = "{users.register.lastName.notEmpty}")
    @Size(min = 2, max = 20,
        message = "{users.register.lastName.length}")
    private String lastName;
    @NotEmpty (message = "{users.register.username.notEmpty}")
    @Size(min = 2, max = 20,
        message = "{users.register.username.length}")
    private String username;
    @NotEmpty (message = "{users.register.password.notEmpty}")
    @Size(min = 2, max = 20,
        message = "{users.register.password.length}")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
