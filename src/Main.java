import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.FutureTask;

public class Main implements AutoCloseable{
    public static void main(String args[]) throws Exception {
        //30.5387209452,114.3647274425
        double lat = 30.5387209452;
        double lng = 114.3647274425;
        double []coor = BDToGPS.gcj2WGSExactly(lat,lng);
        double lat_new = coor[0];
        double lng_new = coor[1];
        System.out.println("coor: "+lat_new+","+lng_new);
    }
    private static void method1(){
        MyThread m1 = new MyThread("线程A");
        MyThread m2 = new MyThread("线程B");
        MyThread m3 = new MyThread("线程C");
        m1.start();
        m2.start();
        m3.start();
    }
    private static void method2(){
        MyThread2 m1 = new MyThread2("线程A");
        MyThread2 m2 = new MyThread2("线程B");
        MyThread2 m3 = new MyThread2("线程C");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
    private static void method3(){
        String name = "线程对象";
        new Thread(()->{
            for (int x=0;x<200;x++){
                System.out.println(name+"1-->"+x);
            }
        }).start();
        new Thread(()->{
            for (int x=0;x<200;x++){
                System.out.println(name+"2-->"+x);
            }
        }).start();
    }
    private static void method4() throws Exception {
        MyThread3 m1 = new MyThread3();
        MyThread3 m2 = new MyThread3();
        FutureTask<String> task1 = new FutureTask<String>(m1);
        FutureTask<String> task2 = new FutureTask<String>(m2);

        new Thread(task1).start();
        new Thread(task2).start();

        System.out.println("A线程的返回结果："+task1.get());
        System.out.println("B线程的返回结果："+task2.get());
    }
    private static void method5(){
        MyThread4 m = new MyThread4();
        new Thread(m,"票贩子A").start();
        new Thread(m,"票贩子B").start();
        new Thread(m,"票贩子C").start();
        new Thread(m,"票贩子D").start();
    }
    private static void dateMethod(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = sdf.format(date);
        System.out.println(str);
    }
    private static void dateMethod2() throws Exception{
        String str = "2005-08-27 07:15:22.111";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = sdf.parse(str);
        System.out.println(date);
    }
    private static void dateMethod3() throws Exception{
        Calendar cal = Calendar.getInstance();
        StringBuffer buf = new StringBuffer();
        buf.append(cal.get(Calendar.YEAR)).append("-");
        buf.append(cal.get(Calendar.MONTH)+1).append("-");
        buf.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ");
        buf.append(cal.get(Calendar.HOUR_OF_DAY)).append(":");
        buf.append(cal.get(Calendar.MINUTE)).append(":");
        buf.append(cal.get(Calendar.SECOND));
        System.out.println(buf);
    }
    private static void binarySearch(){
        int data[] = new int[]{1,5,6,2,3,4,9,8,7,10};
        Arrays.sort(data);
        System.out.println(data.toString());
    }
    private static void IO1(){
        try (Net n = new Net()){
            n.info();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void IO2() throws Exception{
        File file = new File("D:"+File.separator+"demo"+File.separator+"mldn.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        OutputStream output = new FileOutputStream(file);
        String str = "bixby beats siri";
        byte data[] = str.getBytes();
        output.write(data);
        output.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭");
    }
}
