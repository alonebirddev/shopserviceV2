package com.acsk.shop.exception;

public class ShopException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ShopException() {
        super();
    }

    public ShopException(String msg) {
        super(msg);
    }

    public ShopException(Throwable throwable) {
        super(throwable);
    }

    public ShopException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
