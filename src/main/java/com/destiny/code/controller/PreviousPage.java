package com.destiny.code.controller;

import javafx.scene.Parent;

public class PreviousPage {

    private static Parent root;

    public static void setParent(Parent root) {
        PreviousPage.root = root;
    }

    public static Parent getRoot() {
        return root;
    }
}
