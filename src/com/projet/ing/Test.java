package com.projet.ing;

import com.projet.ing.entities.EtudiantServices;

public class Test {

	public static void main(String[] args) {
		EtudiantServices es=new EtudiantServices();
		long res=es.conecter("etudiant", "etudiant");
		System.out.println(res);
	}

}
