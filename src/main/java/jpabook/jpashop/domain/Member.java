package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * 
 * @author wglee
 * index 및 컬럼길이 등 메타데이터는 객체 직접 명시하는걸 선호한다. DB 스키마를 보지 않아도 되기 때문에.
 * 
 */
@Entity
public class Member {
	
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	/**
	 * 조회용 : Order 객체
	 * 가능한 양방향 맵핑은 지양하자. 객체 입장에서 양방향을 맵핑하게 되면 복잡도가 늘어나게 되기 때문에
	 */ 
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();
	
	
	
	public void addOrders(Order order) {
		orders.add(order);
		order.setMember(this);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}