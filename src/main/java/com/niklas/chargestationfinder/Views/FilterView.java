package com.niklas.chargestationfinder.Views;

import com.niklas.chargestationfinder.Enums.LocationFilter;
import com.niklas.chargestationfinder.Enums.OtherFilter;
import com.niklas.chargestationfinder.Enums.PlugFilter;
import com.niklas.chargestationfinder.Helper.GUI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.selection.MultiSelectionEvent;
import com.vaadin.flow.data.selection.MultiSelectionListener;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.ArrayList;
import java.util.List;

@Route("charge-stations/filter")
public class FilterView extends AppLayout {
    private Tabs tabs = setTabs();
    public FilterView() {
        MultiSelectComboBox<PlugFilter> plugFilter= setupPlugFilterComboBox();
        MultiSelectComboBox<LocationFilter> locationFilter = setupLocationFilterComboBox();
        MultiSelectComboBox<OtherFilter> otherFilter = setupOtherFilterComboBox();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.add(plugFilter, locationFilter, otherFilter);





        DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1();
        GUI.createUI(title, tabs, getTabs(), 2);
        //Add Components to UI
        setContent(layout);
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

    private MultiSelectComboBox setupLocationFilterComboBox(){
        MultiSelectComboBox<PlugFilter> filter = new MultiSelectComboBox<>("Plug-filters");
        filter.setItems(PlugFilter.values());
        filter.setItemLabelGenerator(PlugFilter::getName);
        filter.select(PlugFilter.values());
        filter.addSelectionListener(new MultiSelectionListener<MultiSelectComboBox<PlugFilter>, PlugFilter>() {
            @Override
            public void selectionChange(MultiSelectionEvent<MultiSelectComboBox<PlugFilter>, PlugFilter> multiSelectionEvent) {
                //Todo: Set Action what happens when Combobox changes selection
            }
        });
        return filter;
    }
    private MultiSelectComboBox setupPlugFilterComboBox(){
        MultiSelectComboBox<LocationFilter> filter = new MultiSelectComboBox<>("Location-filters");
        filter.setItems(LocationFilter.values());
        filter.setItemLabelGenerator(LocationFilter::getLocationName);
        filter.addSelectionListener(new MultiSelectionListener<MultiSelectComboBox<LocationFilter>, LocationFilter>() {
            @Override
            public void selectionChange(MultiSelectionEvent<MultiSelectComboBox<LocationFilter>, LocationFilter> multiSelectionEvent) {
                //Todo: Set Action what happens when Combobox changes selection
            }
        });
        return filter;
    }
    private MultiSelectComboBox setupOtherFilterComboBox(){
        MultiSelectComboBox<OtherFilter> filter = new MultiSelectComboBox<>("Other");
        filter.setItems(OtherFilter.values());
        filter.setItemLabelGenerator(OtherFilter::getName);
        filter.addSelectionListener(new MultiSelectionListener<MultiSelectComboBox<OtherFilter>, OtherFilter>() {
            @Override
            public void selectionChange(MultiSelectionEvent<MultiSelectComboBox<OtherFilter>, OtherFilter> multiSelectionEvent) {
                //Todo: Set Action what happens when Combobox changes selection
            }
        });
        return filter;
    }
}
