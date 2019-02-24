package io.github.cshahidhussain.calcengine;

/**
 * Created by brianboyko on 8/29/16.
 */
public class InvalidStatementException extends Exception {
  public InvalidStatementException(String reason, String statement) {
    super(reason + ": " + statement);
  }
  public InvalidStatementException(String reason, String statement, Throwable cause) {
    super(reason + ": " + statement, cause);
  }
}
