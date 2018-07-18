package ch6ExceptionsAndAssertions;

public class AssertionsDemo {

    public static void main(String[] args) {

        // this is a simple assert statement
        assert false;

        // assertions are disabled by default
        assert 1 > 2 : "while 1 > 2";

        // if an assertion is false, and -ea
        // then it throws an AssertionError
        if (!true) throw new AssertionError();


        // enabling assertion from command line
        // java -enableassertions ClassName
        // java -ea ClassName
        // java -ea:com.fear.wolf.ClassName


    }

}


