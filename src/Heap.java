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

    public Heap(int size, Node root, Node tail) {
        this.size = size;
        this.root = root;
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
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
        if (isEmpty()) {
            System.out.println("The heap is empty");
            return;
        }

        Node temp = root;
        int counter = 0;
        while (counter < size) {
            System.out.print(counter + ":");
            System.out.print(temp.getItem().getName());
            System.out.println(" Priority is: " + temp.getItem().getPriority());
            counter++;
            temp = temp.getNext();
        }

    }

    //Print the information of a node
    public void printNode(int index) {
        if (index >= size) {
            System.out.println("Illegal index");
            return;
        }
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

    public boolean isIn(String name) {
        Node temp = root;
        int counter = 0;
        while (counter < size) {
            if (temp.getItem().getName().compareTo(name) == 0)
                return true;
            temp = temp.getNext();
            counter++;
        }
        return false;
    }


    public void swimUp(Node node) {
        Node temp = node;
        if(temp.getFather() == null)
            return;
        while (temp.getFather() != null && temp.getFather().getItem().getPriority() > temp.getItem().getPriority()) {
            Job tempJob = temp.getItem();
            temp.setItem(temp.getFather().getItem());
            temp.getFather().setItem(tempJob);
            temp = temp.getFather();
        }
    }


    public void swimTail() {
        swimUp(tail);
    }

    public void swimDown() {
        Node temp = root;
        //If the node has a leftchild or a rightchild that has a priority higher than it
        while ((temp.getLeftChild() != null &&
                temp.getItem().getPriority() >
                        temp.getLeftChild().getItem().getPriority()) ||
                (temp.getRightChild() != null &&
                        temp.getItem().getPriority() >
                                temp.getRightChild().getItem().getPriority())
        ) {
            if (temp.getRightChild() == null ||
                    temp.getLeftChild().getItem().getPriority()
                            < temp.getRightChild().getItem().getPriority()) {
                Job tempJob = temp.getItem();
                temp.setItem(temp.getLeftChild().getItem());
                temp.getLeftChild().setItem(tempJob);
                temp = temp.getLeftChild();
            } else {
                Job tempJob = temp.getItem();
                temp.setItem(temp.getRightChild().getItem());
                temp.getRightChild().setItem(tempJob);
                temp = temp.getRightChild();
            }


        }


    }

    public void addItem(Job item) {
        append(item);
        swimTail();
    }


    public void cutTail() {   //If it is a empty heap
        if (isEmpty())
            return;
        if (tail.getFather() != null) {
            //System.out.println("The father of "+tail.getItem().getName()+" is "+tail.getFather().getItem().getName());
            int childType = size % 2;
            if (childType == 1) {
                tail.getFather().setRightChild(null);
            } else tail.getFather().setLeftChild(null);
        }

        Node pointer = root;
        for (int i = 0; i < size - 2; i++) {
            pointer = pointer.getNext();
        }
        pointer.setNext(null);
        tail = pointer;
        size--;
    }

    public Job pop() {
        if (isEmpty())
            return null;
        Job topJob = root.getItem();
        root.setItem(tail.getItem());
        swimDown();
        cutTail();
        return topJob;
    }

    public void delete(String name) {
        if (!isIn(name)) {
            System.out.println("Sorry, no such job!");
            return;
        }
        Node temp = root;
        int index = 0;
        while (temp.getItem().getName().compareTo(name) != 0) {
            temp = temp.getNext();
            index++;
        }
        System.out.println("Name is: " + temp.getItem().getName() + ", priority is: " + temp.getItem().getPriority());
        System.out.println("This is the " + index + " node.");
        temp.setItem(tail.getItem());
        cutTail();


        for(int i=0;i<size;i++)
        {
            //From tail to head, swim up each node
            Node curr=root;
            for(int j=0;j<size-i-1;j++)
            {
                curr=curr.getNext();
            }
            swimUp(curr);
        }



    }


}
