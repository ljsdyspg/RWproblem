public class Net implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("*** 网络资源关闭，释放资源");
    }
    public void info() throws Exception{
        System.out.println("*** 欢迎访问");
    }
}
