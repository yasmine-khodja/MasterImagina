package csp_etud;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

/* (non-Javadoc)
 *  Choix de codage :
 *		Variable = String
 *      Valeur = Object
 *		un domaine = ArrayList<Object>
 *
 *  un réseau de contrainte (X,D,C) est représenté par :
 * 		- X les variables et D les domaines sont représentés par un ensemble de 
 *		couples (variable,domaine) utilisant une HashMap<String,ArrayList<Object>>
 *		- C les contraintes est une simple liste de contraintes : ArrayList<Constraint>
 *
 *  On pourra, pour optimiser la structure d'un réseau de contraintes, ajouter
 * une HashMap (variable, liste de contraintes) qui permet d'associer à
 * chaque variable la liste des contraintes qui portent sur elle.
 *
*/
/**
 * Structure de manipulation d'un r�seau de contraintes (X,D,C)
 *
 */
public class Network {
	
	private HashMap<String,ArrayList<Object>> varDom; // associe � chaque variable de X un domaine de D
	private ArrayList<Constraint> constraints; // l'ensemble de contraintes C
	
	/**
	 * Construit un r�seau de contraintes sans variable (ni contrainte)
	 */
	public Network() {
		varDom = new HashMap<String,ArrayList<Object>>();
		constraints = new ArrayList<Constraint>();
	}

	/**
	 * Construit un r�seau de contraintes � partir d'une repr�sentation textuelle au 
	 * format :
	 * <p> nombre de variables
	 * <p> nom de la variable 1 ; val1 ; val2 ; ...
	 * <p> nom de la variable 2 ; val1 ; val2 ; ...
	 * <p> ...
	 * <p> nombre de contraintes
	 * <p> type de la contrainte 1   (pour l'instant uniquement 'ext')
	 * <p> nom de la 1i�re variable de la contrainte 1 ; nom de la 2nde var de la contrainte 1 ; ...
	 * <p> nombre de tuples de valeurs pour cette contrainte 
	 * <p> val1 ; val2 ; ...
	 * <p> val1 ; val2 ; ... 
	 * <p> type de la contrainte 2   (pour l'instant uniquement 'ext')
	 * <p> nom de la 1i�re variable de la contrainte 2 ; nom de la 2nde var de la contrainte 2 ; ...
	 * <p> nombre de tuples de valeurs pour cette contrainte 
	 * <p> val1 ; val2 ; ...
	 * <p> val1 ; val2 ; ... 
	 * <p> ...
	 * 
	 * @param in le buffer de lecture de la repr�sentation textuelle de la contrainte
	 * @throws Exception en cas de probl�me dans l'analyse textuelle
	 */
	public Network(BufferedReader in) throws Exception {
		varDom = new HashMap<String,ArrayList<Object>>();
		constraints = new ArrayList<Constraint>();
		// Les variables et domaines
		int nbVariables = Integer.parseInt(in.readLine());		// le nombre de variables
		for(int i=1;i<=nbVariables;i++) {
			String[] varDeclaration = in.readLine().split(";"); // Var;Val1;Val2;Val3;...
			ArrayList<Object> dom = new ArrayList<Object>();
			varDom.put(varDeclaration[0], dom);
			for(int j=1;j<varDeclaration.length;j++) dom.add(varDeclaration[j]);
		}
		// Les contraintes
		int nbConstraints = Integer.parseInt(in.readLine());	// le nombre de contraintes
		for(int k=0;k<nbConstraints;k++) {
			Constraint c = null;
			String type = in.readLine().trim();					// le type de la contrainte 
			if (type.equals("ext")) c = new ConstraintExt(in);
			// else if(type.equals("AUTRE TYPE")) c = new ConstraintTYPE(in)
			else if(type.equals("dif")) c = new ConstraintDif(in);
			else if(type.equals("eq")) c = new ConstraintEq(in);
			else if(type.equals("exp")) c = new ConstraintExp(in);
			else
				{
				System.out.println(type);
				System.err.println("Type contrainte inconnu");
				}
				
			addConstraint(c);
		}
	}
		
	/**
	 * Ajoute une nouvelle variable dans le r�seau avec un domaine vide
	 * (ne fait rien si la variable existe d�j� : message d'avertissement)
	 * 
	 * @param var la variable � ajouter
	 */
	public void addVariable(String var) {
		if(varDom.get(var)==null) varDom.put(var, new ArrayList<Object>());
		else System.err.println("Variable " + var + " deja existante");
	}

	/**
	 * Ajoute une nouvelle valeur au domaine d'une variable du r�seau
	 * 
	 * @param var la variable � laquelle il faut ajouter la valeur
	 * @param val la valeur � ajouter
	 */
	public void addValue(String var, Object val) {
		if(varDom.get(var)==null) System.err.println("Variable " + var + " non existante");
		else {
			ArrayList<Object> dom = varDom.get(var);
			if (!dom.add(val)) // add retourne vrai si la valeur �tait effectivement nouvelle
				System.err.println("La valeur " + val + " est d�j� dans le domaine de la variable " + var); 
		}
	}
	
	/**
	 * Ajoute une contrainte dans le r�seau. Les variables de la
	 * contrainte doivent d�j� exister dans le r�seau.
	 * 
	 * @param c la contrainte � ajouter
	 */
	public void addConstraint(Constraint c) {		
		// Attention !! On ne v�rifie pas que les valeurs des contraintes sont "compatibles" avec les domaines
		if(!varDom.keySet().containsAll(c.getVars())) // si l'une des variables de la contrainte n'existe pas dans le r�seau
			System.err.println("La contrainte " + c.getName() + " contient des variables (" + c.getVars()
					+ ") non d�clar�es dans le CSP dont les variables sont " + varDom.keySet());
		else constraints.add(c);
	}
	
