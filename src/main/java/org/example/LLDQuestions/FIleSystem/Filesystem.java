package org.example.LLDQuestions.FIleSystem;


import java.util.List;

public class Filesystem {
    Folder root;

    public Filesystem() {
        root = new Folder("/", null);
    }

    public Node getNode(String path) {
        String[] paths = path.split("/");
        Folder current = root;
        for(int i = 1;i<paths.length-1;i++) {
            String name = paths[i];
            if(current.getChildren(name) == null || !current.isDirectory()) return null;

            current = (Folder) current.getChildren(name);
        }

        return current.getChildren(paths[paths.length-1]);
    }

    public boolean delete(String path) {
        return true;
    }

    public void ls(String path) {
        String[] paths = path.split("/");
        Folder current = root;
        for(int i = 1;i<paths.length-1;i++) {
            String name = paths[i];
            if(current.getChildren(name) == null ) return;
            current = (Folder) current.getChildren(name);
        }

        Folder temp = (Folder) current.getChildren(paths[paths.length-1]);
        List<String> children = temp.ls();

        children.stream().forEach(i-> System.out.println(i + " "));
    }

    public void createNode(String path, boolean isDirectory) {
        String[] paths = path.split("/");
        Folder current = root;

        for(int i = 1;i<paths.length-1;i++) {
            String name = paths[i];
            if(current.getChildren(name) == null ) return;
            current = (Folder) current.getChildren(name);
        }

        String name = paths[paths.length-1];

        if(isDirectory) {
            current.children.put(name, new Folder(name, current));
        }
        else
            current.children.put(name, new File(name, current));
    }
}
