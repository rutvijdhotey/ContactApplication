package com.google.gwt.sample.ContactApplication.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class delContact extends ContactApplication{

		// Delete Button Method
		  public void putdelete(int r)
		  {
			  int row= r;
			  Button removecontactButton = new Button("Delete");
			  removecontactButton.removeStyleName("gwt-Button");
			  removecontactButton.addStyleName("contactButton");
			  
			  removecontactButton.addClickHandler(new ClickHandler() {
			  public void onClick(ClickEvent event) {
			        int rowIndex = contactsFlexTable.getCellForEvent(event).getRowIndex();
			        final String removal= contactsFlexTable.getFlexCellFormatter().getElement(rowIndex, 0).getInnerHTML();
			        Sorted.remove(removal);
			    	contactsFlexTable.removeRow(rowIndex);
				  }
			    });
			    contactsFlexTable.setWidget(row, 6, removecontactButton);
		  }
		  
}
