package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		File fil = new File(mappe, filnavn);
		
		try ( PrintWriter writer = new PrintWriter(fil)){
			writer.print(samling.toString());
			return true;
		}catch (FileNotFoundException e) {
			System.out.println("Filen kunne ikke skrives - " + e.getMessage());
			return false;
		}
	}
}
