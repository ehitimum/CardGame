import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class App {

    int count1 = 0;
    int count2 = 0;


    void game(ArrayList<Integer> playerA, ArrayList<Integer> playerB){
        //Selecting Cards randomly from the current lead player
        Random random = new Random();
        int randomIndex = random.nextInt(playerA.size());
        Integer randomCard = playerA.get(randomIndex);
        System.out.println("Random Element: " + randomCard);
        ArrayList<Integer> removedPairIndices = new ArrayList<>();

        //Finding pair by iterating
        Iterator<Integer> iterator = playerB.iterator();
        int index = 0;
        int pairfound = 0;//flagging if a pair is found.
        while (iterator.hasNext()) {
            int firstElement = iterator.next();

            // Iterate again starting from the next element
            Iterator<Integer> secondIterator = playerB.listIterator(index + 1);
            int innerIndex = index + 1;
            if(pairfound==1){
                break;
            }
            else{
                while (secondIterator.hasNext()) {
                int secondElement = secondIterator.next();
                    if (firstElement + secondElement == randomCard) { 
                        this.count1++;
                        pairfound = 1;
                        removedPairIndices.add(index);
                        removedPairIndices.add(innerIndex);
                        break; 
                    }
                    innerIndex++;
                }
                index++;
            }
            
        }

        if(removedPairIndices.isEmpty()){
            this.count2++;
        }

        // Removing the cards after each round
        playerA.remove(randomIndex);
        if(removedPairIndices.isEmpty()==false){
            int val1 = removedPairIndices.get(0);
            int val2 = removedPairIndices.get(1);
            playerB.remove(val1);
            playerB.remove(val2-1);  
        }

        // Print the updated ArrayLists
        System.out.println("Player A's current cards: " + playerA);
        System.out.println("Player B's current cards: " + playerB);
        System.out.println("Player A's points: " + this.count1 + " Player B's points: " + this.count2);
        System.out.println("Removed pair indices: " + removedPairIndices);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Card_assign cards = new Card_assign();
        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        cards.maincards(elements);
        cards.player_A();
        cards.player_B();

        int round = 1;
        while(Card.mainDec.size()!=0){
            
            if(round %2 == 0 ){

                System.out.println("Round: "+round);
                System.out.println("Player A's current 5 cards: " + Card.playerA);
                System.out.println("Player B's current 5 cards: " + Card.playerB);
                app.game(Card.playerB, Card.playerA);
                Card.playerB.add(Card.mainDec.get(0));
                Card.mainDec.remove(0);
                System.out.println(Card.mainDec.size());

                int limit = 5 - Card.playerA.size();

                for(int i=0; i<limit; i++){
                    Card.playerA.add(Card.mainDec.get(i));
                    Card.mainDec.remove(i);
                }
                System.out.println(Card.mainDec.size());

                System.out.println("Updated player B's dec after round-"+round+": " + Card.playerB);
                System.out.println("Updated player A's dec after round-"+round+": " + Card.playerA);
                System.out.println("Updated Main Dec of cards after round-"+round+": " + Card.mainDec);
                System.out.println("------------------------------------------");

            }
            else{
                System.out.println("Round: "+round);
                System.out.println("Player A's current 5 cards: " + Card.playerA);
                System.out.println("Player B's current 5 cards: " + Card.playerB);
                app.game(Card.playerA, Card.playerB);
                Card.playerA.add(Card.mainDec.get(0));
                Card.mainDec.remove(0);
                System.out.println(Card.mainDec.size());

                int limit = 5 - Card.playerB.size();

                for(int i=0; i<limit; i++){
                    Card.playerB.add(Card.mainDec.get(i));
                    Card.mainDec.remove(i);
                }
                System.out.println(Card.mainDec.size());

                System.out.println("Updated player A's dec after round-"+round+": " + Card.playerA);
                System.out.println("Updated player B's dec after round-"+round+": " + Card.playerB);
                System.out.println("Updated Main Dec of cards after round-"+round+": " + Card.mainDec);
                System.out.println("------------------------------------------");

            }
            round++;
        }

        if(app.count1 > app.count2){
            System.out.println("Winner: Player A = "+app.count1+" Loser: "+app.count2);
        }
        else if(app.count1 == app.count2){
            System.out.println("The match is tied. Player A: "+app.count1+" Player B: "+app.count2);
        }
        else{
            System.out.println("Winner: Player B = "+app.count2+" Loser: "+app.count1);
        }

       

        

        




    }
}


