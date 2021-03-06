package github.cshahidhussain.calcEngine;
import github.cshahidhussain.myapp.CalculateHelper;
import github.cshahidhussain.myapp.MathEquation;
import github.cshahidhussain.myapp.CalculateBase;
import github.cshahidhussain.myapp.Adder;
import github.cshahidhussain.myapp.Divider;
import github.cshahidhussain.myapp.Subtracter;
import github.cshahidhussain.myapp.Multiplier;
import github.cshahidhussain.myapp.InvalidStatementException;

public class Main {

  public static void main(String[] args) {

    MathEquation[] equations = new MathEquation[4];
    equations[0] = new MathEquation('d', 100.0d, 50.0d);
    equations[1] = new MathEquation('a', 25.0d, 92.0d);
    equations[2] = new MathEquation('s', 225.0d, 17.0d);
    equations[3] = new MathEquation('m', 11.0d, 3.0d);

    for (MathEquation equation: equations){
      equation.execute();
      System.out.print("result = ");
      System.out.println(equation.getResult());
    }

    double leftDouble = 9.0d;
    double rightDouble = 4.0d;

    System.out.println();
    System.out.println("Using Overloads");
    System.out.println();

    int leftInt = 9;
    int rightInt = 4;

    MathEquation equationOverload = new MathEquation('d');
    equationOverload.execute(leftDouble, rightDouble);
    System.out.println("result= ");
    System.out.println(equationOverload.getResult());

    equationOverload.execute(leftInt, rightInt);
    System.out.println("result= ");
    System.out.println(equationOverload.getResult());

    System.out.println();
    System.out.println("Using Inheritance");
    System.out.println();

    CalculateBase[] calculators = {
            new Divider(100.0d, 50.0d),
            new Adder(25.0d, 92.0d),
            new Subtracter(225.0d, 17.0d),
            new Multiplier(11.0d, 3.0d)
    };

    for (CalculateBase calculator:calculators){
        calculator.calculate();
        System.out.print("Result=");
        System.out.println(calculator.getResult());
    }

    String[] statements = {
        "add 1.0",
        "add xx 100.0",
        "addX 0.0 0.0",
        "divide 100.0 50.0",
        "add 25.0 92.0",
        "subtract 225.0 17.0",
        "multiply 11.0 3.0"
    };

      CalculateHelper helper = new CalculateHelper();
        for(String statement: statements){
          try {
            helper.process(statement);
            System.out.println(helper);
          } catch (InvalidStatementException e){
            System.out.println(e.getMessage());
            if (e.getCause() != null) {
              System.out.println("   Original exception:" + e.getCause().getMessage());
            }
          }
      }
  }
}