package org.example.LLDQuestions.lockermanagementsystem.model;

public class Package implements LockerItem{
    String name;
    Size size;
    public Package(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public Size getSize() {
        return this.size;
    }
}
