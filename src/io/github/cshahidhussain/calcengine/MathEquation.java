package io.github.cshahidhussain.calcengine;

/**
 * Created by brianboyko on 7/10/16.
 */
public class MathEquation {

  private double leftVal = 0.0d;
  private double rightVal = 0.0d;
  private char opCode = 'a';
  private double result;

  public MathEquation(){
  }

  public MathEquation(double leftVal){
    this.leftVal = leftVal;
  }

  public MathEquation(double leftVal, double rightVal){
    this(leftVal);
    this.rightVal = rightVal;
  }
  public MathEquation(double leftVal, double rightVal, char opCode){
    this(leftVal, rightVal);
    this.opCode = opCode;
  }

  public void execute(){
    switch (opCode) {
      case 'a':
        result = leftVal + rightVal;
        break;
      case 's':
        result = leftVal - rightVal;
        break;
      case 'd':
        result = (rightVal == 0.0) ? 0.0 : leftVal / rightVal;
        break;
      case 'm':
        result = leftVal * rightVal;
        break;
      default:
        System.out.println("Error - Invalid opcode");
        result = 0.0d;
        break;
    }
  }
  public void execute(double leftVal, double rightVal){
    this.leftVal = leftVal;
    this.rightVal = rightVal;
    execute();
  }

  public double getResult(){
    return this.result;
  }

  public double getLeftVal() {return leftVal;}
  public double getRightVal() {return rightVal;}
  public char getOpCode(){return opCode;}
  public void setLeftVal(double leftVal) {this.leftVal = leftVal;}
  public void setRightVal(double rightVal) {this.rightVal = rightVal;}
  public void setOpCode(char opCode) { this.opCode = opCode; }

}
