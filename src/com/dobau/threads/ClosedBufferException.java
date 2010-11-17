package com.dobau.threads;

public class ClosedBufferException extends RuntimeException {

	private static final long serialVersionUID = -3608225274193511901L;

	public ClosedBufferException() {
		super("Buffer fechado.");
	}

}