	/**
	 * Retourne le nombre de variables du r�seau
	 * 
	 * @return le nombre de variables
	 */
	public int getVarNumber() {
		return varDom.size();
	}

	/**
	 * Retourne la taille du domaine d'une variable du r�seau.
	 * 
	 * @param var la variable dont on veut conna�tre la taille de son domaine
	 * @return le nombre de valeurs de Dom(var)
	 */
	public int getDomSize(String var) {
		return varDom.get(var).size();
	}
	
	/**
	 * Retourne le nombre de contraintes du r�seau
	 * 
	 * @return le nombre de contraintes
	 */
	public int getConstraintNumber(){
		return constraints.size();
	}
	
	/**
	 * Retourne la liste des variables du r�seau
	 * 
	 * @return la liste des variables
	 */
	public ArrayList<String> getVars() {
		return new ArrayList<String>(varDom.keySet());
	}

	/**
	 * Retourne le domaine d'une variable
	 * 
	 * @param var la variable dont on veut le domaine
	 *  @return la liste des valeurs du domaine d'une variable
	 */
	public ArrayList<Object> getDom(String var) {
		return varDom.get(var);
	}
	

	/**
	 * Retourne la liste des contraintes du r�seau
	 * 
	 * @return la liste des contraintes
	 */
	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}
	
	/**
	 * Retourne la liste des contraintes du r�seau contenant une
	 * certaine variable 
	 * 
	 * @param var la variable dont on veut connaitre les contraintes
	 * @return la liste des contraintes contenant var
	 */
	public ArrayList<Constraint> getConstraints(String var) {						
		ArrayList<Constraint> selected = new ArrayList<Constraint>();
		for(Constraint c : constraints)
			if(c.getVars().contains(var)) selected.add(c);
		return selected;											
	}																		
	
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Var et Dom : " + varDom + "\nConstraints :" + constraints;
	}
	
	public static void main(String[] args){
		Network monCSP = new Network();
		System.out.println("Exemple de creation d'un CSP bidon avec quelques erreurs de cr�ation \n");
		// les variables
		String v1 = new String("x");
		String v2 = new String("y");
		String v3 = new String("z");
		monCSP.addVariable(v1);
		monCSP.addVariable(v2);
		monCSP.addVariable(v3);
		monCSP.addVariable("x");
		// les domaines
		monCSP.addValue(v1,1);
		monCSP.addValue(v1,2);
		monCSP.addValue(v1,3);
		monCSP.addValue(v2,"toto");
		monCSP.addValue(v2,"tutu");
		monCSP.addValue(v3,2);
		monCSP.addValue(v3,4);
		monCSP.addValue(v3,6);
		monCSP.addValue(v3,0);
		monCSP.addValue(v3,2);
		// les contraintes
		ArrayList<String> varTuple;
		ArrayList<Object> valTuple;
		// c1 : <x,y> : <2,"if"> <2,"as">,<4,"tutu">
		varTuple= new ArrayList<String>(2);
		varTuple.add(0,"x") ;
		varTuple.add(1,"y") ;
		ConstraintExt c1 = new ConstraintExt(varTuple);
		valTuple = new ArrayList<Object>(2);
		valTuple.add(0,2);
		valTuple.add(1,"tutu");
		c1.addTuple(valTuple);
		valTuple = new ArrayList<Object>(2);
		valTuple.add(0,2);
		valTuple.add(1,"toto");
		c1.addTuple(valTuple);
		valTuple = new ArrayList<Object>(2);
		valTuple.add(0,4);
		valTuple.add(1,"tutu");
		c1.addTuple(valTuple);
		monCSP.addConstraint(c1);  

		// c2 : <y,x,z> : <"as",1,3> <"toto",3,5>
		varTuple= new ArrayList<String>(3);
		varTuple.add(0,"y") ;
		varTuple.add(1,"x") ;
		varTuple.add(2,"z") ;
		ConstraintExt c2 = new ConstraintExt(varTuple);
		valTuple = new ArrayList<Object>(3);
		valTuple.add(0,"toto");
		valTuple.add(1,1);
		valTuple.add(2,3);
		c2.addTuple(valTuple);
		valTuple = new ArrayList<Object>(3);
		valTuple.add(0,"toto");
		valTuple.add(1,3);
		valTuple.add(2,5);
		c2.addTuple(valTuple);
		valTuple = new ArrayList<Object>(2);
		valTuple.add(0,6);
		valTuple.add(1,"tutu");
		c2.addTuple(valTuple);
		valTuple = new ArrayList<Object>(3);
		valTuple.add(0,"toto");
		valTuple.add(1,1);
		valTuple.add(2,3);
		c2.addTuple(valTuple);
		monCSP.addConstraint(c2);
		
		//c3 : <w> : <1> <2>
		varTuple= new ArrayList<String>(1);
		varTuple.add(0,"w") ;
		ConstraintExt c3 = new ConstraintExt(varTuple);
		valTuple = new ArrayList<Object>(1);
		valTuple.add(0,1);
		c3.addTuple(valTuple);
		valTuple = new ArrayList<Object>(1);
		valTuple.add(0,2);
		c3.addTuple(valTuple);
		monCSP.addConstraint(c3);

		System.out.println("\nMon r�seau de contraintes (les entr�es incorrectes ayant �t� ignor�es) :\n" + monCSP);
	}
	
}

