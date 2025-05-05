package com.demowebshop.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;  // Поле для подтверждения пароля

    // Конструктор без параметров
    public User() {
    }

    // Конструктор с параметрами
    public User(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Сеттеры с возвратом объекта (цепочка вызовов)
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    // Сеттер для confirmPassword
    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    // Геттеры
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isPasswordConfirmed() {
        return password != null && password.equals(confirmPassword);
    }
}
