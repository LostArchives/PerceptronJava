package test;

import model.Neurone;
import model.NeuroneController;
import model.Perceptron;

public class PerceptronTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Perceptron p = new Perceptron(100);
		Neurone n = new Neurone("apprentissage.txt",p);
		
		NeuroneController nc = new NeuroneController(n);
		
		nc.testNeurone(0.01, 100 , 100);
		
		nc.testNeurone(0.1, 100 , 100);
		
		nc.testNeurone(0.2, 100 , 100);
		
		nc.createPerceptronData(1000);
		
		nc.testNeurone(0.01, 1000,100);
		
		nc.testNeurone(0.1,1000,100);
		
		nc.testNeurone(0.2, 1000, 1000);
		
		nc.testNeurone(0.5, 1000, 1000);
		
		nc.writeResults();

	}
	
}
