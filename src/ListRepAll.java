import java.util.ArrayList;
import java.util.List;

public class ListRepAll {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.replaceAll(in -> in.toLowerCase());
        list.forEach(System.out::print);
//        list.forEach(s ->System.out.println("Since when? " + s));
    }
}
