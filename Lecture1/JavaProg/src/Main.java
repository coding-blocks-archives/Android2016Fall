import com.codingblocks.com.Hello;

public class Main {



    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Hello.myString);

        Hello h1  = new Hello();
        Hello h2 = new Hello();

        h1.nonStaticString = "";

        h1.myString = "";

    }
}
