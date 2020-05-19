package com.macys.survey.model;

public class CustomerFeedRating {

	private String overallRating;
	private String productAvailability;
	private String searchProducts;
	private String completProducts;
	private String issue;
	private String comment;
	private String name;
	private String email;
	private String base64;
	
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}
	public String getProductAvailability() {
		return productAvailability;
	}
	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}
	public String getSearchProducts() {
		return searchProducts;
	}
	public void setSearchProducts(String searchProducts) {
		this.searchProducts = searchProducts;
	}
	public String getCompletProducts() {
		return completProducts;
	}
	public void setCompletProducts(String completProducts) {
		this.completProducts = completProducts;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
