import java.util.Arrays;
import java.util.Collections;

public class Card_assign implements Card{

    @Override
    public void maincards(Integer[] elements) {

        mainDec.addAll(Arrays.asList(elements));
        System.out.println("Original Main Dec of Cards: "+mainDec);
        System.out.println(mainDec.size());
        Collections.shuffle(mainDec);
    }

    @Override
    public void player_A() {
        playerA.addAll(mainDec.subList(0, 5));

        for (Integer element : playerA) {
            mainDec.remove(element);
        }  
        System.out.println("Player A's initial 5 cards: " + playerA);
    }

    @Override
    public void player_B() {
        playerB.addAll(mainDec.subList(5, 10));

        for (Integer element : playerB) {
            mainDec.remove(element);
        }
        System.out.println("Player B's initial 5 cards: " + playerB);
    }

}
