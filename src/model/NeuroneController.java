package model;

public class NeuroneController {

	private Neurone _n;
	private String _results;
	
	public NeuroneController(Neurone n) {
		_n = n;
		_results = "";
	}
	
	public Neurone getNeurone() {
		return _n;
	}
	
	public void setNeurone(Neurone n) {
		_n = n;
	}
	
	public void createPerceptronData(int nbResults) {
		_n.createPerceptronData(nbResults);
	}
	
	public void testNeurone(double nbPas,int nbIteration , int _nbtestIteration) {
		
		int _bestIteration = 10000;
		_n.resetNeurone();
		_n.setPas(nbPas);
		String _currentResult = "";
		String _bestResult = "";
		
		for (int k=0;k<_nbtestIteration;k++) {
			
			_currentResult = _n.launchNeurone(nbIteration);
			
			if (_bestIteration > _n.getNbIteration() && _n.getNbIteration() > 1) {
				_bestResult = _currentResult;
				_bestIteration = _n.getNbIteration();
				
			}
			
			if (_n.getNbIteration()==1)
				break;
				
		}
		
		_results += _bestResult;
		
	}
	
	public void writeResults() {
		FileWriter f = new FileWriter("results.txt");
		f.Write(_results);
	}
	
}
