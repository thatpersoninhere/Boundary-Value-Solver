/*
Daniel Riggs
CSCI 3321
November 7 2015
Assignment 3 - Runge Kutta
Eclipse on Windows 10
RungeKutta.java
the program solves an ODE
there is no input
should run with java
output is a command line series of numbers
no postconditions
algorithm
	3rd order runge kutta solver for different step sizes 
	*/
import java.lang.*;

public class RungeKutta {

	public static void main(String[] args) {		
		double h = 1;
		double j = 30;
		do{
			double x = 1;
			double t = 0;
			double dir;
			double alpha1;
			double alpha2;
			double x1;
			double x2;
			double x3; 
			for(int i=0; i < j; i++){
				dir = dxdt(x,t);
				alpha1 = 1/3;
				alpha2 = 2/3;
				x1 = x + h * alpha1 * dir;
				x2 = x + h * (dir/2 + dir/6);
				x3 = x + h * ((2.5 * dxdt(x,t)) - (4.5 * dxdt(x1,t+alpha1*h)) + 3 * dxdt(x2,t+alpha2*h));
				t = t + h;
				x = x3;
			}
			System.out.println("Step Size: " + h );
			System.out.println("Solution Found: " + x);
			System.out.println("At Point : " + t);
			System.out.println("\n Next Iteration");
			h = h/2;
			j = j*2;
		}while(j <= 1920);
	}
	public static double dxdt (double x, double t)
	{
		double dxdt = x * Math.cos(t + x);
		return dxdt;	
	}
}
