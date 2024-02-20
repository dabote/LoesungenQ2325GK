import java.util.Random;
import java.util.Arrays;

/**
 * Beschreiben Sie hier die Klasse LineareSuche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BinaereSucheWrapper
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int[] arrayZahlen;
    Random randomGenerator;
    int anzZahlen;
    /**
     * Konstruktor für Objekte der Klasse LineareSuche
     */
    public BinaereSucheWrapper(int pAnzahlZahlen)
    {
        anzZahlen=pAnzahlZahlen;
        arrayZahlen = new int[anzZahlen];
        randomGenerator = new Random();
        
    }
    
    public void testeBinaereSucheRekursiv( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            binaereSucheRekursivStart( randomGenerator.nextInt(10000) );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit binäre Suche rekursiv: " + anzZahlen + " Elemente, " + anzahlVersuche + " Versuche, " + (timeEnd - timeStart) + " Millisek.");

    }
            
            

    public void listeFuellen( )
    {      
        for( int i = 0; i<anzZahlen; i++ ){
            arrayZahlen[i] = randomGenerator.nextInt(10000);
        }
        Arrays.sort( arrayZahlen );
    }

    public void listeDrucken( )
    {
        for( int i = 0; i<anzZahlen; i++ ){
            System.out.println( arrayZahlen[i] );
        }
    }
    
    public boolean binaereSucheRekursivStart(int i )
    {
        return binaereSucheRekursiv( i, 0, anzZahlen );
    }
    
    public boolean binaereSucheRekursiv(int i, int lowerBound, int upperBound)
    {
        // idx berechnen
        //int idx = 
        
        // Abbruch der Suche
        // if(  ){
            // return false;
        // }
        
        // // Pruefen ob gefunden
        // if(  ){
            // return true;
        // }
        // // gesuchte Zahl ist kleiner als idx-Zahl
        // else if(  ){
            // return binaereSucheRekursiv( );
        // }
        // // gesuchte Zahl ist größer als idx-Zahl
        // else{
            // return binaereSucheRekursiv( );
        // }
       
        return false;
        
    }
    
    
}
