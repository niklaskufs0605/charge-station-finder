package com.niklas.chargestationfinder.API.POST;

import com.niklas.chargestationfinder.API.Database.ApiDatabase;
import com.niklas.chargestationfinder.API.Station.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ApiPost {

    ApiDatabase database;
    Station station;
    public ApiPost(Station station){
        this.station = station;
        database.save(station);
    }
}
