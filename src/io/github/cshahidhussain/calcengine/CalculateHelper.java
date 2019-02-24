package io.github.cshahidhussain.calcengine;

/**
 * Created by bboyko on 7/13/16.
 */
public class CalculateHelper {
  private static final char ADD_SYMBOL = '+';
  private static final char SUBTRACT_SYMBOL = '-';
  private static final char MULTIPLY_SYMBOL = '*';
  private static final char DIVIDE_SYMBOL = '/';
  MathCommand command;
  double leftValue;
  double rightValue;
  double result;

  public void process(String statement) throws InvalidStatementException {
    // "add 1.0 2.0"
    String[] parts = statement.split(" ");
    if(parts.length != 3){
      throw new InvalidStatementException("Incorrect number of fields", statement);
    }
    try {
      leftValue = Double.parseDouble(parts[1]);
      rightValue = Double.parseDouble(parts[2]);
    } catch (NumberFormatException e) {
      throw new InvalidStatementException("Non-numeric data", statement, e);
    }

    command = setCommandFromString(parts[0]);
    if(command == null){
      throw new InvalidStatementException("Invalid Command", statement);
    }

    CalculateBase calculator = null;
    switch (command) {
      case Add:
        calculator = new Adder(leftValue, rightValue);
        break;
      case Subtract:
        calculator = new Subtracter(leftValue, rightValue);
        break;
      case Multiply:
        calculator = new Multiplier(leftValue, rightValue);
        break;
      case Divide:
        calculator = new Divider(leftValue, rightValue);
        break;
    }

    calculator.calculate();
    result = calculator.getResult();

  }


  private MathCommand setCommandFromString(String commandString){
    if (commandString.equalsIgnoreCase(MathCommand.Add.toString())){
      return MathCommand.Add;
    } else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString())){
      return MathCommand.Subtract;
    } else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
      return MathCommand.Multiply;
    } else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
      return MathCommand.Divide;
    } else {
      return null;
    }
  }

  @Override
  public String toString(){
    // 1.0 + 2.0 = 3.0
    char symbol = ' ';
    switch(command){
      case Add:
        symbol = ADD_SYMBOL;
        break;
      case Subtract:
        symbol = SUBTRACT_SYMBOL;
        break;
      case Multiply:
        symbol = MULTIPLY_SYMBOL;
        break;
      case Divide:
        symbol = DIVIDE_SYMBOL;
        break;
      default:
        System.out.println("Error - something broke");
    }

    StringBuilder sb = new StringBuilder(20);
    sb.append(leftValue);
    sb.append(' ');
    sb.append(symbol);
    sb.append(' ');
    sb.append(rightValue);
    sb.append(" = ");
    sb.append(result);

    return sb.toString();

  }

}
