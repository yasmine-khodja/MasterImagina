package structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnowledgeBase {
	private FactBase bf;
	private RuleBase rl;
	private FactBase bf2;
	
	public KnowledgeBase(){
		bf = new FactBase();
		rl = new RuleBase();
		bf2 = new FactBase();
	}
	
	public KnowledgeBase(BufferedReader in) throws IOException{
		this();
		
		String s = in.readLine();
		
		
		while (s!= null) // arrêt si fin de fichier ou ligne lue vide
		{
			Rule r = new Rule(s);
			rl.addRule(r);
			bf.addAtoms(r.getHypothesis());
			
			s = in.readLine();
		}
		
		System.out.print(bf.toString());
		
	}
	
	public void forwardChaining(){
		
	}
	
	public FactBase getBf(){
		return(bf);
	}
	
	public RuleBase getRl(){
		return(rl);
	}
	
	public String toString(){
		return (bf.toString() + rl.toString());
	}

}
