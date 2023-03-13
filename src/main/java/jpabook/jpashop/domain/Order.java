package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	/**
	 * Member 테이블의 PK를 FK로 지정한 컬럼. 
	 * 객체지향 스럽지 않다. 해당 컬럼이 있는 이유는 결국 Order 정보를 토대로 Memeber 정보를 가지고 오기 위함인데
	 * 해당 식별자(컬럼)를 통해서 다시 한번 연관 객체를 조회하는 방법은 객체 설계를 테이블 설계에 맞춘 방식이라고 볼 수 있다.
	 * 따라서 객체를 참조하는 아래와 같은 방식으로 설계하는게 객체지향스럽다.
	 * Ex. private Member member;   
	 */
//	@Column(name = "MEMBER_ID")
//	private Long memberId;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	/**
	 * 연관관계의 주인 필드를 mappedBy에 지정해 준다.
	 */
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	/**
	 * 양방향 편의 메소드
	 * JPQL을 작성할 때 필요한 상황이 생긴다.
	 * @param orderItem
	 */
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		orderItems.add(orderItem);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(Long memberId) {
//		this.memberId = memberId;
//	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}