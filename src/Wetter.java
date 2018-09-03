import java.io.*;

//mit java Wetter "Datei-Pfad" soll das Programm ausgeführt werden, welches
//die minimale Temperatur in Spalte MnT und die maximale Temperatur in Spalte MxT stehen hat.
//Ausgabe ist die Zeile mit der Größten Spanne.

public class Wetter{
	
public static void main (String[] args) {

	String pfadName = args[0];

// dateiEinlesenUndMaxSpanne(String dName, String sMin, String sMax)
dateiEinlesenUndMaxSpanne neueDatei = new dateiEinlesenUndMaxSpanne(pfadName, "MnT", "MxT");

//neueDatei.maxSpanneAusgeben(pfadname);
//neueDatei.ueberschriftenEinlesen(pfadname);
//neueDatei.spaltenFinden(pfadname, "MnT", "MxT");
//neueDatei.maxSpanneAnschauen(pfadname,"MnT","MxT");
neueDatei.maxSpanneAusgeben(pfadName, "MnT", "MxT");
}
	
}