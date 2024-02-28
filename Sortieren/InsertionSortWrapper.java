public class InsertionSortWrapper
{
    List<Integer> myList;
    
    /**
     * Konstruktor für Objekte der Klasse InsertionSortWrapper
     */
    public InsertionSortWrapper()
    {
        myList = new List<Integer>();

    }

    
    public void insertionSort()
    {
        List<Integer> sortedList = new List<Integer>();
        int aktuelleZahl = -1;
        
        while( ! myList.isEmpty() ){
            myList.toFirst();
            
            aktuelleZahl = myList.getContent();
            
            sortedList.toFirst();
            // while( ){
            
            // }
        }
    }
}
