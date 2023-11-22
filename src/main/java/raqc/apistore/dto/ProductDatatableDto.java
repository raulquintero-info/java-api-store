package raqc.apistore.dto;


import java.util.List;
import raqc.apistore.model.Product;



public class ProductDatatableDto {

	
	private List<Product> content;
	private Integer size; 			//recorsTotal
	private Integer TotalElements; //recordsFiltered
	
	
	
	public List<Product> getContent() {
		return content;
	}
	public void setContent(List<Product> content) {
		this.content = content;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalElements() {
		return TotalElements;
	}
	public void setTotalElements(Integer totalElements) {
		TotalElements = totalElements;
	}
	
	
	
	
	
	
}
