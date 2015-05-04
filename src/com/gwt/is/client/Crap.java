package com.gwt.is.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

public class Crap implements EntryPoint {

	private static class MyDataProvider extends AsyncDataProvider<String> {
		@Override
		protected void onRangeChanged(HasData<String> display) {
			updateRowData(0, DATA);
		}
	}

	private static List<String> DATA = new ArrayList<String>();

	private final MyDataProvider dataProvider = new MyDataProvider();

	private final TextBox valueField = new TextBox();

	private final Button editButton = new Button("Update");
	private final Button addButton = new Button("Create");
	private final Button removeButton = new Button("Delete");

	private final CellTable<String> table = new CellTable<String>();

	private final CRUDServiceAsync crud = GWT.create(CRUDService.class);

	private void onSuccessCallback(List<String> result) {
		DATA = result;
		dataProvider.updateRowData(0, result);
		dataProvider.updateRowCount(result.size(), true);
	}

	private void refreshList() {
		AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			@Override
			public void onSuccess(List<String> result) {
				onSuccessCallback(result);
			}
		};
		crud.getList(callback);
	}

	private void create(String item) {
		AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			public void onSuccess(List<String> result) {
				onSuccessCallback(result);
			}
		};
		crud.create(item, callback);
	}

	private void delete(int value) {
		AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			public void onSuccess(List<String> result) {
				onSuccessCallback(result);
			}
		};
		crud.delete(value, callback);
	}

	private void update(String value, int key) {
		AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			public void onSuccess(List<String> result) {
				onSuccessCallback(result);
			}
		};
		crud.update(value, key, callback);
	}

	@Override
	public void onModuleLoad() {

		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						String selected = selectionModel.getSelectedObject();
						if (selected != null) {
							valueField.setText(selected);
						} else {
							valueField.setText("");
						}
					}
				});

		valueField.addStyleName("form-control");
		valueField.getElement().setAttribute("placeholder", "Enter news");
		valueField.getElement()
				.setAttribute("aria-describedby", "basic-addon1");

		RootPanel.get("inputs").add(valueField);

		addButton.addStyleName("btn btn-success");
		addButton.removeStyleName("gwt-Button");
		addButton.setText("Create");

		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				create(valueField.getValue());
				valueField.setText("");
			}
		});

		RootPanel.get("buttons").add(addButton);

		editButton.addStyleName("btn btn-warning");
		editButton.removeStyleName("gwt-Button");
		editButton.setText("Update");

		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				update(valueField.getValue(), table.getKeyboardSelectedRow());
				selectionModel.clear();
			}
		});

		RootPanel.get("buttons").add(editButton);

		removeButton.addStyleName("btn btn-danger");
		removeButton.removeStyleName("gwt-Button");
		removeButton.setText("Delete");

		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				delete(table.getKeyboardSelectedRow());
				selectionModel.clear();
			}
		});

		RootPanel.get("buttons").add(removeButton);

		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		table.setSelectionModel(selectionModel);
		TextColumn<String> stringColumn = new TextColumn<String>() {
			@Override
			public String getValue(String obj) {
				return obj;
			}
		};
		table.addColumn(stringColumn, "News");

		dataProvider.addDataDisplay(table);

		refreshList();

		RootPanel.get("list").add(table);
	}
}
