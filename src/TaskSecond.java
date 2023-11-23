import java.util.ArrayList;
import java.util.List;

public class TaskSecond {

    public static void main(String[] args) {
        MyThread threadA = new MyThread(n->{
            if (n%3==0 && n%5!=0) {System.out.println("fizz");};
        });
        MyThread threadB = new MyThread(n->{
            if (n%3!=0 && n%5==0) {System.out.println("buzz");}
        });
        MyThread threadC = new MyThread(n->{
            if (n%3==0 && n%5==0) {System.out.println("fizzbuzz");}
        });
        MyThread threadD = new MyThread(n->{
            if (n%3!=0 && n%5!=0) {System.out.println(n);}
        });


        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        int num = 15;
        List<MyThread> nps = new ArrayList<>();
        nps.add(threadA);
        nps.add(threadB);
        nps.add(threadC);
        nps.add(threadD);

        for (int i=1; i<=num; i++){
            threadA.process(i);
            threadB.process(i);
            threadC.process(i);
            threadD.process(i);

            while (true) {
                int processedNumbersCount = 0;
                for (MyThread np : nps) {
                    if (np.isProcessed()) {
                        processedNumbersCount++;
                    }
                }
                if (processedNumbersCount == 4) {
                    break;
                }
            }
        }
    }
}
