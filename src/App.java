

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class App {

    int count1 = 0;
    int count2 = 0;


    void game(ArrayList<Integer> playerA, ArrayList<Integer> playerB){
        Random random = new Random();
        int randomIndex = random.nextInt(playerA.size());
        Integer ranelement = playerA.get(randomIndex);
        System.out.println("Random Element: " + ranelement);
        ArrayList<Integer> elementsToRemove = new ArrayList<>();
        ArrayList<Integer> elementsToRemove2 = new ArrayList<>();
        ArrayList<Integer> removedPairIndices = new ArrayList<>();

        Iterator<Integer> iterator = playerB.iterator();
        int index = 0;
        int pairfound = 0;
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

                // Check if the sum of two elements is equal to the random element
                    if (firstElement + secondElement == ranelement) {
                        // Remove the three elements from both ArrayLists
                        this.count1++;
                        pairfound = 1;
                        elementsToRemove2.add(ranelement);
                        elementsToRemove.add(firstElement);
                        elementsToRemove.add(secondElement);
                        removedPairIndices.add(index);
                        removedPairIndices.add(innerIndex);
                        break; // Break the inner loop after removing the elements
                    }
                    innerIndex++;
                }
                index++;
            }
            
        }

        if (elementsToRemove2.isEmpty() && elementsToRemove.isEmpty()) {
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
        ArrayList<Integer> mainDec = new ArrayList<>();
        ArrayList<Integer> playerA = new ArrayList<>();
        ArrayList<Integer> playerB = new ArrayList<>();

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        mainDec.addAll(Arrays.asList(elements));
        System.out.println("Original Main Dec of Cards: "+mainDec);
        System.out.println(mainDec.size());
        Collections.shuffle(mainDec);
        playerA.addAll(mainDec.subList(0, 5));
        playerB.addAll(mainDec.subList(5, 10));

        for (Integer element : playerA) {
            mainDec.remove(element);
        }

        for (Integer element : playerB) {
            mainDec.remove(element);
        }
        System.out.println("MainDec of Cards after playerA and playerB taken 5 cards: " + mainDec);
        System.out.println(mainDec.size());
        System.out.println("Player A's initial 5 cards: " + playerA);
        System.out.println("Player B's initial 5 cards: " + playerB);
        int round = 1;
        while(mainDec.size()!=0){
            
            if(round %2 != 0 ){
                app.game(playerA, playerB);
                playerA.add(mainDec.get(0));
                mainDec.remove(0);
                System.out.println(mainDec.size());

                int limit = 5 - playerB.size();

                for(int i=0; i<limit; i++){
                    playerB.add(mainDec.get(i));
                    mainDec.remove(i);
                }
                System.out.println(mainDec.size());

                System.out.println("Updated player A's dec after round-"+round+": " + playerA);
                System.out.println("Updated player B's dec after round-"+round+": " + playerB);
                System.out.println("Updated Main Dec of cards after round-"+round+": " + mainDec);
            }
            else{
                app.game(playerB, playerA);
                playerB.add(mainDec.get(0));
                mainDec.remove(0);
                System.out.println(mainDec.size());

                int limit = 5 - playerA.size();

                for(int i=0; i<limit; i++){
                    playerA.add(mainDec.get(i));
                    mainDec.remove(i);
                }
                System.out.println(mainDec.size());

                System.out.println("Updated player B's dec after round-"+round+": " + playerB);
                System.out.println("Updated player A's dec after round-"+round+": " + playerA);
                System.out.println("Updated Main Dec of cards after round-"+round+": " + mainDec);
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


