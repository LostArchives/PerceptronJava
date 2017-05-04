package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Neurone;
import model.Perceptron;

public class PerceptronTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Perceptron p = new Perceptron();
		//p.pointGen(50);
		Neurone n = new Neurone("apprentissage.txt",50);
		n.launchNeurone(100);
		
	}
		
	

}
