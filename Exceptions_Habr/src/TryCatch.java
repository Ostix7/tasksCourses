public class TryCatch {

    public static class App {
        public static void main(String[] args) {
            f(null);
        }

        public static void f(NullPointerException e) {
            try {
                throw e;
            } catch (NullPointerException npe) {
                f(npe);
            }
        }
    }

    public class App2 {
        public double sqr(double arg) { // надо double
            return arg * arg;           // double * double - это double
        }
    }

    public class App3 {
        public double sqr(double arg) { // надо double
            int k = 1;                  // есть int
            return (double) k;          // явное преобразование int в double
        }
    }

    public static class App4 {
        public static String sqr(double arg) {
            return "hello!";
        }
    }

    public static class App5 {
        public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
            long time = System.currentTimeMillis();
            if (time % 2 == 0) {
                return arg * arg;             // ок, вот твой double
            } else if (time % 2 == 1) {
                {
                    while (true) ;                 // не, я решил "повиснуть"
                }
            }
            return arg;
        }
    }
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            return -1; // специальное "неправильное" значение площади
        }
        return width * height;
    }
    public static int area2(int width, int height) {
        if (width < 0 || height < 0) {
            System.exit(0);
        }
        return width * height;
    }
    public static int area3(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
    public static class App7 {
        public static void main(String[] args) {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    RuntimeException re = (RuntimeException) e;
                    System.err.print("Это RuntimeException на самом деле!!!");
                } else {
                    System.err.print("В каком смысле не RuntimeException???");
                }
            }
        }
    }

    public static class Appp{
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {throw new RuntimeException();}
                System.err.print(" 1");
            } catch (RuntimeException e) { // перехватили RuntimeException
                System.err.print(" 2.1");
                try {
                    System.err.print(" 2.2");
                    if (true) {throw new Error();} // и бросили новый Error
                    System.err.print(" 2.3");
                } catch (Throwable t) {            // перехватили Error
                    System.err.print(" 2.4");
                }
                System.err.print(" 2.5");
            } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
                System.err.print(" 3");
            }
            System.err.println(" 4");
        }
    }
        }
class App1231234 {
    public static void main(String[] args) {
        try {
            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}


