package com.niklas.chargestationfinder.API.Requests;

import com.google.gson.Gson;
import com.niklas.chargestationfinder.API.Station.Station;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiPost {
    //Method for adding Stations to API
    public int addStation(Station station) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = null;
        Gson gson = new Gson();
        try {
            HttpPost request = new HttpPost("http://localhost:8080/station/api/addStation");
            StringEntity params = new StringEntity(gson.toJson(station));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            response = httpClient.execute(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response.getStatusLine().getStatusCode();
    }

    //Method for updating Stations in API
    public int updateStation(String oldStationId, Station newStation) throws IOException {
        ApiRequest apiRequest = new ApiRequest();
        ApiPost apiPost = new ApiPost();
        var station = apiRequest.requestWithId(oldStationId);
        String id= station.getId();
        station = newStation;
        station.setId(id);
        return apiPost.addStation(station);
    }
}
