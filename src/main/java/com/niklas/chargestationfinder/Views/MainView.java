package com.niklas.chargestationfinder.Views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.Route;

@Route("test")
public class MainView extends Div {
    public MainView() {
        add(new Button("Test"));
    }
}
