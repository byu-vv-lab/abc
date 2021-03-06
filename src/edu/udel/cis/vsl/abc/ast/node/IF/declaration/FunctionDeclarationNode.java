package edu.udel.cis.vsl.abc.ast.node.IF.declaration;

import edu.udel.cis.vsl.abc.ast.entity.IF.Function;
import edu.udel.cis.vsl.abc.ast.node.IF.SequenceNode;
import edu.udel.cis.vsl.abc.ast.node.IF.type.FunctionTypeNode;

/**
 * <p>
 * A node representing a function declaration. This includes a function
 * prototype as well as a function definition.
 * </p>
 * 
 * <p>
 * The children include: (0) an identifier node, the name of the function; (1) a
 * type node which is the type of the function (necessarily a function type),
 * and (2) a contract node for the function contract, which may be
 * <code>null</code>.
 * </p>
 * 
 * <p>
 * A C function declaration may contain addition specifiers (e.g.,
 * <code>_Noreturn</code>). These specifiers are represented by boolean fields
 * in this node; they do not require additional children nodes.
 * </p>
 * 
 * @author siegel
 * 
 */
public interface FunctionDeclarationNode extends OrdinaryDeclarationNode {

	@Override
	Function getEntity();

	/**
	 * Does the declaration include the <code>inline</code> function specifier?
	 * 
	 * @return <code>true</code> iff declaration contains <code>inline</code>
	 * @see #setInlineFunctionSpecifier(boolean)
	 */
	boolean hasInlineFunctionSpecifier();

	/**
	 * Set the inline function specifier bit to the given value.
	 * 
	 * @param value
	 *            if <code>true</code>, says that this function declaration
	 *            contains the <code>inline</code> specifier, if
	 *            <code>false</code>, it doesn't
	 * @see #hasInlineFunctionSpecifier()
	 */
	void setInlineFunctionSpecifier(boolean value);

	/**
	 * Does the declaration include the <code>_Noreturn</code> function
	 * specifier?
	 * 
	 * @return <code>true</code> iff declaration contains <code>_Noreturn</code>
	 * @see #setNoreturnFunctionSpecifier(boolean)
	 */
	boolean hasNoreturnFunctionSpecifier();

	/**
	 * Sets the <code>_Noreturn</code> bit to the given value.
	 * 
	 * @param value
	 *            if <code>true</code>, says that this function declaration
	 *            contains the <code>_Noreturn</code> specifier, if
	 *            <code>false</code>, it doesn't
	 * @see #hasNoreturnFunctionSpecifier()
	 */
	void setNoreturnFunctionSpecifier(boolean value);
	
	/**
	 * Does the declaration include the <code>__global__</code> Cuda function specifier?
	 * 
	 * @return <code>true</code> iff declaration contains <code>__global__</code>
	 * @see #setInlineFunctionSpecifier(boolean)
	 */
	boolean hasGlobalFunctionSpecifier();

	/**
	 * Set the global function specifier bit to the given value.
	 * 
	 * @param value
	 *            if <code>true</code>, says that this function declaration
	 *            contains the <code>__global__</code> specifier, if
	 *            <code>false</code>, it doesn't
	 * @see #hasInlineFunctionSpecifier()
	 */
	void setGlobalFunctionSpecifier(boolean value);

	/**
	 * Returns the contract node for this function declaration. May be
	 * <code>null</code>. It is a child node of this node.
	 * 
	 * @return the contract node child of this node
	 * @see #setContract(SequenceNode)
	 */
	SequenceNode<ContractNode> getContract();

	/**
	 * Sets the contract node child of this node to the given node.
	 * 
	 * @param contract
	 *            the contract node to be made a child of this node
	 * @see #getContract()
	 */
	void setContract(SequenceNode<ContractNode> contract);

	@Override
	FunctionDeclarationNode copy();

	@Override
	FunctionTypeNode getTypeNode();

}
