package com.wazzups.springstartherep3.main;

public class DeliveryDetailsPrinter {
    private Sorter sorter;

    public DeliveryDetailsPrinter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void printDetails() {
        sorter.sortDetails();
        //print the delivery details
    }
}
