package org.example.LLDQuestions.FIleSystem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Node {

    MetaData metaData;
    String name;
    Node parent;

    public abstract boolean isDirectory();

    public String getName() {
        return this.name;
    }

    public String getFullPath() {
        if(parent == null)
            return "";

        return parent.getFullPath() + "/" + name;
    }

}
