public class Node {
    private int item;
    private Node father;
    private Node brother;
    private Node liftChild;
    private Node rightChild;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getBrother() {
        return brother;
    }

    public void setBrother(Node brother) {
        this.brother = brother;
    }

    public Node getLiftChild() {
        return liftChild;
    }

    public void setLiftChild(Node liftChild) {
        this.liftChild = liftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    //Move upwards
    public void swim()
    {
        while (this.father!=null && this.item>this.father.item)
        {
            swap(this,this.father);
        }

    }

    public void swap(Node a, Node b){
        int tempItem=a.item;
        a.item=b.item;
        b.item=tempItem;
    }

    public void passItem(){
        
    }

}
