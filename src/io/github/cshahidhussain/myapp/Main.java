package io.github.cshahidhussain.myapp;

import io.github.cshahidhussain.calcengine.Adder;
import io.github.cshahidhussain.calcengine.Subtracter;
import io.github.cshahidhussain.calcengine.Multiplier;
import io.github.cshahidhussain.calcengine.Divider;
import io.github.cshahidhussain.calcengine.CalculateBase;
import io.github.cshahidhussain.calcengine.CalculateHelper;
import io.github.cshahidhussain.calcengine.MathEquation;
import io.github.cshahidhussain.calcengine.InvalidStatementException;

import static java.lang.Math.random;

public class Main {

  public static void main(String[] args) {
//    useMathEquation();
//    useInheritance();


    String[] statements = {
            "add 1.0", // Error: Incorrect # of values
            "add xx 25.0", // Error: NAN
            "addX 0.0 0.0", // error, invalid command.
            "divide 100.0 50.0", // -> 100.0 / 50.0 = 2.0
            "add 25.0 92.0", // -> 25.0 + 92.0 = 117.0
            "subtract 225.0 17.0", // -> 225.0 - 17.0 = 108.0
            "multiply 11.0 3.0" // -> 11.0 * 3.0 = 33.0
    };

    CalculateHelper helper = new CalculateHelper();
    for(String statement:statements) {
      try {
        helper.process(statement);
        System.out.println(helper);
      } catch(InvalidStatementException e) {
        System.out.println(e.getMessage());
        if(e.getCause() != null){
          System.out.println("  Original Exception: " + e.getCause().getMessage());
        }
      }
    }

  }



  static void useMathEquation(){
    MathEquation[] equations = new MathEquation[9];
    System.out.println(getRandom(3));
    equations[0] = new MathEquation(100.0d, 50.0d, 'd');
    equations[1] = new MathEquation(25.0d, 92.0d, 'a');
    equations[2] = new MathEquation(225.0d, 17.0d, 's');
    equations[3] = new MathEquation(11.0d, 3.0d, 'm');
    equations[4] = new MathEquation(99.0d, 33.0d);
    equations[5] = new MathEquation(666.6d);
    {
      for (int i = 6; i < equations.length; i++){
        equations[i] = new MathEquation(getRandom(6), getRandom(8), 'a');
      }
    }
    for (MathEquation equation : equations){
      equation.execute();
      System.out.print("result = ");
      System.out.println(equation.getResult());
      equation.execute(1.0d, 2.0d);
      System.out.print("result = ");
      System.out.println(equation.getResult());
    }
  }

  static void useInheritance(){
    System.out.println();
    System.out.println("Using Inheritance");
    System.out.println();

    CalculateBase[] calculators = {
            new Divider(100.0d, 50.0d),
            new Adder(25.0d, 92.0d),
            new Multiplier(11.0d, 3.0d),
            new Subtracter(225.0d, 17.0d)
    };

    for(CalculateBase calculator:calculators){
      calculator.calculate();
      System.out.println("result = " + calculator.getResult());
    }
  }



  private static double getRandom(int max){
    return random() * max;
  }
}
