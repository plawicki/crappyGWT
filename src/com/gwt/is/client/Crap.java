package com.gwt.is.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;


public class Crap implements EntryPoint {
	
	private static class MyDataProvider extends AsyncDataProvider<String> {
	    @Override
	    protected void onRangeChanged(HasData<String> display) {
	    	updateRowData(0, DATA);
	    }
	}
	
	private final static List<String> DATA = new ArrayList<String>();
	
	private final MyDataProvider dataProvider = new MyDataProvider();
	
	private final TextBox valueField = new TextBox();
	private final TextBox editField = new TextBox();

	private final Button editButtton = new Button("Update");
	private final Button addButton = new Button("Create");
	private final Button removeButton = new Button("Delete");

	private final CellList<String> cellList = new CellList<String>(new TextCell());
	private final CRUDServiceAsync crud = GWT.create(CRUDService.class);
	 
    
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
	}
}
