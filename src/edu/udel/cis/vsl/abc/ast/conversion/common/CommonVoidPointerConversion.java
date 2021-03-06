package edu.udel.cis.vsl.abc.ast.conversion.common;

import edu.udel.cis.vsl.abc.ast.conversion.IF.VoidPointerConversion;
import edu.udel.cis.vsl.abc.ast.type.IF.PointerType;

public class CommonVoidPointerConversion extends CommonConversion implements
		VoidPointerConversion {

	public CommonVoidPointerConversion(PointerType type1, PointerType type2) {
		super(type1, type2);
	}

	@Override
	public PointerType getOldType() {
		return (PointerType) super.getOldType();
	}

	@Override
	public PointerType getNewType() {
		return (PointerType) super.getNewType();
	}

	@Override
	public String toString() {
		return "VoidPointer" + super.toString();
	}

	@Override
	public ConversionKind conversionKind() {
		return ConversionKind.VOID_POINTER;
	}

}
