import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClients {


    // private static ServerSocket server;

    public static void StartTest() throws IOException, InterruptedException {

        // запустим пул нитей в которых колличество возможных нитей ограничено -
        // 10-ю.
        ExecutorService exec = Executors.newFixedThreadPool(10);
        int j = 0;

        // стартуем цикл в котором с паузой в 10 милисекунд стартуем Runnable
        // клиентов,
        // которые пишут какое-то количество сообщений
        while (j < 10) {
            j++;
            exec.execute(new TestRunnableClientTester());
            Thread.sleep(10);
        }

        // закрываем фабрику
        exec.shutdown();
    }

    private static class TestRunnableClientTester implements Runnable {
        static Socket socket;
        static int count = 0;
        private int myCount=0;
        private boolean isNicknameSended=false;

        public TestRunnableClientTester() {
            try {
                myCount=count;
                count++;
                // создаём сокет общения на стороне клиента в конструкторе объекта
                socket = new Socket("localhost", 1000);
                System.out.println("Client connected to socket");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            try (

                    // создаём объект для записи строк в созданный скокет, для
                    // чтения строк из сокета
                    // в try-with-resources стиле
                    DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                    DataInputStream ois = new DataInputStream(socket.getInputStream())) {
                System.out.println("Client oos & ois initialized");

                int i = 0;
                // создаём рабочий цикл
                while (true) {
                    Random random = new Random();
                    // пишем сообщение автогенерируемое циклом клиента в канал
                    // сокета для сервера
                    if(!isNicknameSended){
                        isNicknameSended=true;
                        oos.writeUTF("nickname_"+count+"_"+random.nextInt(100));
                    }
                    else {
                        System.out.println("sending message");
                        oos.writeUTF(myCount + " clientCommand " + random.nextInt(100));
                    }


                    // проталкиваем сообщение из буфера сетевых сообщений в канал
                    oos.flush();

                    // ждём чтобы сервер успел прочесть сообщение из сокета и
                    // ответить
                    Thread.sleep(10);
                    System.out.println("Client wrote & start waiting for data from server..." + " = " + myCount);

                    // забираем ответ из канала сервера в сокете
                    // клиента и сохраняем её в ois переменную, печатаем на
                    // консоль
                    System.out.println("reading...");
                    String in = ois.readUTF();
                    System.out.println(in);
                    i++;

                    Thread.sleep(random.nextInt(3000));

                }
//                oos.writeUTF("quit");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}