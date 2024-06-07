import java.util.*;

public class text {
    public static void main(String[] args) {
        ArrayList<Integer> h1 = new ArrayList<>();
        for (int i = 0; i < 103; i++) {
            h1.add(i);
        }
        Iterator<Integer> tut = h1.iterator();
        while (tut.hasNext()) {
            if(tut.next()==100){
                System.out.println("Remove Successfully");
                tut.remove();
            }
        }
        for (Integer z1 : h1) {
            System.out.println("Current value"+z1);
        }
    }
}
