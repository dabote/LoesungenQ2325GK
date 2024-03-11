import java.util.Random;

import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.Styler;
import javax.swing.*;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;



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

    public void testeInsertionSortChart(int lb_anzahlElemente, 
                                        int ub_anzahlElemente,
                                        int versuchePerDurchlauf,
                                        int schrittweite)
    {
            int anzVersuche = (int) (ub_anzahlElemente - lb_anzahlElemente + 1) / schrittweite;
            double[] xData = new double[anzVersuche];
            double[] yData = new double[anzVersuche];
            double[] yRefQuadrat = new double[anzVersuche];
            double[] yRefCubic = new double[anzVersuche];
            long timeStart;
            long timeEnd;
            
            for( int i=0; i<anzVersuche; i++ ){
                int aktuelleAnzahlElemente = lb_anzahlElemente + i*schrittweite;
                xData[i] = aktuelleAnzahlElemente;
                yData[i] = 0.0;
                yRefQuadrat[i] = 2.0 * (double)(aktuelleAnzahlElemente * aktuelleAnzahlElemente) / 1000000.0;
                yRefCubic[i] = (double) Math.pow(aktuelleAnzahlElemente / 1000.0, 2 );
            }

            
            // Create Chart
            XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Anz. Elemente").yAxisTitle("Zeit [ms]").build();
            chart.addSeries("f(n)=2*n**2", xData, yRefQuadrat);
            chart.addSeries("f(n)=n**2", xData, yRefCubic);
            chart.addSeries("Laufzeit", xData, yData);
 
            // Show it
            SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
            sw.displayChart();
            
            for( int i=0; i<anzVersuche; i++ ){
             
                int aktuelleAnzahlElemente = lb_anzahlElemente + i*schrittweite;
                listeFuellen( aktuelleAnzahlElemente );
                
                timeStart = System.currentTimeMillis();
                for( int j=0; j<versuchePerDurchlauf; j++){
                    insertionSort(  );    
                }
                timeEnd = System.currentTimeMillis();
    
                double timeLaps = (double) (timeEnd-timeStart) / (double) versuchePerDurchlauf;
                System.out.println("InsertionSort: " + aktuelleAnzahlElemente + " Elemente, " + timeLaps + "ms");

                
                xData[i] = aktuelleAnzahlElemente;
                yData[i] = timeLaps;
            
                chart.updateXYSeries("Laufzeit", xData, yData, null);
                sw.repaintChart();
            }
            

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
