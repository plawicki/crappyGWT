package com.gwt.is.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.is.client.CRUDService;

public class CRUDServiceServer extends RemoteServiceServlet implements CRUDService {
	private static final long serialVersionUID = 1L;
	
	private List<String> db = new ArrayList<String>();
	
	@Override
	public List<String> getList() {
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	public List<String> update(String value, int key) {
		// TODO Auto-generated method stub
		db.set(key, value);
		return db;
	}

	@Override
	public List<String> delete(int key) {
		db.remove(key);
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	public List<String> create(String newName) {
		// TODO Auto-generated method stub
		db.add(newName);
		return db;
	}

}
