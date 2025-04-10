package org.example.LLDQuestions.CompositeDesignPattern_D_File_System.wrongWay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class File {
    String name;

    public void ls() {
        System.out.println("- " +  this.name);
    }
}
