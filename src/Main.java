public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        Job job = new Job("0", 0);
        heap.append(job);
        job.setName("1");
        job.setPriority(1);
        heap.append(job);
        job.setName("2");
        job.setPriority(2);
        heap.append(job);
        job.setName("3");
        job.setPriority(3);
        heap.append(job);
        job.setName("4");
        job.setPriority(4);
        heap.append(job);
        job.setName("5");
        job.setPriority(5);
        heap.append(job);
        job.setName("6");
        job.setPriority(6);
        heap.append(job);

        /*Test Section*/
        heap.printNode(2);
        System.out.println(heap.isIn("2"));
    }
}
