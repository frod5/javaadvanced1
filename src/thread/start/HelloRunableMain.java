package thread.start;

public class HelloRunableMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : main() start");

        //Thread를 사용할떄 Thread를 상속 받는것 보다는 Runable 인터페이스 사용하는 것이 낫다.
        Thread thread = new Thread(new HelloRunable());
        thread.start();

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
