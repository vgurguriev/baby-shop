package com.example.babystore.model.dto;

public class OrderDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
    private String country;
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public OrderDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OrderDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public OrderDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public OrderDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderDto setCity(String city) {
        this.city = city;
        return this;
    }
}
