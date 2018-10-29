package org.webshop.search.dao;

import java.util.List;

import org.webshop.search.model.InputSearch;
import org.webshop.search.model.OrderItem;

public interface CollectionSearchDAO {
	
	List <OrderItem> getListOfSearch(InputSearch input);
	
}
