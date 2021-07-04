package org.newstore.parsing;

@FunctionalInterface
public interface InputParser<T> {
	T parse(String input);
}
