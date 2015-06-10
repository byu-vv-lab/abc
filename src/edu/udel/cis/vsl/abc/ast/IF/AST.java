package edu.udel.cis.vsl.abc.ast.IF;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;

import edu.udel.cis.vsl.abc.ast.entity.IF.Entity;
import edu.udel.cis.vsl.abc.ast.entity.IF.Function;
import edu.udel.cis.vsl.abc.ast.entity.IF.OrdinaryEntity;
import edu.udel.cis.vsl.abc.ast.node.IF.ASTNode;
import edu.udel.cis.vsl.abc.ast.node.IF.SequenceNode;
import edu.udel.cis.vsl.abc.ast.node.IF.statement.BlockItemNode;
import edu.udel.cis.vsl.abc.token.IF.SourceFile;

/**
 * <p>
 * A representation of a program as an abstract syntax tree.
 * </p>
 * 
 * <p>
 * Each AST encompasses a set of AST nodes. Those nodes are "owned" by the AST.
 * A node can be owned by at most one AST. A node may also be free---not owned
 * by any AST.
 * </p>
 * 
 * <p>
 * The AST also methods to return the internal and external entities associated
 * to the AST.
 * </p>
 * 
 * <p>
 * With few exceptions, nodes owned by an AST cannot be modified. If you want to
 * modify them (for example, to implement an AST transformation), you first have
 * to "release" the AST using the method {@link #release}.
 * </p>
 * 
 * <p>
 * Note that an AST is a rooted tree. In particular, there is a unique path from
 * the root to any node in the tree.
 * </p>
 * 
 * @see Entity
 * @see ASTNode
 * 
 * @author siegel
 * 
 */
public interface AST {

	/**
	 * Returns the ASTFactory associated to this AST. This is the factory that
	 * was used to create the AST.
	 * 
	 * @return the ASTFactory responsible for creating this AST
	 */
	ASTFactory getASTFactory();

	/**
	 * Returns the root node of the abstract syntax tree.
	 * 
	 * @return the root node
	 */
	SequenceNode<BlockItemNode> getRootNode();

	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return the number of nodes in the tree
	 * */
	int getNumberOfNodes();

	/**
	 * Returns the node with the given id number. The id must lie between 0 and
	 * n-1, inclusive, where n is the number of nodes.
	 * 
	 * @return the node in this tree with the given id
	 */
	ASTNode getNode(int id);
	
	/**
	 * Returns the entity for the main function.  Returns null if standard analyses
	 * have yet to be performed.
	 * 
	 * @return the entity is the main function of the program
	 */
	Function getMain();
	void setMain(Function f);

	/**
	 * Pretty-prints the entire tree. This should be a human-readable
	 * representation.
	 * */
	void print(PrintStream out);

	/**
	 * Pretty-prints the entire tree, in the form of the original language.
	 * 
	 * @param out
	 *            the output stream for printing
	 * @param ignoreStdLibs
	 *            ignore standard libraries? If true, then
	 */
	void prettyPrint(PrintStream out, boolean ignoreStdLibs);

	/**
	 * Dissolves this AST. The nodes will be untouched, except they will become
	 * "free"--no longer owned by any AST. They can therefore be modified. Also
	 * nullifies the sets of internal/external entities associated to the AST.
	 */
	void release();

	/**
	 * If this AST contains an entity with internal or external linkage and with
	 * the given name, it is returned by this method, else this method returns
	 * null. The entity will be either a Function, Variable, or Typedef.
	 * 
	 * @param name
	 *            name of the entity
	 * @return the entity
	 */
	OrdinaryEntity getInternalOrExternalEntity(String name);

	/**
	 * Returns an iterator over all entities with internal linkage belonging to
	 * this AST.
	 * 
	 * @return entities with internal linkage
	 */
	Iterator<OrdinaryEntity> getInternalEntities();

	/**
	 * Returns an iterator over all entities with external linkage belonging to
	 * this AST.
	 * 
	 * @return entities with external linkage
	 */
	Iterator<OrdinaryEntity> getExternalEntities();

	/**
	 * Adds the given entity to this AST.
	 * 
	 * @param entity
	 *            an Entity with internal or external linkage
	 */
	void add(OrdinaryEntity entity);

	DifferenceObject diff(AST that);

	boolean equiv(AST that);

	void clearEntities();

	/**
	 * Gets the set of {@link SourceFile}s that formed the source for this AST.
	 * 
	 * @return the source file objects for this AST
	 */
	Collection<SourceFile> getSourceFiles();
}
