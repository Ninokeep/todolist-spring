package com.todolist.todolist.utils.enums;

public enum AccountType {
    BRONZE(10),
    PLATINIUM(20),
    DIAMOND(Integer.MAX_VALUE);

    private final int value;

    AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
