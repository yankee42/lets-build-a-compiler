package de.letsbuildacompiler.compiler;

public class Variable {
  private final String name;
  private final DataType type;
  private final int index;

  public Variable(final String name, final DataType type, final int index) {
    this.name = name;
    this.type = type;
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public DataType getType() {
    return type;
  }

  public int getIndex() {
    return index;
  }
}
