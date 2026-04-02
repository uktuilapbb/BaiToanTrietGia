import java.util.concurrent.locks.ReentrantLock;

/*
  Lớp Fork (cái nĩa)
  Mỗi fork là một tài nguyên dùng chung giữa 2 triết gia
 */
class Fork {
    // ReentrantLock giúp đảm bảo chỉ 1 thread giữ fork tại 1 thời điểm
    private final ReentrantLock lock = new ReentrantLock();

    /*
     Lấy fork (lock lại)
     Nếu fork đang bị giữ -> thread sẽ bị block (chờ)
     */
    public void pickUp() {
        lock.lock(); // khóa fork
    }

    /*
     Trả fork (mở khóa)
     */
    public void putDown() {
        lock.unlock(); // mở khóa fork
    }
}

/*
 Lớp Philosopher (triết gia)
 Mỗi triết gia là 1 thread chạy song song
 */
class Philosopher extends Thread {
    private final int id;          // ID của triết gia
    private final Fork leftFork;   // fork bên trái
    private final Fork rightFork;  // fork bên phải

    /*
     Constructor
     */
    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    /*
      Hành động "nghĩ"
     */
    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is THINKING");

        // sleep random để mô phỏng thời gian suy nghĩ
        Thread.sleep((int)(Math.random() * 1000));
    }

    /*
      Hành động "ăn"
     */
    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is EATING");

        // sleep random để mô phỏng thời gian ăn
        Thread.sleep((int)(Math.random() * 1000));
    }

    /*
     Hàm run() sẽ được thread thực thi
     */
    @Override
    public void run() {
        try {
            // vòng lặp vô hạn: triết gia liên tục nghĩ và ăn
            while (true) {

                // Bước 1: nghĩ
                think();

                /*
                 Bước 2: lấy fork
                  Đây là phần QUAN TRỌNG để tránh deadlock

                 Nếu tất cả triết gia đều:
                 lấy fork trái trước -> rồi fork phải
                 => sẽ gây deadlock (vòng chờ)

                 * Giải pháp:
                  Triết gia cuối (id = 4) sẽ lấy NGƯỢC thứ tự
                 */
                if (id == 4) {
                    // triết gia cuối: lấy fork phải trước
                    rightFork.pickUp();
                    leftFork.pickUp();
                } else {
                    // các triết gia còn lại: lấy fork trái trước
                    leftFork.pickUp();
                    rightFork.pickUp();
                }

                // Bước 3: ăn (khi đã có đủ 2 fork)
                eat();

                /*
                 Bước 4: trả fork
                 phải trả lại để người khác dùng
                 */
                leftFork.putDown();
                rightFork.putDown();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 Class chính để chạy chương trình
 */
public class BaiToanTrietGia {
    public static void main(String[] args) {

        int n = 5; // số triết gia

        // Mảng chứa fork
        Fork[] forks = new Fork[n];

        // Mảng chứa triết gia
        Philosopher[] philosophers = new Philosopher[n];

        /*
        tạo fork
         Có 5 triết gia -> cần 5 fork
         */
        for (int i = 0; i < n; i++) {
            forks[i] = new Fork();
        }

        /*
        tạo triết gia

         Mỗi triết gia i:
           - fork trái = forks[i]
           - fork phải = forks[(i+1) % n]

          % n để vòng tròn (triết gia cuối nối về đầu)
         */
        for (int i = 0; i < n; i++) {
            Fork left = forks[i];
            Fork right = forks[(i + 1) % n];

            philosophers[i] = new Philosopher(i, left, right);

            // start thread (bắt đầu chạy song song)
            philosophers[i].start();
        }
    }
}