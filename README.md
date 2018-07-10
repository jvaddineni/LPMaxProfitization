# LPMaxProfitization

Problem Statement : 

      To find optimum number of apples and oranges to maximize the profit of fruit seller under below constraints .

      1) fruit cart capacity is 100 kgs 
      2) weight of one apple is 5 kg
      3) weight of one orange is 3kg
      4) buying and selling price of apple is 10 and 15 $ respectively 
      5) buying and selling price of orange is 6 and 8 $ respectively 

Solution : 

      Solved the problem using Linear progrmming max profitization methodology and constrains derived from above requirements are 
      
      a indicates no of apples , o indicates number of oranges
      
      1) 5a + 3o <= 100 --------constraint c1 is defined to take max weight of the basket into consideration
      2) a >= 0 --------------constraint c2 is a non negative constraint
      3) o >= 0 --------------constraint c3 is a non negative constraint 
      
      Objective Function to determine max profitization is 5 * a + 2 * b = P 

Program : 

      Utilized SCPSolver.jar to solve linear programming max profitization problem.
      
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
      
  Console Output  : 
  
            GLPK Simplex Optimizer, v4.65
            3 rows, 2 columns, 4 non-zeros
            *     0: obj = -0.000000000e+000 inf =  0.000e+000 (2)
            *     2: obj =  1.000000000e+002 inf =  0.000e+000 (0)
            OPTIMAL LP SOLUTION FOUND
            x1: 20.0
            x2: 0.0
 
 MAX Profit : 
 
 solution is max profit can be achieved by selling all apples i.e. 20 apples each of 5$ totalling to 100$
