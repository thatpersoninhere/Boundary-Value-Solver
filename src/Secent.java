/*
Daniel Riggs
CSCI 3321
October 7 2015
Assignment 2 - Secant Method
Eclipse on Windows 10
secant.java
the program calculates the root of a function
there is no input
should run with java
output is a command line series of numbers
no postconditions
algorithm
	take 2 estimates and applies the secent method on function f, which can easily be replaced with anything
		if the answer is within the margin of error
			return answer
		else repeat secant method with new parameters
*/
import java.lang.Math;

public class Secent {

	public static void main(String[] args) {
		double a = -1;					//starting perameters
		double b = 2;					
		double limit = 0.000000001;		//the error limit
		double t;						//the new perameter
		double fx = 1000000000;  // must have a starting point for fx so i picked an outragously large number
		int i = 0;		
		while(Math.abs(fx)>limit){							//loop and check function
			t = b - (((b - a) / (f(b) - f(a))) * f(b));      // secant method
			a = b;
			b = t;					//adjust new perameters
			fx = f(b);				//do function
			i++;                    // iteration counter
		}	
		double y = f(b); 			//needed a new variable to represent answer
		System.out.println("Iterations: " + i);                              
		System.out.println("Root Location: " + "(" + b + "," + y + ")" );
	}
	public static double f(double x){
		double fx = Math.tanh(x) - .5;   //function is moduler 
		return fx;
	}
}
