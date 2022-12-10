package com.niklas.chargestationfinder.Helper;

import org.vaadin.elmot.flow.sensors.GeoLocation;

public class Geolocation {
    public static GeoLocation createGeolocation(GeoLocation geoLocation){
        geoLocation.setWatch(true);
        geoLocation.setHighAccuracy(true);
        geoLocation.setTimeout(100000);
        geoLocation.setMaxAge(200000);
        return geoLocation;
    }
}
