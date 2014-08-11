package edu.udel.cis.vsl.abc.ast.node.common.expression;

import java.io.PrintStream;

import edu.udel.cis.vsl.abc.ast.node.IF.IdentifierNode;
import edu.udel.cis.vsl.abc.ast.node.IF.expression.EnumerationConstantNode;
import edu.udel.cis.vsl.abc.token.IF.Source;

public class CommonEnumerationConstantNode extends CommonConstantNode implements
		EnumerationConstantNode {

	public CommonEnumerationConstantNode(Source source, IdentifierNode name) {
		super(source, name.name());
		addChild(name);
	}

	@Override
	public IdentifierNode getName() {
		return (IdentifierNode) child(0);
	}

	@Override
	public void setName(IdentifierNode name) {
		setChild(0, name);
	}

	@Override
	protected void printBody(PrintStream out) {
		out.print("EnumerationConstantNode");
	}

	@Override
	public EnumerationConstantNode copy() {
		return new CommonEnumerationConstantNode(getSource(),
				duplicate(getName()));
	}

	@Override
	public ConstantKind constantKind() {
		return ConstantKind.ENUM;
	}
}
