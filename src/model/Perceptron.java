package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Perceptron {
	
	private int _nbPoints;
	
	public Perceptron(int nbPoint) {
		_nbPoints = nbPoint;
		writeResults(_nbPoints);
	}
	
	public int getNbPoint() {
		return _nbPoints;
	}
	
	public String pointGen(int nbPoint) {
			String data = "";
			
			for (int i = 0 ; i< nbPoint;i++) {
				double point1 = Math.random();
				double point2 = Math.random();
				
				if (point1 + point2 - 1 > 0) {
					data += point1 + " " + point2 + " 1\n";
				}
				else {
					data += point1 + " " + point2 + " -1\n";
				}
			}
			
			return data;
		}
		
		public void writeResults(int nbPoint) {
			_nbPoints = nbPoint;
			String f1_data = pointGen(nbPoint);
			String f2_data = pointGen(nbPoint);
			PrintWriter out;
			PrintWriter out2;
			try {
				out = new PrintWriter("apprentissage.txt");
				out.write(f1_data);
				out.close();
				out2 = new PrintWriter("validation.txt");
				out2.write(f2_data);
				out2.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
