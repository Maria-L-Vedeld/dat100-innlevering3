package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File fil = new File(mappe, filnavn);
		Blogg blogg = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(fil))) {

			int antallInnlegg = Integer.parseInt(reader.readLine().trim());
			blogg = new Blogg(antallInnlegg);

			for (int i = 0; i < antallInnlegg; i++) {
				String type = reader.readLine().trim();

				if (TEKST.equals(type)) {
					int id = Integer.parseInt(reader.readLine().trim());
					String bruker = reader.readLine().trim();
					String dato = reader.readLine().trim();
					int likes = Integer.parseInt(reader.readLine().trim());
					String tekst = reader.readLine().trim();

					Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(innlegg);

				} else if (BILDE.equals(type)) {
					int id = Integer.parseInt(reader.readLine().trim());
					String bruker = reader.readLine().trim();
					String dato = reader.readLine().trim();
					int likes = Integer.parseInt(reader.readLine().trim());
					String tekst = reader.readLine().trim();
					String url = reader.readLine().trim();

					Bilde Innlegg = new Bilde(id, bruker, dato, likes, tekst, url);

					blogg.leggTil(Innlegg);
				}
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Feil: Filen ble ikke funnet - " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil - " + e.getMessage());

		} catch (NumberFormatException e) {

			System.out.println("Kunne ikke konvertere tall fra filen - " + e.getMessage());
		}
		return blogg;

	}
}