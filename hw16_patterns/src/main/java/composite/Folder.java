package composite;

import java.util.ArrayList;
import java.util.List;

class Folder implements FileSystemNode {
    private String name;
    private List<FileSystemNode> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addNode(FileSystemNode node) {
        children.add(node);
    }

    public void removeNode(FileSystemNode node) {
        children.remove(node);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemNode node : children) {
            node.display();
        }
    }
}
