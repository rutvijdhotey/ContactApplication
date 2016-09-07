package com.google.gwt.sample.ContactApplication.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
public class ExistingUser extends ContactApplication {

	// Delete Button Method
	  public void putdelete(int r) {
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
	
	  // Edit Button Method
	  public void putedit(int r) {
		 int row= r;
		 Button editcontactButton = new Button("Edit");
		 editcontactButton.removeStyleName("gwt-Button");
		 editcontactButton.addStyleName("contactButton");
		 editcontactButton.addClickHandler(new ClickHandler() {
		 
		public void onClick(ClickEvent event) {
			int rowIndex = contactsFlexTable.getCellForEvent(event).getRowIndex();
		    final String edit= contactsFlexTable.getFlexCellFormatter().getElement(rowIndex, 0).getInnerText();
		    contacts= Sorted.get(edit); 
		    dialogedit= new DialogBox();
		    dialogedit.setGlassEnabled(true);
		    dialogedit.setText("Edit Contact Details : ");
		    VerticalPanel panel= new VerticalPanel();
		    panel.setSpacing(10);
		    panel.setHeight("100");
		    panel.setWidth("400");
			    
		    HorizontalPanel HP=new HorizontalPanel();
			     
		    newTextBox = new TextBox();
		    newTextBox.setValue(edit);
			        
		    Label label= new Label("Name: ");
			      
			HP.add(label);
			newTextBox.setName("textBoxFormElement");
			String original = newTextBox.getValue();
			      
			HP.add(newTextBox);
			panel.add(HP);      
			HP=new HorizontalPanel();
			label= new Label("Job Title: ");
			       
			HP.add(label);
			jobedit = new TextBox();
			jobedit.setWidth("220");
			jobedit.setValue(contacts.get(0));
			jobedit.setName("textBoxFormElement");
			HP.add(jobedit);
			panel.add(HP);
			HP=new HorizontalPanel();	  
			label= new Label("Age:  ");
			HP.add(label);
			lbedit = new ListBox();
			lbedit.setName("Age: ");
			for (int i=15;i<=100;i++) {
	    	  String ll= ""+i;
	    	  lbedit.addItem(ll);
			}
			lbedit.setWidth("220");
			int k= lbedit.getItemCount();      
			 for (int i=0;i<k;i++ ) {	    	  
				 if(contacts.get(1)==lbedit.getItemText(i)) {
					 lbedit.setSelectedIndex(i);
			     }  
			 }
			     
			 HP.add(lbedit);
			 panel.add(HP);
			 HP=new HorizontalPanel();
			 label= new Label("Group: ");
		     HP.add(label);
			     
		     groupedit = new ListBox();
		     groupedit.setName("Group");
		     groupedit.addItem("Engineering");
		     groupedit.addItem("Finance");
		     groupedit.addItem("Front Office");
			 groupedit.addItem("Management");
			 groupedit.addItem("IT");
			 groupedit.addItem("Sales");
			 HP.add(groupedit);
			 panel.add(HP);
		     k= groupedit.getItemCount();
		     for (int i=0;i<k;i++ ) {
		    	 if(contacts.get(2)==groupedit.getItemText(i)) {
		    		  groupedit.setSelectedIndex(i);
		    	  }
		     }
		     checkedit= new CheckBox("Manager");
		     if(contacts.get(3)=="Y") {
			   checkedit.setValue(true);	  
		     } else {
			    checkedit.setValue(false);
		     }
		     panel.add(checkedit);
		     buttonPaneledit.clear();
		     Button submit=new Button("Save");
		     buttonPaneledit.add(submit);
		     Button cancel=new Button("Cancel");
		     buttonPaneledit.add(cancel);
		     buttonPaneledit.setSpacing(10);
		     panel.add(buttonPaneledit);
		     addPanel.add(panel);
		     dialogedit.addStyleName("displayed");
					      
		     dialogedit.add(panel);
		     dialogedit.addStyleName("DialogBox");
		     addPanel.add(dialogedit);
						  
		     dialogedit.show();
		     dialogedit.center();
					      
		     newTextBox.setFocus(true);			  
		     cancel.addClickHandler(new ClickHandler() {		    	  
		         public void onClick(ClickEvent event) {
		        	 if(newTextBox.getValue().equalsIgnoreCase(original)){
		        		 dialogedit.hide();
		        	 } else if (Sorted.containsKey(newTextBox.getValue())){
		        		Window.alert("Contact Already Present");
						dialogedit.show();
		        	 } else {
		        	 dialogedit.hide();
		        	 }
		         }
		     });
			 
		     submit.addClickHandler(new ClickHandler() {		    	  
		    	 public void onClick(ClickEvent event) {
		    		 dialogedit.hide();
		    		 if (newTextBox.getText().length() == 0 || jobedit.getText().length() == 0  ) {
		        		 if (newTextBox.getText().length() == 0) {
		        			 Window.alert("The Name Field must not be empty");
		        		 } else {
		        			 Window.alert("The Job Field must not be empty");
		        		 }
		        		 dialogedit.show();
		        	} else {
						        		 
		        		 Sorted.remove(edit);
			        	 
		        		 String names= newTextBox.getText();
		        		 String name =  SafeHtmlUtils.htmlEscape(names);
		        		 final String jobs= jobedit.getText();
		        		 final String age= lbedit.getSelectedItemText();

		        		 final String gredit= groupedit.getSelectedItemText();
		        		 String manager= "N";
				   	     if (checkedit.getValue()) {
				   	    	 final String val= "Y";
				   	    	 manager= val;
				   	     } else {
				   	    	 final String val= "N";
				   	    	 manager= val;
					   	 }
				   	    
				   	     if (Sorted.containsKey(name)) {
								Window.alert("Contact Already Present");
								dialogedit.show();
						} else {
			        		contacts=parsearraylist(jobs,age,gredit,manager);
			        		Sorted.put(name, contacts);
			        		for(int i = 1; i< contactsFlexTable.getRowCount() ;i++ ){
			        			contactsFlexTable.removeRow(i);
			        		}	
			        		int row=1;
			        		for(String key : Sorted.keySet()) {
			        			contacts= Sorted.get(key);
			        			contactsFlexTable.setText(row, 0, key);
								contactsFlexTable.setText(row, 1, contacts.get(0));
								contactsFlexTable.setText(row, 2, contacts.get(1));
								contactsFlexTable.setText(row, 3, contacts.get(2));
								contactsFlexTable.setText(row, 4, contacts.get(3));
								putdelete(row);
								putedit(row);
								row=row+1;
			        		}
			        		applyDataRowStyles();
						}	
				   	 }		
		    	 }
		    });
		}  
	});
		    contactsFlexTable.setWidget(row, 5, editcontactButton);
  }
}
