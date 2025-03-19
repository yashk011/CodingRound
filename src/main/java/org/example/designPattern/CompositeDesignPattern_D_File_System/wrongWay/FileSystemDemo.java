package org.example.designPattern.CompositeDesignPattern_D_File_System.wrongWay;

public class FileSystemDemo {

    public static void main(String[] args) {
        Directory directory1 = new Directory("Movies");
        Directory directory2 = new Directory("Comedy Movies");
        File movie1 = new File("Hul Chul");
        File movie2 = new File("Hera Pheri");

        File movie3 = new File("Murder");

        directory1.add(movie3);
        directory2.add(movie1);
        directory2.add(movie2);

        directory1.add(directory2);

        directory1.ls();
    }
}
