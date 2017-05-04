package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Neurone {

	private double _biais;
	private int _sortie;
	private double[] _poids;
	
	private String _exempleFile;
	private  String[] _exemples;
	
	private int _nbErreurs = 0;
	
	final double PAS_APPRENTISSAGE = 0.01;
	
	public Neurone(String fileName,int nbExample) {
		_biais = 0.5;
		_sortie = 0;
		initPoids(2);
		_exempleFile = fileName;
		_exemples = new String[nbExample];
		readFile();
		_nbErreurs = 0;
	}
	
	public int calcTeta(String _exemple) {
		double teta = 0;
		double[] exemple = parseExemple(_exemple);
		
		for (int i = 0 ;i<_poids.length; i++ ) {
			teta+= _poids[i] * exemple[i];
		}
		teta-=_biais;
		if (teta>0) 
			_sortie = 1;
		else
			_sortie = -1;
		
		if (_sortie!=exemple[exemple.length - 1]) {
			majNeurone(_exemple);
			_nbErreurs++;
		}
			
		return _sortie;
	}
	
	public void launchNeurone(int nbIteration) {
		System.out.println("Lancement du neurone...");
		for (int i =0 ; i< nbIteration;i++) {
			System.out.println("Itération n°" + (i+1));
			_nbErreurs = 0;
			for (int j = 0 ; j < _exemples.length;j++) {
				calcTeta(_exemples[j]);
			}
			System.out.println("Nombre d'erreurs : " + _nbErreurs);	
		}
	}
	
	
	private void majNeurone(String _exemple) {
		double[] exemple = parseExemple(_exemple);
		_biais = _biais + PAS_APPRENTISSAGE * (exemple[exemple.length - 1] - _sortie) * (-0.5);
		for (int i = 0; i<_poids.length;i++) {
			_poids[i] += PAS_APPRENTISSAGE * (exemple[exemple.length - 1] - _sortie) * exemple[i];
		}
	}
	
	
	private void readFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(_exempleFile)))
		{
			String sCurrentLine="";
			int cnt = 0;
			
			while ((sCurrentLine=br.readLine()) != null) {
				_exemples[cnt] = sCurrentLine;
				cnt++;
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initPoids(int taille) {
		_poids = new double[taille];
		for (int i = 0 ; i< taille;i++) {
			_poids[i] = Math.random();
		}
		
	}
	
	private double[] parseExemple(String exemple) {
		String[] _elements = exemple.split(" ");
		double[] parsed = new double[3];
		for (int i = 0 ; i< parsed.length;i++) {
			parsed[i] = Double.parseDouble(_elements[i]);
		}
		return parsed;
	}
	
	
}
