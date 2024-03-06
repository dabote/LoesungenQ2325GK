    import java.util.Random;

import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.Styler;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.QuickChart;


public class InsertionSortWrapper
{
    List<Integer> myList;
    int anzZahlen;
    Random randomGenerator;

    /**
     * Konstruktor für Objekte der Klasse InsertionSortWrapper
     */
    public InsertionSortWrapper()
    {
        myList = new List<Integer>();
        anzZahlen = 0;
        randomGenerator = new Random();
    }

    public void testeChart()
    {
            double[] xData = new double[1000];
            double[] yData = new double[1000];
 
            for( int i=0; i<1000; i++ ){
                
            }
            
    // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
 
    // Show it
        new SwingWrapper(chart).displayChart();
    }
    
        public void insertionSort()
    {
        // Ausgabeliste erzeugen!
        List<Integer> sortedList = new List<Integer>();
        int aktuelleZahl = -1;
        
        // Die gesamte Eingabeliste durchlaufen.
        while( ! myList.isEmpty() ){
            // Zeiger der Eingabeliste auf das erste Element
            // stellen.
            myList.toFirst();
            
            // Das erste Element aus der Eingabeliste entnehmen!
            aktuelleZahl = myList.getContent();
            
            sortedList.toFirst();
            // Bis zur richtigen Stelle in der Ausgabeliste laufen.
            while(   sortedList.hasAccess()
                  && sortedList.getContent() < aktuelleZahl ){
            
                sortedList.next();
            }
            
            // Wenn noch nicht am Ende der Liste:
            // Element an der entsprechendend Stelle einfuegen
            if( sortedList.hasAccess() ){
                sortedList.insert( aktuelleZahl );
            }
            // Die Liste ist komplett durchlaufen worden,
            // also am Ende das Element anhängen!
            else{
                sortedList.append( aktuelleZahl );
            }
            
            // Das Element aus der Eingabeliste entnehmen.
            myList.remove();
            
        }
        // Die Eingabelist wird zur sortierten Liste
        myList = sortedList;
    }
    
    public void listeFuellen( int anzElemente )
    {
        anzZahlen = anzElemente;
        myList.toFirst();
        while( ! myList.isEmpty() ){
            myList.remove();
        }
        for( int i = 0; i<anzElemente; i++ ){
            myList.append( randomGenerator.nextInt(10000) );
        }
    }

    public void listeDrucken( )
    {
        myList.toFirst();
        while( myList.hasAccess() == true ){
            System.out.println(myList.getContent());
            myList.next();
        }
    }
}
