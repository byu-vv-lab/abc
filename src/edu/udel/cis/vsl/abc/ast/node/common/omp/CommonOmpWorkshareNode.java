package edu.udel.cis.vsl.abc.ast.node.common.omp;

import java.io.PrintStream;

import edu.udel.cis.vsl.abc.ABCRuntimeException;
import edu.udel.cis.vsl.abc.ast.node.IF.ASTNode;
import edu.udel.cis.vsl.abc.ast.node.IF.omp.OmpWorksharingNode;
import edu.udel.cis.vsl.abc.ast.node.IF.statement.StatementNode;
import edu.udel.cis.vsl.abc.token.IF.Source;

public class CommonOmpWorkshareNode extends CommonOmpStatementNode implements
		OmpWorksharingNode {

	protected OmpWorksharingNodeKind ompWorkshareKind;

	/**
	 * Creates a new instance of OpenMP worksharing node with a specific kind.
	 * 
	 * @param source
	 *            The source code element of the node.
	 * @param kind
	 *            The worksharing kind of the node, either FOR,
	 *            SECTIONS/SECTION, or SINGLE.
	 */
	public CommonOmpWorkshareNode(Source source, OmpWorksharingNodeKind kind,
			StatementNode statement) {
		super(source, statement);
		this.ompStatementKind = OmpStatementNodeKind.WORKSHARE;
		this.ompWorkshareKind = kind;
	}

	@Override
	public OmpWorksharingNode copy() {
		OmpWorksharingNode newWorkshareNode = new CommonOmpWorkshareNode(
				this.getSource(), this.ompWorkshareKind, null);
		int numChildren = this.numChildren();

		for (int i = 0; i < numChildren; i++) {
			ASTNode child = this.child(i);

			if (child != null) {
				newWorkshareNode.setChild(i, child.copy());
			}
		}
		return newWorkshareNode;
	}

	@Override
	public OmpWorksharingNodeKind ompWorkshareNodeKind() {
		return this.ompWorkshareKind;
	}

	@Override
	protected void printBody(PrintStream out) {
		switch (this.ompWorkshareKind) {
		case SECTIONS:
			out.print("OmpSections");
			break;
		case SECTION:
			out.print("OmpSection");
			break;
		case SINGLE:
			out.print("OmpSingle");
			break;
		default:
			throw new ABCRuntimeException("Unreachable");
		}
	}

}
