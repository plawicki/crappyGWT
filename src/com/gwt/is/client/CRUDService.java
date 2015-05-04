package com.gwt.is.client;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("crud")
public interface CRUDService extends RemoteService{
	
	List<String> getList();
	List<String> update(String value, int key);
	List<String> delete(int key);
	List<String> create(String newName);

}
