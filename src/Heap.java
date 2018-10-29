public class Heap {
    private int size;
    private Node root;
    private Node tail;

    public Heap() {
        this.size = 0;
        Job job = new Job("0", 0);
        Node root = new Node(job, null, null, null, null);
        this.root = root;
        tail = root;
    }

    //If the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //The size of the heap
    public int size() {
        return size;
    }

    public int append(Job newItem) {
        Job item = new Job(newItem.getName(), newItem.getPriority());
        Node node = new Node(item, null, null, null, null);
        //System.out.println("The item is "+item);
        //System.out.println("The size before insert is "+ size);
        //If the heap is empty
        if (isEmpty()) {
            root.setItem(node.getItem());
            size++;
            return size;
        }

        //If the heap is not empty
        tail.setNext(node);
        int fatherIndex = (size - 1) / 2;
        //System.out.println("Father index is "+fatherIndex);
        int childType = size % 2;

        //System.out.println("The child type is "+ childType);
        Node tempNode = root;
        for (int i = 0; i < fatherIndex; i++) {
            tempNode = tempNode.getNext();
        }

        //System.out.println("Real father index is "+tempNode.getItem());
        node.setFather(tempNode);
        if (childType == 0) {
            tempNode.setRightChild(node);
            //System.out.println("The right child of node "+tempNode.getItem()+" is "+ node.getItem());
        } else tempNode.setLeftChild(node);
        //System.out.println("The left child of node "+tempNode.getItem()+" is "+ node.getItem());
        tail = tail.getNext();
        size++;
        return size;
    }

    //Traverse the heap
    public void traverse() {
        System.out.println("There are " + size + " nodes in the heap:");
        Node temp = root;
        int counter = 0;
        while (temp.getNext() != null) {
            System.out.print(counter + ":");
            System.out.println(temp.getItem().getName());
            counter++;
            temp = temp.getNext();
        }

    }

    //Print the information of a node
    public void printNode(int index) {
        Node temp = root;
        int counter = 0;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        if (temp.getFather() == null)
            System.out.println("The father node is null, this is the root node.");
        else System.out.println("The father node is: " + temp.getFather().getItem().getName());
        if (temp.getLeftChild() == null)
            System.out.println("The left child is null");
        else System.out.println("The left child node is: " + temp.getLeftChild().getItem().getName());
        if (temp.getRightChild() == null)
            System.out.println("The right child is null");
        else System.out.println("The right child node is: " + temp.getRightChild().getItem().getName());
        if (temp.getNext() == null)
            System.out.println("The next node is null, this is the tail node.");
        else System.out.println("The next node is: " + temp.getNext().getItem().getName());
    }

    public boolean isIn(String name){
        Node temp=root;
        int counter=0;
        while(counter<size)
        {
            if (temp.getItem().getName().compareTo(name)==0)
                return true;
            temp=temp.getNext();
            counter++;
        }
        return false;
    }
}
