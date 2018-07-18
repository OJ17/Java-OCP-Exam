package ch4FunctionalProgramming;

import java.util.function.BiFunction;

public class LambdaSyntax {


    // it is possible to declare a variable in a lambda provided
// that it is not already defined
    BiFunction<String, String, String> ps =
            (a, b) -> {
                int c = 0;
                return "sup";
            };

}

// general rules are
// 1. one or more parameters must be wrapped in parenthesis
// 2. if type is specified; parenthesis are required
// 3. if {} are used, you need to use return statement for return values
// 4. if {} is used, each statements requires ;

// Valid Lambda syntax:
//   a -> a.toString();
//   () -> System.out.println();
//   a -> {return a.getHashcode();}
// (String a) -> a.makesSense();
// String a, int x) -> a.makesSense();
// (a,x) -> {int x = 1; return x+10}
// (String x, String y) -> return s.length() + Y;)
//


// invalid lambda syntax
// -> System.out/println("Hello);
// SpaceBase sb -> sb.getToSpace():
// sb, cs -> sb.getToSpace();
// SpaceBase sb, cadetStats cs - sb.getToSpace();


