package org.example.LLDQuestions.FIleSystem;

import java.util.Date;

public class File extends Node{
    StringBuilder content;

    public File(String name, Node parent) {
        super(new MetaData(100, new Date(), new Date()), name, parent);
    }

    public void write(String content) {
        this.content.append(content);
    }

    public String read() {
        return this.content.toString();
    }
    @Override
    public boolean isDirectory() {
        return false;
    }
}
