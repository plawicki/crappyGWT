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
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
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

	private final Button editButton = new Button("Update");
	private final Button addButton = new Button("Create");
	private final Button removeButton = new Button("Delete");

	//private final CellList<String> cellList = new CellList<String>(new TextCell());
	
	private final CellTable<String> table = new CellTable<String>();
	
	
	
	private final CRUDServiceAsync crud = GWT.create(CRUDService.class);
	 
    
	@Override
	public void onModuleLoad() {
	
		valueField.addStyleName("form-control");
		valueField.getElement().setAttribute("placeholder", "Enter news");
		valueField.getElement().setAttribute("aria-describedby", "basic-addon1");
		
		RootPanel.get("inputs").add(valueField);
		
		editButton.addStyleName("btn btn-success");
		editButton.removeStyleName("gwt-Button");
		editButton.setText("Create");
		
		RootPanel.get("buttons").add(editButton);
		
		addButton.addStyleName("btn btn-warning");
		addButton.removeStyleName("gwt-Button");
		addButton.setText("Update");
		
		RootPanel.get("buttons").add(addButton);
		
		removeButton.addStyleName("btn btn-danger");
		removeButton.removeStyleName("gwt-Button");
		removeButton.setText("Delete");
		
		RootPanel.get("buttons").add(removeButton);
		
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		TextColumn<String> stringColumn = new TextColumn<String>(){
			@Override
			public String getValue(String obj){
				return obj;
			}
		};
		
		table.addColumn(stringColumn, "News");
	}
}
