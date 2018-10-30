public class Job {

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
