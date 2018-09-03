import java.io.*;

//mit java Fussball "Datei-Pfad" soll das Programm ausgeführt werden, welches
//die Tore in Spalte Goals und die Gegentoren in Spalte Goals Allowed stehen hat.
//Ausgabe ist das Team (Eintrag der ersten Spalte) mit der Größten Spanne.


public class Fussball {

	public static void main(String[] args) {
		
		String pfadName = args[0];

		// dateiEinlesenUndMaxSpanne(String dName, String sMin, String sMax)
		dateiEinlesenUndMaxSpanneAbsName neueDatei = 
				new dateiEinlesenUndMaxSpanneAbsName(pfadName, "Goal", "Goals Allowed", false);

		//neueDatei.maxSpanneAusgeben(pfadname);
		//neueDatei.ueberschriftenEinlesen(pfadname);
		//neueDatei.spaltenFinden(pfadname, "Goals", "Goals Allowed");
		
		//höchste Anzahl an Toren minus Gegentore
		//neueDatei.maxSpanneAusgeben(pfadname,"Goals","Goals Allowed");
		
		//höchste Anzahl an Toren minus Gegentore
		//neueDatei.maxSpanneAusgeben(pfadname, "Goals", "Goals Allowed",false);
		
		//absolute Tordifferenz
		neueDatei.maxSpanneAusgeben(pfadName, "Goals", "Goals Allowed",true);
		}
	}
