import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedUnchecked {


    public static class App {
        public static void main(String[] args) throws Exception {
            throw new Exception(); // тут ошибка компиляции
        }
    }
    public static class App2 {
        public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
            throw new Exception(); // а кидаем только Exception
        }
    }
    public static class App321 {
        public static void main(String[] args) throws Exception {
            f(); // тут ошибка компиляции
        }

        public static void f() throws Exception {
        }
    }


    public static class App12 {
        // пугаем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }
    public static class App123123 {
        // пугаем ПРЕДКОМ исключений
        public static void main(String[] args) throws IOException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }
    public static class App111 {
        // пугаем Exception
        public static void main(String[] args) throws Throwable {
            Throwable t = new Exception(); // и лететь будет Exception
            throw t; // но тут ошибка компиляции
        }
    }

}
