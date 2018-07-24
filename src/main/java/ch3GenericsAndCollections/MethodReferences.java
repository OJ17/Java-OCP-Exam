package ch3GenericsAndCollections;

import java.util.Comparator;

public class MethodReferences {
    // method references are a way to make code shorter by
    // by cutting out code that can be inferred and mentioning only the
    // method name

    public static int compareBySize(ComparableDemo c1, ComparableDemo c2) {
        return c1.getSize() - c2.getSize();
    }

    public static int compareByName(ComparableDemo c1, ComparableDemo c2) {
        return c1.getName().compareTo(c2.getName());
    }

    public static void main(String[] args) {
        // non Method reference way:
        Comparator<ComparableDemo> cOldSize = (c1, c2) -> compareBySize(c1, c2);

        Comparator<ComparableDemo> cOldName = (c1, c2) -> compareByName(c1, c2);

        // with method references:
        Comparator<ComparableDemo> cSizeDemo = MethodReferences::compareBySize;

        Comparator<ComparableDemo> cNameDemo = MethodReferences::compareByName;

        // Method references do not explicitly take in parameters
        // e.g. Collections::sort(1) is invalid for a method reference


    }

}
