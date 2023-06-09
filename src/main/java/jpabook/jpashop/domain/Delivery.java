package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;
	
	// address valuetype
//	private String city;
//	private String street;
//	private String zipcode;
	
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
  
	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;
	
	/**
	 * delivery 객체와 order 객체 간 양방향 편의 메소드
	 * 
	 * @param order
	 */
	public void  addOrders(Order order) {
		order.setDelivery(this);
		this.order = order;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public String getZipcode() {
//		return zipcode;
//	}
//
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
