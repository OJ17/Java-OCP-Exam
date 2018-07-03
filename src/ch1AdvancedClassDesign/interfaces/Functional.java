package ch1AdvancedClassDesign.interfaces;

// Here is a simple functional interface that uses generic type T
// It is similar to the consumer interface in java.util.function.Consumer
// The annotation @FunctionalInteface is not required for an interface to be functional

@FunctionalInterface
public interface Functional<T> {
    public void test(T t);
}

// This is a functional interface also, since 1 abs method
// public interface xFunctional extends Functional
// {
// }

// -- This is functional as it uses same as super
// -- due to overridden method
// public interface yFunctional extends Functional
// {
//  public void test(T t)
// }

// -- This is functional as it only has 1 abstract method
// public interface zFunctional extends Functional
//{
//   public default int getFunctional(String s){}
//   public static void zFunctional
// }



