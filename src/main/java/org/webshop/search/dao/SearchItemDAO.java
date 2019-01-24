package org.webshop.search.dao;

import java.util.List;

import org.webshop.search.model.SearchItem;

public interface SearchItemDAO {
	
	List <SearchItem> getAllItem(int visible);

}
