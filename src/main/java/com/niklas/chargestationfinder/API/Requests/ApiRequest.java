package com.niklas.chargestationfinder.API.Requests;

import com.google.gson.Gson;
import com.niklas.chargestationfinder.API.Station.Station;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiRequest {
    //Getting all Stations from the API
    public Station[] request() throws IOException {
        URL url = new URL("http://localhost:8080/station/");
        String s = "";
        Station[] returnValue = null;
        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        } catch(Exception e){
            throw new IOException("Can´t connect to API");
        }

        try{
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                s += scanner.nextLine();
            }
            scanner.close();

            Gson gson = new Gson();
            returnValue = gson.fromJson(s, Station[].class);

        } catch(IOException e){
            throw new IOException("Can´t read API");
        }
        return returnValue;
    }

    //Getting Station with specific ID
    public Station requestWithId(String id) throws IOException {
        URL url = new URL("http://localhost:8080/station/" + id);
        String s = "";
        Station returnValue = null;
        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        } catch(Exception e){
            throw new IOException("Can´t connect to API");
        }

        try{
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                s += scanner.nextLine();
            }
            scanner.close();
            Gson gson = new Gson();
            returnValue = gson.fromJson(s, Station.class);

        } catch(IOException e){
            throw new IOException("Can´t read API");
        }
        return returnValue;
    }
}
