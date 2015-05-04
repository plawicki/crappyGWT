package com.gwt.is.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CRUDServiceAsync {

	void create(String newName, AsyncCallback<Map<Integer, String>> callback);

	void getList(AsyncCallback<Map<Integer, String>> callback);

	void remove(int index, AsyncCallback<Map<Integer, String>> callback);

	void update(String value, int index,
			AsyncCallback<Map<Integer, String>> callback);

}
