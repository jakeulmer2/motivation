package jakeulmer.motivation.models.forms;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @NotNull
    @Size(min=3, max=50)
    private String username;

    @NotNull
    @Email(message = "Please provide a valid email.")
    private String email;

    @NotNull
    @Size(min=5, max=40)
    private String password;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User(){}

    public int getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        return password != null ? password.hashCode() : 0;
    }*/
}
