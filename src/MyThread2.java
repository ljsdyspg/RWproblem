public class MyThread2 implements Runnable{
    private String name;
    public MyThread2(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i<200;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name+"-->"+i);
        }
    }
}
