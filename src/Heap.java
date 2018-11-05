//17630-A4 Priority Queue
//Andrew ID: xinchenh
//Name: Xincheng Huang
//Heap Class
//This class represents the heap ADT.

public class Heap {
    private int size;//Total numbers in the heap
    private Node root;//Top node of the heap
    private Node tail;//The last node of the heap
    //Construction function
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

    //Add a new job to the heap, return the size of the heap
    public int append(Job newItem) {
        Job item = new Job(newItem.getName(), newItem.getPriority());
        Node node = new Node(item, null, null, null, null);

        //Check if the heap is empty
        if (isEmpty()) {
            root.setItem(node.getItem());
            size++;
            return size;
        }

        //If the heap is not empty
        tail.setNext(node);
        //Get the father node
        int fatherIndex = (size - 1) / 2;
        //Check if it's a left child or a right child
        int childType = size % 2;

        Node tempNode = root;
        for (int i = 0; i < fatherIndex; i++) {
            tempNode = tempNode.getNext();
        }

        //The father is found
        node.setFather(tempNode);
        if (childType == 0) {
            tempNode.setRightChild(node);
        } else tempNode.setLeftChild(node);
        tail = tail.getNext();
        size++;
        return size;
    }

    //A test function. Traverse the heap from left to right, top to bottom
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

    //Check if a certain node is in the heap
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

    //up heap
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

    //up heap the tail node
    public void swimTail() {
        swimUp(tail);
    }

    //down heap
    public void swimDown() {
        Node temp = root;
        //If the node has a left child or a right child that has a priority higher than it
        while ((temp.getLeftChild() != null &&
                temp.getItem().getPriority() >
                        temp.getLeftChild().getItem().getPriority()) ||
                (temp.getRightChild() != null &&
                        temp.getItem().getPriority() >
                                temp.getRightChild().getItem().getPriority())
        ) {
            //Choose a child node to switch
            if (temp.getRightChild() == null ||
                    temp.getLeftChild().getItem().getPriority()
                            < temp.getRightChild().getItem().getPriority()) {
                //Choose left
                Job tempJob = temp.getItem();
                temp.setItem(temp.getLeftChild().getItem());
                temp.getLeftChild().setItem(tempJob);
                temp = temp.getLeftChild();
            } else {
                //Choose right
                Job tempJob = temp.getItem();
                temp.setItem(temp.getRightChild().getItem());
                temp.getRightChild().setItem(tempJob);
                temp = temp.getRightChild();
            }


        }


    }

    //Add an item to the heap
    public void addItem(Job item) {
        //put the item at the tail
        append(item);
        //heapify
        swimTail();
    }

    //Delete the tail node
    public void cutTail() {
        //If it is a empty heap
        if (isEmpty())
            return;
        if (tail.getFather() != null) {
            //Is not the root node
            int childType = size % 2;
            //Check if it is the left child or the right child
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
        //If the node to delete is the father node
        //Though the node still lives here
        //The size will be zero after the deletion
        //This heap will still become a empty and the original will be rewritten in the future
        size--;
    }

    //Pop out the next priority job
    public Job pop() {
        if (isEmpty())
            return null;
        Job topJob = root.getItem();
        root.setItem(tail.getItem());
        //Heapfy
        swimDown();
        cutTail();
        return topJob;
    }

    //Print the information of the popped out node
    public void popInfo() {
        if (isEmpty())
            return;
        Job topJob = pop();
        System.out.println("The next priority item is:");
        System.out.println("Name: " + topJob.getName() + ", Priority: " + topJob.getPriority());
        System.out.println("This job has been deleted successfully!");
        System.out.println("There are "+size+" job(s) left.");
    }

    //Search a job and delete it if it exists
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
        System.out.println("Job found:");
        System.out.println("Name : " + temp.getItem().getName() + " ; Priority : " + temp.getItem().getPriority());
        temp.setItem(tail.getItem());
        cutTail();
        System.out.println("This job has been deleted successfully!");
        System.out.println("There are "+size+" job(s) left.");

        for(int i=0;i<size;i++)
        {
            Node curr=root;
            for(int j=0;j<size-i-1;j++)
            {
                curr=curr.getNext();
            }
            //heapfy all node
            swimUp(curr);
        }



    }


}
