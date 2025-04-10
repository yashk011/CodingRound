package org.example.LLDQuestions.FIleSystem;

import java.util.*;

public class Folder extends Node{

    Map<String, Node> children = new HashMap<>();

    public Folder(String name, Node parent) {
        super(new MetaData(100, new Date(), new Date()), name, parent);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public List<String> ls() {
        System.out.println(this.getFullPath());
        return new ArrayList<>(children.keySet());
    }

    public Node getChildren(String name) {
        return this.children.get(name);
    }

    public Node addChildren(String name, Node node) {
        return this.children.put(name, node);
    }




}
