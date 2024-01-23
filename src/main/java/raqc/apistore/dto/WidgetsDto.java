package raqc.apistore.dto;

public class WidgetsDto {

	Long totalProducts;
	Long totalCustomers;
	Long totalOrders;
	
	
	
	
	public WidgetsDto() {
		super();
	}




	public Long getTotalProducts() {
		return totalProducts;
	}




	public void setTotalProducts(Long totalProducts) {
		this.totalProducts = totalProducts;
	}




	public Long getTotalCustomers() {
		return totalCustomers;
	}




	public void setTotalCustomers(Long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}




	public Long getTotalOrders() {
		return totalOrders;
	}




	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}




	@Override
	public String toString() {
		return "WidgetsDto [totalProducts=" + totalProducts + ", totalCustomers=" + totalCustomers + ", totalOrders="
				+ totalOrders + "]";
	}
	
	
	
	
	
}
