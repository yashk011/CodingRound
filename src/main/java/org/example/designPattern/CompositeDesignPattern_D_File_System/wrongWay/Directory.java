package org.example.designPattern.CompositeDesignPattern_D_File_System.wrongWay;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String name;
    List<Object> resources;

    public Directory(String name) {
        this.name = name;
        resources = new ArrayList<>();
    }

    public void add(Object object) {
        this.resources.add(object);
    }

    public void ls() {
        System.out.println("- " + this.name);
        for(Object resource : resources) {
            if(resource instanceof Directory) {
                Directory directory = (Directory) resource;
                directory.ls();
            }
            else if(resource instanceof File) {
                File file = (File) resource;
                file.ls();
            }
        }

    }

}
