public class MyThread4 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int x=0;x<20;x++){
            synchronized (this){
                if (this.ticket>0) {
                    try {
                    Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,ticket = " + this.ticket--);
                }
            }
        }
    }
}
