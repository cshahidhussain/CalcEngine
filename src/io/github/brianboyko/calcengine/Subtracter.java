package io.github.brianboyko.calcengine;

/**
 * Created by bboyko on 7/12/16.
 */
public class Subtracter extends CalculateBase {
  public Subtracter(){}
  public Subtracter(double leftVal, double rightVal){
    super(leftVal, rightVal);
  }
  @Override
  public void calculate() {
    setResult(getLeftVal() - getRightVal());
  }
}
