package de.letsbuildacompiler.compiler;

public enum DataType {
  // BOOL ('i', "Z"),
  // BYTE ('i', "B"),
  // CHAR ('i', "C"),
  // SHORT ('i', "S"),
  INT ('i', "I"),
  LONG ('l', "J"),
  FLOAT ('f', "F"),
  DOUBLE ('d', "D"),
  STRING ('a', "Ljava/lang/String;");

  private final String jvmType;
  private final char load;

  private DataType(final char load, final String jvmType) {
    this.load = load;
    this.jvmType = jvmType;
  }

  public char getLoad() {
    return load;
  }

  public String getJvmType() {
    return jvmType;
  }
}
