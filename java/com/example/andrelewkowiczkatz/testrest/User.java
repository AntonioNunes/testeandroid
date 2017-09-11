package com.example.andrelewkowiczkatz.testrest;

import java.util.Date;

/**
 * Created by andrelewkowiczkatz on 05/09/17.
 */

public class User {

    private int idUser;
    private String email;
    private String firstName;
    private String lastName;
    private String anonymName;
    private String gender;
    private Date birthDate;
    private String photo;
    private String password;
    //    private int[] friends;
//    private int[] postUsers;
    private int idCity;
    private int idState;
    private int idCountry;

    public User() {
    }

    public User(int idUser, String email, String firstName, String lastName, String anonymName, String gender, Date birthDate, String photo, String password, int idCity, int idState, int idCountry) {
        this.idUser = idUser;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.anonymName = anonymName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.photo = photo;
        this.password = password;
        this.idCity = idCity;
        this.idState = idState;
        this.idCountry = idCountry;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getAnonymName() {
        return anonymName;
    }

    public void setAnonymName(String anonymName) {
        this.anonymName = anonymName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    public ArrayList<User> getFriendList() {
//        return friendList;
//    }
//
//    public void setFriendList(ArrayList<User> friendList) {
//        this.friendList = friendList;
//    }

//    public ArrayList<PostUser> getPostUserList() {
//        return postUserList;
//    }
//
//    public void setPostUserList(ArrayList<PostUser> postUserList) {
//        this.postUserList = postUserList;
//    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

}
