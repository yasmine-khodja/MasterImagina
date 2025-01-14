package csp_etud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		if(args.length>0){
			
			String fileName = args[0] ; // nom du fichier
			Network myNetwork;
			System.out.println("Chargement du fichier : "+ new java.io.File( "." ).getCanonicalPath()+ "/" + fileName);
			BufferedReader readFile = new BufferedReader(new FileReader (fileName));
			myNetwork = new Network(readFile);
			readFile.close();
			System.out.println(myNetwork);
			CSP csp = new CSP(myNetwork);
			
			switch(args[0]) {
			case("csp1.txt"): System.out.println("Problème csp1:");break;
			case("csp2.txt"): System.out.println("Problème csp2:");break;
			case("5reines.txt"): System.out.println("Problème 5reines:");break;
			case("8reines.txt"): System.out.println("Problème 8reines:");break;
			case("colore.txt"): System.out.println("Problème colore:");break;
			case("5reinesExp.txt"): System.out.println("Problème 5reinesExp:");break;
			case("cryptoMoney.txt"): System.out.println("Problème cryptoMoney:");break;
			case("cryptoMoneyIntension.txt"): System.out.println("Problème cryptoMoneyIntention:");break;
			}
			System.out.println("SeachSol:");
			Assignment fS = csp.searchSolution();
			System.out.println(fS);
			System.out.println(csp.cptr + " noeuds ont générés");
			System.out.println("SearchAllSoutions :" );
			ArrayList<Assignment> allS = csp.searchAllSolutions();
			System.out.println(allS.size() + " solutions");
			for(Assignment a : allS) System.out.println(a);
			System.out.println(csp.cptr + " noeuds ont générés");
			
	}else System.err.println("Aucun CSP entr�");	
	}

}
