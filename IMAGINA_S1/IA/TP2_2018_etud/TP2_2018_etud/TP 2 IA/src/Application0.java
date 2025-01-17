import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import structure.Atom;
import structure.FactBase;
import structure.KnowledgeBase;
import structure.Rule;
import structure.RuleBase;


public class Application0 {
	public static void main(String[] args) throws IOException
	{
		// creation de la base de faits de 2 facons differentes
		FactBase bf = new FactBase("P");
		bf.addAtomWithoutCheck(new Atom("Q"));
		System.out.println("Base de faits initiale :\n"+bf);
	
		// creation de la base de regles
		RuleBase br = new RuleBase();
		br.addRule(new Rule("P;S"));
		br.addRule(new Rule("Q;S;R"));
		System.out.println("Base de regles :\n"+br);
		
		String fileName = "TD5exo4.txt" ; // nom du fichier
		System.out.println("Chargement du fichier : "+
		new java.io.File( "." ).getCanonicalPath()+ "/" + fileName);
		BufferedReader readFile = new BufferedReader(new FileReader (fileName));
		
		KnowledgeBase kn = new KnowledgeBase(readFile);
		System.out.println(kn.toString());
	}
}
