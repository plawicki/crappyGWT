package com.gwt.is.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CRUDServiceAsync {

	void create(String newName, AsyncCallback<List<String>> callback);

	void getList(AsyncCallback<List<String>> callback);

	void delete(int key, AsyncCallback<List<String>> callback);

	void update(String value, int key, AsyncCallback<List<String>> callback);

}
