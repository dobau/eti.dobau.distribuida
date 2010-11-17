package com.dobau.threads;

public interface BufferFinito<T> {

	public T pull();

	public void push(T obj);

}
