package de.letsbuildacompiler.compiler;

public enum DataType {
	INT("I"), STRING("Ljava/lang/String;");
	
	private final String jvmType;
	
	private DataType(String jvmType) {
		this.jvmType = jvmType;
	}
	
	public String getJvmType() {
		return jvmType;
	}
}
