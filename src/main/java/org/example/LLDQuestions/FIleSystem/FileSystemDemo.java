package org.example.LLDQuestions.FIleSystem;

public class FileSystemDemo {

    public static void main(String[] args) {

        Filesystem filesystem = new Filesystem();
        filesystem.createNode("/movies",    true);
        filesystem.createNode("/movies/comedy",    true);

        filesystem.createNode("/movies/comedy/hulchul.mp4", false);
        filesystem.createNode("/movies/comedy/herapheri.mp4", false);
        filesystem.ls("/movies/comedy");

    }
}
