package com.library.demo.controller.result;

/**
 * Different types of Results return by API
 * 
 */
public class Result {
	
	public static final Result SUCCESS = new Result(Status.SUCCESS); 
	public static final Result UPDATED = new Result(Status.UPDATED_SUCCESS); 
	public static final Result FAILURE = new Result(Status.FAILURE);
	public static final Result LIBRARY_NOT_FOUND = new Result(Status.LIBRARY_NOT_FOUND);
	public static final Result BOOK_NOT_FOUND = new Result(Status.BOOK_NOT_FOUND);
	
	private final Status status; 
	
	Result(Status  status)
	{
		this.status = status;
	}
	/**
	 * Get the current status of result
	 * @return
	 */
	public Status getStatus() {
		return status;
	}
}