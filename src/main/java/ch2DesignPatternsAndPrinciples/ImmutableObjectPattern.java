package ch2DesignPatternsAndPrinciples;

import java.util.ArrayList;
import java.util.List;

// immutable object ensures objects are the same and not changed
// this is similar to encapsulation without ordinary getter / setter method
// it is similar to a private final variable, but read access is public
public final class ImmutableObjectPattern {
    // all fields should be private and final
    private final List<String>  immutableObjects;

    public ImmutableObjectPattern(List<String> immutableObjects){
        if(immutableObjects == null){
            throw new RuntimeException("Immutable objects required");
        }
        this.immutableObjects = new ArrayList<>(immutableObjects);
    }


    // access to the list itself is restricted behind getters
    // that don't give a reference to the list itself
    public int getImmutableObjectsCount(){
        return immutableObjects.size();
    }

    public String getImmutableObject(int index){
        return immutableObjects.get(index);
    }


    // this getter is not allowed, since a user could modify the list
    // via immutableObjects.clear() for example.
//    ArrayListpublic List<String> getImmutableObjects() {
//        return immutableObjects;
//    }

    // since the variable immutableObjects is private and final
    // the only way to add to it is via the constructor.
    // this, along with the lack of setter method, means
    // that the object is immutable (Cannot be changed) after creation


}
