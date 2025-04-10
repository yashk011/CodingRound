package org.example.LLDQuestions.CompositeDesignPattern_D_File_System.correctWay.filesysytem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemResource{
    String name;
    List<FileSystemResource> resources;

    public Directory(String name) {
        this.name = name;
        resources = new ArrayList<>();
    }

    public void add(FileSystemResource object) {
        this.resources.add(object);
    }

    public void ls() {
        System.out.println("- " + this.name);
        for(FileSystemResource resource : resources) {
            resource.ls();
        }
    }

}
