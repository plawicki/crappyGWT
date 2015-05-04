package com.gwt.is.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.is.client.CRUDService;

public class CRUDServiceServer extends RemoteServiceServlet implements CRUDService {
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, String> db = new HashMap<Integer, String>();
	
	@Override
	public Map<Integer, String> getList() {
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	public Map<Integer, String> update(String value, int key) {
		// TODO Auto-generated method stub
		db.remove(key);
		db.put(key, value);
		return db;
	}

	@Override
	public Map<Integer, String> remove(int key) {
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	public Map<Integer, String> create(String newName) {
		// TODO Auto-generated method stub
		return db;
	}

}
