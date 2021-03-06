package edu.udel.cis.vsl.abc.astgen.c.IF;

import edu.udel.cis.vsl.abc.front.c.parse.IF.ParseTree;

/**
 * This factory produces new {@link PragmaHandler}s. Each {@link PragmaHandler}
 * is used to translate pragma nodes occurring in a single {@link ParseTree}.
 * 
 * @author siegel
 * 
 */
public interface PragmaFactory {

	/**
	 * Reurns the {@link ASTBuilder} affiliated to this pragma factory. There is
	 * a 1-1 correspondence between pragma factories and AST builders. The two
	 * classes work together and are tightly coupled.
	 * 
	 * @return the affiliated AST builder
	 */
	ASTBuilder getASTBuilder();

	/**
	 * Returns a new handler specified by the given pragma identifier (code),
	 * for working on pragmas occurring in the given parse tree. Example codes
	 * are "omp" and "CIVL". The handler can be used repeatedly on different
	 * pragmas, as long as they all occur in the same parse tree.
	 * 
	 * @param code
	 *            the identifier specifying the pragma domain, such as "omp"
	 *            (for OpenMP)
	 * 
	 * @param parseTree
	 *            the parse tree representing the translation unit in which the
	 *            pragmas occur
	 * @return a new handler for translating pragmas in that tree
	 */
	PragmaHandler newHandler(String code, ParseTree parseTree);

}
