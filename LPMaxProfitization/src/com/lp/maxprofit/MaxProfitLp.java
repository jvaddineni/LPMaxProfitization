package com.lp.maxprofit;

import scpsolver.constraints.LinearBiggerThanEqualsConstraint;
import scpsolver.constraints.LinearSmallerThanEqualsConstraint;
import scpsolver.lpsolver.LinearProgramSolver;
import scpsolver.lpsolver.SolverFactory;
import scpsolver.problems.LinearProgram;

public class MaxProfitLp {

	public static void main(String[] args) {

		// objective function to define max profitization  5a + 2b = P 
		LinearProgram lp = new LinearProgram(new double[]{5.0,2.0}); 
		
		// weight constraint of the cart 5a + 2b = 100 
		lp.addConstraint(new LinearSmallerThanEqualsConstraint(new double[]{5.0,3.0}, 100.0, "c1")); 
		
		// a >= 0
		lp.addConstraint(new LinearBiggerThanEqualsConstraint(new double[]{0.0,1.0}, 0.0, "c2")); 
		
		// b >= 0
		lp.addConstraint(new LinearBiggerThanEqualsConstraint(new double[]{1.0,0.0}, 0.0, "c3")); 
		
		// indicating max profitization problem 
		lp.setMinProblem(false); 
		LinearProgramSolver solver  = SolverFactory.newDefault();
		
		// result indicating optimum number of apples / oranges to be selected for making max profit.
		double[] sol = solver.solve(lp);
		
		
	}

}
