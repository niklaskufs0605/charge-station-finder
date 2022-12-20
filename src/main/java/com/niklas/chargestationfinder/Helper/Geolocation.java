package com.niklas.chargestationfinder.Helper;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.map.Map;
import com.vaadin.flow.component.map.configuration.Coordinate;
import com.vaadin.flow.component.map.configuration.feature.MarkerFeature;
import org.vaadin.elmot.flow.sensors.GeoLocation;
import org.vaadin.elmot.flow.sensors.PositionValueChangeEvent;

public class Geolocation {
    //Creating Geolocation and adding Marker to Map
    public static GeoLocation createGeolocation(GeoLocation geoLocation, Map map){
        geoLocation.setWatch(true);
        geoLocation.setHighAccuracy(true);
        geoLocation.setTimeout(100000);
        geoLocation.setMaxAge(200000);
        geoLocation.addValueChangeListener(new HasValue.ValueChangeListener<PositionValueChangeEvent>() {
            @Override
            public void valueChanged(PositionValueChangeEvent positionValueChangeEvent) {
                try {
                    if(!(geoLocation.getValue() == null)){
                        MarkerFeature loc = new MarkerFeature(new Coordinate(geoLocation.getValue().getLongitude(), geoLocation.getValue().getLatitude()));
                        loc.setIcon(MarkerFeature.POINT_ICON);
                        map.getFeatureLayer().addFeature(loc);

                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return geoLocation;
    }
}
