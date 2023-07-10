package composite;

public class Demo {
    public static void main(String[] args) {

        FileSystemNode file1 = new File("file1.txt");
        FileSystemNode file2 = new File("file2.txt");
        FileSystemNode file3 = new File("file3.txt");


        Folder root = new Folder("Root");
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");


        folder1.addNode(file1);
        folder1.addNode(file2);
        folder2.addNode(file3);
        root.addNode(folder1);
        root.addNode(folder2);

        root.display();
        System.out.println("------------------");
        folder2.display();
    }
}
