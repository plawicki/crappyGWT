package com.gwt.is.client;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("crud")
public interface CRUDService extends RemoteService{
	
	Map<Integer, String> getList();
	Map<Integer, String> update(String value, int key);
	Map<Integer, String> remove(int key);
	Map<Integer, String> create(String newName);

}
