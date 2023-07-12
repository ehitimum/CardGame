

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> mainDec = new ArrayList<>();
        ArrayList<Integer> playerA = new ArrayList<>();
        ArrayList<Integer> playerB = new ArrayList<>();

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        mainDec.addAll(Arrays.asList(elements));
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
        System.out.println("Original ArrayList: " + mainDec);
        System.out.println(mainDec.size());
        System.out.println("New ArrayList 1: " + playerA);
        System.out.println("New ArrayList 2: " + playerB);
        int count1 = 0, count2 = 0;

        Random random = new Random();
        int randomIndex = random.nextInt(playerA.size());
        Integer ranelement = playerA.get(randomIndex);
        System.out.println("Random Element: " + ranelement);
        ArrayList<Integer> elementsToRemove = new ArrayList<>();
        ArrayList<Integer> elementsToRemove2 = new ArrayList<>();
        ArrayList<Integer> removedPairIndices = new ArrayList<>();

        Iterator<Integer> iterator = playerB.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            int firstElement = iterator.next();

            // Iterate again starting from the next element
            Iterator<Integer> secondIterator = playerB.listIterator(index + 1);
            int innerIndex = index + 1;
            while (secondIterator.hasNext()) {
                int secondElement = secondIterator.next();

                // Check if the sum of two elements is equal to the random element
                if (firstElement + secondElement == ranelement) {
                    // Remove the three elements from both ArrayLists
                    count1++;
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

        if (elementsToRemove2.isEmpty() && elementsToRemove.isEmpty()) {
            count2++;
        }

        if(elementsToRemove2.isEmpty()==false){
            playerA.remove(randomIndex);
        }
        
        playerB.removeAll(elementsToRemove);
        // if(removedPairIndices.isEmpty()==false){
        //     playerB.remove(removedPairIndices.get(0));
        //     playerB.remove(removedPairIndices.get(1));            
        // }


        // Print the updated ArrayLists
        System.out.println("Updated ArrayList 1: " + playerA);
        System.out.println("Updated ArrayList 2: " + playerB);
        System.out.println("Player A points: " + count1 + " Player B points: " + count2);
        System.out.println("Removed pair indices: " + removedPairIndices);
    }
}


