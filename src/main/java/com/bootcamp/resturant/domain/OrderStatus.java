package com.bootcamp.resturant.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

    PICKED_UP("Picked_UP"), PREPARATION("PREPARATION"),COMPLETED("COMPLETED"),INVALID("INVALID");

    private String value;


    OrderStatus(String value) {
        this.value = value;
    }


    public static OrderStatus fromName(String name) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.value.equalsIgnoreCase(name)) {
                return status;
            }
        }
        return null;
    }


    @JsonValue
    public String getValue() {
        return value;
    }

}
