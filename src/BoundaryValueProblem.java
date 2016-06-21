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

public class BoundaryValueProblem{

	public static void main(String[] args) {		
		System.out.println(Secs(.7, 1.0, .001));
		System.out.println(RKDFire(Secs(.7, 1.0, .001)));
		System.out.println(RKDFire(Secs(.7, 1.0, .001)) + Secs(.7, 1.0, .001) - 3);
		}
	
	public static double RKDFire(double x0)
	{
		double h = .025;
		double j = 40;
		double t = 0;
		double dir;
		double alpha1;
		double alpha2;
		double x1;
		double x2;
		double x3; 
		for(int i=0; i < j; i++){
			dir = dxdt(t, x0);
			alpha1 = 1/3;
			alpha2 = 2/3;
			x1 = x0 + h * alpha1 * dir;
			x2 = x0 + h * (dir/2 + dir/6);
			x3 = x0 + h * ((2.5 * dxdt(t, x0)) - (4.5 * dxdt(t+alpha1*h, x1)) + 3 * dxdt(t+alpha2*h, x2));
			t = t + h;
			x0 = x3;
		}
		return x0;
	}
	public static double dxdt (double t, double x)
	{
		double dxdt = x + 0.09 * x * x + Math.cos(10 * t);
		return dxdt;	
	}
	public static double BC(double x)
	{
		double y = x + RKDFire(x) - 3;
		return y;
	}
	public static double Secs(double a, double b, double ERR)
	{
		double x;
		do
		{
			x = b - (BC(b) * ((b - a) / (BC(b) - BC(a))));
			a = b;
			b = x; 
		} while((Math.abs(a - b)>ERR));
		return b;
	}
}


