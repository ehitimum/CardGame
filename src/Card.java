import java.util.ArrayList;

public interface Card{

    ArrayList<Integer> mainDec = new ArrayList<>();
    ArrayList<Integer> playerA = new ArrayList<>();
    ArrayList<Integer> playerB = new ArrayList<>();
    public void maincards(Integer[] elements);

    public void player_A();

    public void player_B();
}
