package org.webshop.search.workspace.dao;

import java.util.List;

import org.webshop.search.model.OrderItem;

public interface ItemDAO extends Dao<OrderItem>{

int [][] insertBatch(List<OrderItem> orderItem,String tableName);
	
	void updateAmountOf(int productId, int amountOf, String tableName);
	
	void dropTable(String tableName);
	
	void createWorkTable(String tableName);
	
	OrderItem getOrderItem(int productId, String tableName);
	
	List<OrderItem> getAllOrderItemsIsSeleted(String tableName);

}
