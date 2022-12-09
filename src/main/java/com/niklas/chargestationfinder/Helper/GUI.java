package com.niklas.chargestationfinder.Helper;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.List;

public class GUI {
    public static void createUI(H1 title, Tabs tabs, List<Tab> tabList, int pageIndex) {
        tabs.setSelectedIndex(pageIndex);
        //create Ttile for Tabselection
        title.setText("Stationfinder");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        //Add onClick-Events on Tabs
        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent selectedChangeEvent) {
                if(tabList.get(0).isSelected()) {
                    com.vaadin.flow.component.UI.getCurrent().navigate("charge-stations/stations");
                } else if(tabList.get(1).isSelected()) {
                    com.vaadin.flow.component.UI.getCurrent().navigate("charge-stations/settings");
                } else {
                    com.vaadin.flow.component.UI.getCurrent().navigate("charge-stations/filter");
                }
            }
        });
    }
}

