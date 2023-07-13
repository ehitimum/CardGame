import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    int count1;
    int count2;


    void game(ArrayList<Integer> playerA, ArrayList<Integer> playerB){
        
        this.count1 = 0;
        this.count2 = 0;
        System.out.println("Input card's index number please: ");
        Scanner scanner = new Scanner(System.in);
        int randomIndex=scanner.nextInt();
        if(randomIndex>(playerA.size()-1) ){
            System.out.println("The card number you selected is not available. Please choose again from the above 5 cards: ");
            randomIndex = scanner.nextInt();

        }
        
        Integer randomCard = playerA.get(randomIndex);
        System.out.println("Selected Card is: " + randomCard);
        ArrayList<Integer> removedPairIndices = new ArrayList<>();

        //Finding pair by iterating
        Iterator<Integer> iterator = playerB.iterator();
        int index = 0;
        int pairfound = 0;//flagging if a pair is found.

        //Simple loop for finding pairs. Loop will end if a pair is found
        while (iterator.hasNext()) {
            int firstCard = iterator.next();

            // Iterate again starting from the next element
            Iterator<Integer> secondIterator = playerB.listIterator(index + 1);
            int innerIndex = index + 1;
            if(pairfound==1){
                break;
            }
            else{
                while (secondIterator.hasNext()) {
                int secondCard = secondIterator.next();
                    if (firstCard + secondCard == randomCard) { 
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
        // System.out.println("Player A's current cards: " + playerA);
        // System.out.println("Player B's current cards: " + playerB);
        // System.out.println("Removed pair of indices: " + removedPairIndices);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Card_assign cards = new Card_assign();

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //All the 32 cards are regeistered as their sequence. I removed H, C, D to simplify.
        cards.maincards(elements);
        cards.player_A();
        cards.player_B();

        int round = 1;//A round variable to keep track of when A is in lead or B is in lead.
        int playerApoint=0, playerBpoint=0;

        //A loop to automate the process
        while(Card.mainDec.size()!=0){
            //All odd number of round is A and even is B
            if(round %2 == 0 ){

                System.out.println("Round: "+round);
                System.out.println("Player B's current 5 cards: " + Card.playerB);

                app.game(Card.playerB, Card.playerA);//For even round method will get game(B, A)
                Card.playerB.add(Card.mainDec.get(0));
                Card.mainDec.remove(0);
                int limit = 5 - Card.playerA.size();
                if(Card.mainDec.size()>3){
                    for(int i=0; i<limit; i++){
                        Card.playerA.add(Card.mainDec.get(i));
                        Card.mainDec.remove(i);
                    }
                }
                System.out.println("Remaining Card's in the deck is: "+Card.mainDec.size());
                playerApoint += app.count2;
                playerBpoint += app.count1;
                if(app.count1> app.count2){
                    System.out.println("Player B wins this round. ");
                }else{
                    System.out.println("Player A wins this round. ");
                }
                System.out.println("Player A's points: " + playerApoint + " Player B's points: " + playerBpoint);
                System.out.println("------------------------------------------");

            }
            else{
                System.out.println("Round: "+round);
                System.out.println("Player A's current 5 cards: " + Card.playerA);
                app.game(Card.playerA, Card.playerB);//For odd round method will get game(A, B)

                Card.playerA.add(Card.mainDec.get(0));
                Card.mainDec.remove(0);
                int limit = 5 - Card.playerB.size();
                if(Card.mainDec.size()>3){
                    for(int i=0; i<limit; i++){
                        Card.playerB.add(Card.mainDec.get(i));
                        Card.mainDec.remove(i);
                    }
                }
                System.out.println("Remaining Card's in the deck is: "+Card.mainDec.size());
                playerApoint += app.count1;
                playerBpoint += app.count2;
                if(app.count1> app.count2){
                    System.out.println("Player A wins this round. ");
                }else{
                    System.out.println("Player B wins this round. ");
                }
                System.out.println("Player A's points: " + playerApoint + " Player B's points: " + playerBpoint);
                System.out.println("------------------------------------------");

            }
            round++;
        }

        if(playerApoint > playerBpoint){
            System.out.println("Winner: Player A = "+playerApoint+" Loser: "+playerBpoint);
        }
        else if(playerApoint == playerBpoint){
            System.out.println("The match is tied. Player A: "+playerApoint+" Player B: "+playerBpoint);
        }
        else{
            System.out.println("Winner: Player B = "+playerBpoint+" Loser: "+playerApoint);
        }

       

        

        




    }
}


