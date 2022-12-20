package com.niklas.chargestationfinder.Views;

import com.niklas.chargestationfinder.API.Enums.Network;
import com.niklas.chargestationfinder.API.Enums.Plug;
import com.niklas.chargestationfinder.API.Model.Address;
import com.niklas.chargestationfinder.API.Model.ChargePoint;
import com.niklas.chargestationfinder.API.Model.Coordinates;
import com.niklas.chargestationfinder.API.Requests.ApiPost;
import com.niklas.chargestationfinder.API.Requests.ApiRequest;
import com.niklas.chargestationfinder.API.Station.Station;
import com.niklas.chargestationfinder.Helper.GUI;
import com.niklas.chargestationfinder.Helper.Geolocation;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.map.Map;
import com.vaadin.flow.component.map.configuration.Coordinate;
import com.vaadin.flow.component.map.configuration.feature.MarkerFeature;
import com.vaadin.flow.component.map.events.MapFeatureClickEvent;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.timepicker.TimePickerVariant;
import com.vaadin.flow.router.*;
import org.vaadin.elmot.flow.sensors.GeoLocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Route("charge-stations/stations")
public class StationsView extends AppLayout {
    private Tabs tabs = setTabs();
    private GeoLocation geoLocation = new GeoLocation();
    public StationsView() throws IOException {
        //Get Stations from API
        var stations = new ApiRequest().request();
        Map map = new Map();
        //Adding Geolocation to UI
        UI.getCurrent().add(Geolocation.createGeolocation(geoLocation, map));
        map.setHeightFull();




        //Click listener when clicking on a map-marker
        map.addFeatureClickListener(new ComponentEventListener<MapFeatureClickEvent>() {
            @Override
            public void onComponentEvent(MapFeatureClickEvent mapFeatureClickEvent) {
                MarkerFeature markerFeature = (MarkerFeature) mapFeatureClickEvent.getFeature();
                Dialog dialog = new Dialog();
                Text nameText = new Text("");


                for (Station s: stations) {
                    if(s.getId() == markerFeature.getId()){
                        //Creating UI for Marker
                        VerticalLayout verticalLayout = new VerticalLayout();
                        verticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
                        nameText.setText(s.getName());
                        TimePicker fromTimePicker = new TimePicker();
                        TimePicker toTimePicker = new TimePicker();
                        Button button = new Button("Reserve");
                        Text reservedText = new Text("");

                        //Adding Button action
                        button.addClickListener(buttonClickEvent -> {

                            boolean isReserved = false;
                            var list = s.getChargePoint().getReservedHours();
                            int from = fromTimePicker.getValue().getHour();
                            int to = toTimePicker.getValue().getHour();
                            if(to > from){
                                for(int i = from; i<=to;i++){
                                    if(list[i]==true){
                                        isReserved=true;
                                        break;
                                    }
                                }
                                if(isReserved){
                                    // reserved mechanic
                                    reservedText.setText("Already reserved");
                                } else {
                                    // free mechanic
                                    reservedText.setText("You reserved from " + from + " to " + to);
                                    s.getChargePoint().reserve(from,to);
                                }
                            } else{
                                reservedText.setText("Invalid timeframe");
                            }


                        });
                        verticalLayout.add(nameText, fromTimePicker, toTimePicker,reservedText, button);
                        dialog.add(verticalLayout);
                        dialog.open();
                    }
                }
            }
        });


        setContent(map);
        //Adding Markers to the Map
        for (Station s: stations) {
            Coordinate coordinate = new Coordinate(s.getCoordinates().getLng(), s.getCoordinates().getLat());
            MarkerFeature station = new MarkerFeature(coordinate);
            station.setId(s.getId());
            map.getFeatureLayer().addFeature(station);
        }
        //Creating UI
        DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1();
        GUI.createUI(title, tabs, getTabs(), 0);
        //Add Components to UI
        addToDrawer(tabs);
        addToNavbar(toggle, title);







    }

    private Tabs setTabs() {
        Tabs tabs = new Tabs();

        tabs.add(createTab(VaadinIcon.CAR, "Charger"),
                createTab(VaadinIcon.COG, "Settings"),
                createTab(VaadinIcon.FILTER, "Filter"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private Tab createTab(VaadinIcon viewIcon, String viewName) {
        Icon icon = viewIcon.create();
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        link.setTabIndex(-1);

        return new Tab(link);
    }

    private List<Tab> getTabs() {
        List<Tab> list = new ArrayList<>();
        for (int i = 0; i < tabs.getComponentCount(); i++) {
            list.add((Tab) tabs.getComponentAt(i));
        }
        return list;
    }



}
