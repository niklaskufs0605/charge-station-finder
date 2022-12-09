package com.niklas.chargestationfinder.Views;

import com.niklas.chargestationfinder.Helper.GUI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.ArrayList;
import java.util.List;

@Route("charge-stations/settings")
public class SettingsView extends AppLayout {
    private Tabs tabs = setTabs();

    public SettingsView() {
        DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1();
        GUI.createUI(title, tabs, getTabs(), 1);
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
