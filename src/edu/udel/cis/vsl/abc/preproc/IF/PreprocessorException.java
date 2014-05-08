package edu.udel.cis.vsl.abc.preproc.IF;

import org.antlr.runtime.Token;

import edu.udel.cis.vsl.abc.err.ABCException;

public class PreprocessorException extends ABCException {

	/**
	 * Eclipse made me do it.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Token where error occurred. May be null. If non-null, a few words
	 * describing it are appended to the message.
	 */
	private Token token;

	public PreprocessorException(String msg, Token token) {
		super(msg);
		this.token = token;
	}

	public PreprocessorException(String msg) {
		super(msg);
	}

	public Token getToken() {
		return token;
	}

	@Override
	public String toString() {
		String result = "Preprocessor error: " + super.getMessage();

		if (token != null)
			result += "\nAt " + token;
		return result;
	}

}
