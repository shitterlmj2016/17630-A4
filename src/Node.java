//17630-A4 Priority Queue
//Andrew ID: xinchenh
//Name: Xincheng Huang
//Node Class
//This class represents the node of the heap.
public class Node {
    private Job item;//Stored job
    private Node father;//Father node
    private Node leftChild;//Left child node
    private Node rightChild;//Right child node
    private Node next;//Next node, from top to bottom, left to right.

    //Construction Function
    public Node(Job item, Node father, Node liftChild, Node rightChild, Node next) {
        this.item = item;
        this.father = father;
        this.leftChild = liftChild;
        this.rightChild = rightChild;
        this.next = next;
    }
    //Setters and getters
    public Job getItem() {
        return item;
    }

    public void setItem(Job item) {
        this.item = item;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
