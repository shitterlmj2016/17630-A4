//17630-A4 Priority Queue
//Andrew ID: xinchenh
//Name: Xincheng Huang
//Job Class
//This class represents the job described in the hand out.

public class Job {
    //Job name and its priority
    private String name;
    private int priority;

    public Job() {

    }

    //Constructor
    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    //Setter and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
