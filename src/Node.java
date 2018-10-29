public class Node {
    private Job item;
    private Node father;
    private Node leftChild;
    private Node rightChild;
    private Node next;

    public Node(Job item, Node father, Node liftChild, Node rightChild, Node next) {
        this.item = item;
        this.father = father;
        this.leftChild = liftChild;
        this.rightChild = rightChild;
        this.next = next;
    }

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

//Move upwards
//    public void swim()
//    {
//        while (this.father!=null && this.item<this.father.item)
//        {
//            swap(this,this.father);
//        }
//
//    }

//    public void swap(Node a, Node b){
//        int tempItem=a.item;
//        a.item=b.item;
//        b.item=tempItem;
//    }

//    public void passItem(){
//
//    }

}
