package com.example.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SharedPref {

    private static final String MY_STORAGE_FILE_NAME = "MY_STORAGE_FILE_NAME";
    private static final String NAME_KEY = "NAME_KEY";
    private static final String USER_KEY = "USER_KEY";
    private static final String USERS_KEY = "USERS_KEY";
    private static SharedPref instance;
    private final SharedPreferences mSharedPref;

    private SharedPref(Context context){
        mSharedPref = context.getSharedPreferences(MY_STORAGE_FILE_NAME, MODE_PRIVATE);
    }

    /**
     * @return SharedPref instance , can be null
     */
    public static SharedPref getInstance(){
        return instance;
    }

    public static SharedPref getInstance(Context context){
        if (instance == null) {
            instance = new SharedPref(context);
        }
        return instance;
    }

    public void setName(String name){
        mSharedPref.edit().putString(NAME_KEY, name).apply();
    }

    public String getName(){
       return mSharedPref.getString(NAME_KEY, "");
    }

    public void setUser(User user) {
        String userString = new Gson().toJson(user);
        mSharedPref.edit().putString(USER_KEY, userString).apply();
    }

    public User getUser(){
        String userString = mSharedPref.getString(USER_KEY, "");
        User user = new Gson().fromJson(userString, User.class);
        return user;
    }

    public void setUsers(ArrayList<User> users){
        String usersString = new Gson().toJson(users);
        mSharedPref.edit().putString(USERS_KEY, usersString).apply();
    }

    public ArrayList<User> getUsers(){
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        String usersString = mSharedPref.getString(USERS_KEY, "");
        ArrayList<User> users = new Gson().fromJson(usersString, listType);
        return users;
    }

}
