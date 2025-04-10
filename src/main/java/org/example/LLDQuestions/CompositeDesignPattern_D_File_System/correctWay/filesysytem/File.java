package org.example.LLDQuestions.CompositeDesignPattern_D_File_System.correctWay.filesysytem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class File implements FileSystemResource{
    String name;

    public void ls() {
        System.out.println("- " +  this.name);
    }
}
