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
            
    public void testeBinaereSucheIterativ( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            binaereSucheIterativ( randomGenerator.nextInt(10000) );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit binäre Suche iterativ: " + anzZahlen + " Elemente, " + anzahlVersuche + " Versuche, " + (timeEnd - timeStart) + " Millisek.");

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
        int idx = (int)(lowerBound + upperBound ) / 2;
        
        // Abbruch der Suche
        if( lowerBound > upperBound || idx == anzZahlen ){
            return false;
        }
        
        // Pruefen ob gefunden
        if( arrayZahlen[idx] == i ){
            //System.out.println( "Nicht gefunden: Anzahl Schritte: " + anzahlSchritte);
            return true;
        }
        // gesuchte Zahl ist kleiner als idx-Zahl
        else if( i < arrayZahlen[idx] ){
            return binaereSucheRekursiv(i, lowerBound, idx-1 );
        }
        // gesuchte Zahl ist größer als idx-Zahl
        else{
            return binaereSucheRekursiv(i, idx+1, upperBound);
        }
        
              
        
    
    }
    
    
    public boolean binaereSucheIterativ(int i)
    {
        int lowerBound = 0;
        int upperBound = anzZahlen;
        int idx = -2;
        int anzahlSchritte = 0;
                
        while( true ){
            anzahlSchritte++;
            // idx berechnen
            idx = (int)( (lowerBound + upperBound ) / 2 );
            
            // Suche abbrechen
            if( (lowerBound > upperBound) || (idx == anzZahlen) ){
                //System.out.println( "Nicht gefunden: Anzahl Schritte: " + anzahlSchritte);
                return false;
            // Wenn gesuchtes Element < arrayZahlen[idx] -> links suchen            
            }else if( i < arrayZahlen[idx] ){
                // lowerBound bleibt unverändert
                upperBound = idx - 1;
            // Wenn gesuchtes Element < arrayZahlen[idx] -> links suchen
            }else if( i > arrayZahlen[idx] ){
                lowerBound = idx + 1;
                // upperBound bleibt unverändert
            }else{ // i == arrayZahlen
                 //System.out.println( "Gefunden!!: Anzahl Schritte: " + anzahlSchritte);
                 return true;
            }
            
        }
    }
    
    
}
