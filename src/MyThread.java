import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class MyThread extends Thread{
    private int number;
    private Consumer<Integer> condition;
    private AtomicBoolean isProcessed = new AtomicBoolean(true);
    public MyThread(Consumer<Integer> condition){
        this.condition=condition;
    }
    public boolean isProcessed() {
        return isProcessed.get();
    }

    public void process(int number) {
        this.number = number;
        this.isProcessed.set(false);
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (isProcessed.get()) {
                continue;
            }

            condition.accept(number);
            isProcessed.set(true);
        }
    }
}
