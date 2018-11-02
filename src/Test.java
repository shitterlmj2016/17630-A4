public class Test {

    static Heap print(Heap heap)
    {
        Heap clone=new Heap();
        int index=0;
        while (heap.size()!=0)
        {  index++;
           Job t=heap.pop();
           System.out.println(index+": "+t.getName()+" Priority: "+t.getPriority());
           clone.addItem(t);
        }
        return clone;
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        Job job = new Job();
        job.setName("J1");
        job.setPriority(6);
         heap.addItem(job);
        job.setName("J2");
        job.setPriority(3);
        heap.addItem(job);
        job.setName("J3");
        job.setPriority(3);
        heap.addItem(job);
        job.setName("J4");
        job.setPriority(7);
        heap.addItem(job);
        job.setName("J5");
        job.setPriority(8);
        heap.addItem(job);
        job.setName("J6");
        job.setPriority(3);
        heap.addItem(job);
        job.setName("J7");
        job.setPriority(19);
        heap.addItem(job);
        /*Main Section*/
        heap.traverse();
        heap=print(heap);
        System.out.println("Second Print:");
        heap=print(heap);


    }
}
