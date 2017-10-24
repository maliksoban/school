package com.tss.exception;

/**
 * @author MalikSoban
 */
public class UserAlreadyExistException extends RuntimeException {

  private static final long serialVersionUID = 325671818133231L;

  private final String exceptionKey;

  public String getExceptionKey() {
    return exceptionKey;
  }

  public UserAlreadyExistException(final String exceptionKey) {
    this.exceptionKey = exceptionKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserAlreadyExistException that = (UserAlreadyExistException) o;

    return exceptionKey != null ? exceptionKey.equals(that.exceptionKey) : that.exceptionKey == null;
  }

  @Override
  public int hashCode() {
    return exceptionKey != null ? exceptionKey.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "UserAlreadyExistException{" +
            "exceptionKey='" + exceptionKey + '\'' +
            '}';
  }
}
