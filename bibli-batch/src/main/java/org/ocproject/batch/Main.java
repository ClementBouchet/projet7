package org.ocproject.batch;

import generated.ouvrage.Ouvrage;
import generated.ouvrage.OuvrageManager;
import generated.ouvrage.OuvrageManagerImpl;
//This file can't be found by Eclipse when we try to run it for reason so you must use the other project called "batch"
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuvrageManager ouvrageMngr = new OuvrageManager();
		
		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		
		Ouvrage ouvrage = null;
		ouvrage = ouvrageManager.readInfoUser(2);
		
		if(ouvrage != null)
		System.out.println("Bonjour, Mr."+ouvrage.getIdEmprunteur()+"vous devez rendre voutre ouvrage le : " + ouvrage.getDateRetour());

		else {
			System.out.println("ouvrage null");
		}
	}

}
