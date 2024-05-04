package br.easy.parking.model;


import kong.unirest.json.JSONObject;

public class UserModel {

    public String name;

    public String lastName;

    public String phone;

    public String plate;

    public String email;

    public String password;

    public UserModel(JSONObject requestBodyJson) {
        name = requestBodyJson.getString("name");
        lastName = requestBodyJson.getString("lastName");
        phone = requestBodyJson.getString("phone");
        plate = requestBodyJson.getString("plate");
        email = requestBodyJson.getString("email");
        password = requestBodyJson.getString("password");
    }
}
