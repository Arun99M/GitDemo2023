package Pojo;

import java.util.List;

public class Orders {

	private List<OrderDetail> orders;  //mainly we adding list because in future there is n number of array comes then easy to use, right now only one array we have like country and product ordered id

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}
	
}
