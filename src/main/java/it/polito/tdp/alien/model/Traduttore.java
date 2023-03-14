package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Traduttore {
	
	Map<String, Set<String>> dizionario = new TreeMap<String, Set<String>>();
	
	
	
	public Traduttore() {
	}



	public Map<String, Set<String>> getDizionario() {
		return dizionario;
	}



	public void setDizionario(Map<String, Set<String> > dizionario) {
		this.dizionario = dizionario;
	}



	public void inserisciParola(String alienese, String terrestre){
		
		String caratteriAmmessi="ABCDEFGHILMNOPQRSTUVZJYWXK";
		boolean corretta = true;
		
		for (char c : alienese.toUpperCase().toCharArray() ) {
			if (caratteriAmmessi.contains(Character.toString(c))==false){
				corretta = false;
			}
		}
		for (char c : terrestre.toUpperCase().toCharArray() ) {
			if (caratteriAmmessi.contains(Character.toString(c))==false){
				corretta = false;
			}
		}
		
		if (corretta) {
			if (this.dizionario.get(alienese)==null) {
				Set<String> set = new HashSet<String>();
				set.add(terrestre);
				this.dizionario.put(alienese.toLowerCase(), set);
			}
			else {
				this.dizionario.get(alienese).add(terrestre);
				
			}
		}
		
		else {throw new IllegalArgumentException("Caratte non valido");
		}
		
	}
	
	public Set<String> traduciParola(String alienese) {
		
		return this.dizionario.get(alienese);
	}

}
