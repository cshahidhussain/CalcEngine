package io.github.cshahidhussain.calcengine;

/**
 * Created by bboyko on 7/12/16.
 */
public abstract class CalculateBase {
  private double leftVal;
  private double rightVal;
  private double result;

  // setters and getters
  public double getLeftVal(){
    return this.leftVal;
  }
  public double getRightVal(){
    return this.rightVal;
  }
  public double getResult() {
    return this.result;
  }
  public void setLeftVal(double leftVal){
    this.leftVal = leftVal;
  }
  public void setRightVal(double rightVal){
    this.rightVal = rightVal;
  }
  public void setResult(double result){
    this.result = result;
  }

  public CalculateBase() {};
  public CalculateBase(double leftVal, double rightVal){
    this.leftVal = leftVal;
    this.rightVal = rightVal;
  }

  public abstract void calculate();
}
