import java.util.Random;

import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.Styler;
import javax.swing.*;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;



public class QSortWrapper
{
    List<Integer> myList;
    int anzZahlen;
    Random randomGenerator;

    /**
     * Konstruktor für Objekte der Klasse QSortWrapper
     */
    public QSortWrapper()
    {
        myList = new List<Integer>();
        anzZahlen = 0;
        randomGenerator = new Random();
    }

    public void testQSortOnce()
    {
        List<Integer> tmpList = new List<Integer>();
        tmpList.concat( myList );
        myList = qSort( tmpList, 0 );
    }
    public void testeQSortChart(int lb_anzahlElemente, 
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
                    myList = qSort( myList, 0 );    
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
    
    public List<Integer> qSort( List<Integer> unsortedList, int rekLevel )
    {
        List<Integer> sortedList = new List<Integer>();
        List<Integer> listeA = new List<Integer>();
        List<Integer> listeB = new List<Integer>();
        List<Integer> sortedListA;
        List<Integer> sortedListB;
        
        System.out.println("Aufruf qSort, Rekursion Stufe: " + rekLevel);
        listeDrucken( unsortedList );
        
        // 0. Rekursion abbrechen, wenn
        // - ein Elemente in der Liste: Liste mit diesem Element zurückgeben
        if( laengeEZoderMehr( unsortedList ) == 0 ) {
            return sortedList;
        }
        else if( laengeEZoderMehr( unsortedList ) == 1 ) {
            unsortedList.toFirst();
            sortedList.append( unsortedList.getContent() );
        }else if( laengeEZoderMehr( unsortedList ) == 2 ){
        // - zwei Elemente in der Liste: Elemente sortiert in die Liste und Liste zurückgeben
            unsortedList.toFirst();
            int a = unsortedList.getContent();
            unsortedList.next();
            int b = unsortedList.getContent();
            if( a <= b ){
                sortedList.append( a );
                sortedList.append( b );
            }else{
                sortedList.append( b );
                sortedList.append( a );
            }
        
        }
        else{ // 1. zufälliges Element auswählen: pivot-Element
            unsortedList.toFirst();
            int pivot = unsortedList.getContent();
            unsortedList.remove();
            System.out.println("qSort: pivot=" + pivot);
            
        // 2. Partionieren der Liste: Zwei Listen:
            while( ! unsortedList.isEmpty() ){
                unsortedList.toFirst();
                int tmpElement = unsortedList.getContent();
                unsortedList.remove();
                
                if( tmpElement <= pivot ){
                // Liste A: alle Elemente kleiner als pivot-Element
                    listeA.append( tmpElement );
                }else{
                // Liste B: alle Elemente groesser als pivot-Element
                    listeB.append( tmpElement );
                }
            }
            // 3. Rekursion: qSort auf Liste A und Liste B
            sortedListA = qSort( listeA, rekLevel + 1 );
            System.out.println("qSort: ListA sortiert: ");
            listeDrucken( sortedListA );
                
            sortedListB = qSort( listeB, rekLevel + 1 );
            System.out.println("qSort: ListB sortiert: ");
            listeDrucken( sortedListB );
                          
            // sortierteListe ist: Liste A + pivot-Element + Liste B
            sortedList.concat( listeA );
            sortedList.append( pivot );
            sortedList.concat( listeB );
            System.out.println("qSort: sortedList sortiert: Rekursionsstufe: " + rekLevel);
            listeDrucken( sortedList );
        }
        return sortedList;
    }
    
    public int laengeEZoderMehr( List<Integer> aList )
    {
        int retVal = 0;
        aList.toFirst();
        
        if( aList.hasAccess() ){
            retVal = 1;
        }
        aList.next();
        if( aList.hasAccess() ){
            retVal = 2;
        }
        aList.next();
        if( aList.hasAccess() ){
            retVal = 3;
        }
        
        return retVal;
        
        
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

    public void myListDrucken(  )
    {
        listeDrucken( myList );
    }
    
    public void listeDrucken( List<Integer> aList  )
    {
        aList.toFirst();
        while( aList.hasAccess() == true ){
            System.out.print(aList.getContent() + ", ");
            aList.next();
        }
        System.out.println("*");
    }
}
