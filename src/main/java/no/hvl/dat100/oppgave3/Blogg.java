package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteLedig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteLedig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteLedig < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}
		return false;
	}
	
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(nesteLedig).append("\n");
		
		for (int i = 0; i < nesteLedig; i++) {
			if (innleggtabell[i] != null) {
				sb.append(innleggtabell[i].toString());
			}
		}
		return sb.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}