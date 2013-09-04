package edu.udel.cis.vsl.abc.ast.entity.IF;

import edu.udel.cis.vsl.abc.ast.entity.IF.Entity.LinkageKind;
import edu.udel.cis.vsl.abc.ast.entity.IF.Scope.ScopeKind;
import edu.udel.cis.vsl.abc.ast.node.IF.ASTNode;
import edu.udel.cis.vsl.abc.ast.node.IF.declaration.EnumeratorDeclarationNode;
import edu.udel.cis.vsl.abc.ast.node.IF.declaration.FieldDeclarationNode;
import edu.udel.cis.vsl.abc.ast.node.IF.label.OrdinaryLabelNode;
import edu.udel.cis.vsl.abc.ast.type.IF.EnumerationType;
import edu.udel.cis.vsl.abc.ast.type.IF.ObjectType;
import edu.udel.cis.vsl.abc.ast.type.IF.StructureOrUnionType;
import edu.udel.cis.vsl.abc.ast.type.IF.Type;
import edu.udel.cis.vsl.abc.ast.value.IF.Value;

public interface EntityFactory {

	/**
	 * Creates a new scope.
	 * 
	 * @param kind
	 *            the kind of scope to create
	 * @param parent
	 *            the scope immediately containing the new scope; can be null
	 *            for the root scope
	 * @param root
	 *            an AST node to associate to the new scope; it is used only for
	 *            printing to make it easy for the reader to identify where the
	 *            scope comes from
	 * @return the new Scope
	 */
	Scope newScope(ScopeKind kind, Scope parent, ASTNode root);

	Variable newVariable(String name, LinkageKind linkage, Type type);

	Function newFunction(String name, LinkageKind linkage, Type type);

	StructureOrUnion newStructureOrUnion(StructureOrUnionType type);

	Enumeration newEnumeration(EnumerationType type);

	Enumerator newEnumerator(EnumeratorDeclarationNode declaration,
			EnumerationType type, Value value);

	Field newField(FieldDeclarationNode declaration, ObjectType type,
			Value bitWidth, StructureOrUnion structureOrUnion);

	Typedef newTypedef(String name, Type type);

	Label newLabel(OrdinaryLabelNode declaration);

	PragmaHandler newPragmaHandler(String name);

	/**
	 * Computes the join of the two scopes in the scope tree and returns it.
	 * 
	 * @param s1
	 *            non-null scope
	 * @param s2
	 *            non-null scope
	 * @return the youngest common ancestor of s1 and s2
	 */
	Scope join(Scope s1, Scope s2);

}
