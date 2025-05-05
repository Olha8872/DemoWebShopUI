package com.demowebshop.models;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Contact setPassword(String password) {
        if (password == null || password.length() < 6) { // Ensure the password is long enough
            throw new IllegalArgumentException("Password is too short");
        }
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Contact setConfirmPassword(String confirmPassword) {
        if (confirmPassword == null || !confirmPassword.equals(this.password)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    // If needed, use setName to combine firstName and lastName
    public Contact setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        return this;
    }
}
