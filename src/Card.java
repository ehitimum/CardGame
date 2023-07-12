public interface Card{
    // void maincards(Integer[] elements){
    //     ArrayList<Integer> mainDec = new ArrayList<>();
    //     mainDec.addAll(Arrays.asList(elements));
    //     System.out.println("Original Main Dec of Cards: "+mainDec);
    //     System.out.println(mainDec.size());
    //     Collections.shuffle(mainDec);
    // }
    public void maincards(Integer[] elements);

    public void playerA();

    public void playerB();
}
