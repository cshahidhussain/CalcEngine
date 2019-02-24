package io.github.cshahidhussain.calcengine;

/**
 * Created by bboyko on 7/12/16.
 */
public class Divider extends CalculateBase {
  public Divider(){};
  public Divider(double leftVal, double rightVal){
    super(leftVal, rightVal);
  }
  @Override
  public void calculate() {
    double value = (getRightVal() == 0) ? 0.0 : (getLeftVal() / getRightVal());
    setResult(value);
  }
}
