package com.google.gwt.sample.ContactApplication.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

//All imports 
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

//Entry Class
public class ContactApplication implements EntryPoint{
	
	  		
	// All Buttons and Panels Initialised
	  private static VerticalPanel mainPanel = new VerticalPanel();
	  private static FlexTable contactsFlexTable = new FlexTable();
	  private static HorizontalPanel addPanel = new HorizontalPanel();
	  private static HorizontalPanel buttonPanel = new HorizontalPanel();
	  private static HorizontalPanel buttonPaneledit = new HorizontalPanel();	 
	  private static HorizontalPanel addcontactPanel = new HorizontalPanel(); 
	  private Button addcontactButton = new Button("Add Contact");
	  static FormPanel form= new FormPanel();
	  public static DialogBox dialog=new DialogBox();
	  public static DialogBox dialogedit=new DialogBox();
	  TextBox newSymbolTextBox = new TextBox();
	  static TextBox newTextBox = new TextBox();
	  TextBox job = new TextBox();
	  static TextBox jobedit = new TextBox();
	  ListBox lb = new ListBox();
	  ListBox group= new ListBox();
	  static ListBox groupedit= new ListBox(); 
	  static ListBox lbedit = new ListBox();
	  static CheckBox checkedit= new CheckBox();
	  CheckBox check= new CheckBox();
	  
	  //DataStructures Used
	  private static ArrayList<String> contacts = new ArrayList<String>();
	  private static HashMap<String, ArrayList<String>> Datastore= new HashMap<String, ArrayList<String>>();
	  private static TreeMap<String, ArrayList<String>> Sorted= new TreeMap<String, ArrayList<String>>(Datastore);
	  
	  
	  final String removal = new String("");
	 
	  //MAIN METHOD
	  public void onModuleLoad() {
				 
		  contactsFlexTable.getColumnFormatter().setWidth(0, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(1, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(2, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(3, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(4, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(5, "100px");

		  	contactsFlexTable.setText(0, 0, "Name  ");
		    contactsFlexTable.setText(0, 1, "Job Title");
		    contactsFlexTable.setText(0, 2, "Age");
		    contactsFlexTable.setText(0, 3, "Group");  
		    contactsFlexTable.setText(0, 4, "Manager");
		    contactsFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
		    contactsFlexTable.addStyleName("watchList");
		  
		    addcontactButton.removeStyleName("gwt-Button");
		    addcontactButton.addStyleName("addcontactButton");
		   
		    //addPanel (Add Contact Button)
		    addPanel.add(addcontactButton);
		    addPanel.setCellHorizontalAlignment(addcontactButton,HasHorizontalAlignment.ALIGN_RIGHT);
		    addPanel.add(addcontactPanel);
		    addPanel.addStyleName("addPanel");
		    
		    // Assemble Main panel.
		    mainPanel.add(addPanel); 
		    mainPanel.add(contactsFlexTable);
		    mainPanel.addStyleName("displayed");
		   
		    // Add to Root
		    RootPanel.get("Contacts").add(mainPanel);
		   
		    
		    //INITIALISE WITH 3 CONTACTS
		    String currentname= "Contact 1";
		    contacts= new ArrayList<String>();
		    contacts.add("Managing Director");
		    contacts.add("34");
		    contacts.add("Management");
		    contacts.add("Y");
		  
		    Sorted.put(currentname, contacts);
		    
		    currentname="Contact 2";
		    contacts= new ArrayList<String>();
		    contacts.add("CFO");
		    contacts.add("44");
		    contacts.add("Management");
		    contacts.add("Y");
		  
		    Sorted.put(currentname, contacts);
			     
		    currentname= "Contact 3";
		    contacts= new ArrayList<String>();
		    contacts.add("Engineering Intern");
		    contacts.add("21");
		    contacts.add("Engineering");
		    contacts.add("N");
		  
		    Sorted.put(currentname, contacts);
			
		    // Entries in the FLEX TABLE
		    for(String key : Sorted.keySet()) {
    			
		    	
    			final int row1 = contactsFlexTable.getRowCount();
    			
		    	contacts= Sorted.get(key);
    			contactsFlexTable.setText(row1, 0, key);
				contactsFlexTable.setText(row1, 1, contacts.get(0));
				contactsFlexTable.setText(row1, 2, contacts.get(1));
				contactsFlexTable.setText(row1, 3, contacts.get(2));
				contactsFlexTable.setText(row1, 4, contacts.get(3));
				
				putdelete(row1);   
				putedit(row1);
				
		    }

		    //ONClick Method for Add Contact Method
		  		addcontactButton.addClickHandler(new ClickHandler() {
		        public void onClick(ClickEvent event) {
		         addindata();
		        }
		      });
		    
		    }
	  
	  // Add Method : After you click Add Contact 
	  
	  public void addindata(){
		  
		  // Dialog box 
		  dialog= new DialogBox();
		  dialog.setGlassEnabled(true);
		  dialog.setText("New Contact Details : ");
		  
		  HorizontalPanel HP=new HorizontalPanel();
		  
		  VerticalPanel panel= new VerticalPanel();
		  panel.setSpacing(10);
		  panel.setHeight("100");
	      panel.setWidth("300");
	      
	      //NAME TEXTBOX
	      newSymbolTextBox = new TextBox();
	      Label label= new Label("Name: ");
	      panel.add(label);
	      newSymbolTextBox.setWidth("220");
	      
	      HP.add(label);
		  
	      newSymbolTextBox.setName("textBoxFormElement");
	      HP.add(newSymbolTextBox);
	      panel.add(HP);
	      
	      
	      //JOB TEXTBOX
	      HP=new HorizontalPanel();
	      label= new Label("Job Title: "); 
	      HP.add(label); 
	      
	      job = new TextBox();
	      job.setWidth("220");
 
	      HP.add(job);
	      job.setName("textBoxFormElement");
	      panel.add(HP);

	      HP=new HorizontalPanel();
	      
	      label= new Label("Age: ");
	     
	      HP=new HorizontalPanel();
	      
	      //AGE DROPDOWN
	      lb = new ListBox();
	      lb.setName("Age:");
	      for (int i=15;i<=100;i++)
	      {
	    	  String ll= ""+i;
	    	  lb.addItem(ll);
	      }
	      lb.setWidth("220");
	      
	      HP.add(label);
	      HP.add(lb);
	      panel.add(HP);
	    
	      //GROUP DROPDOWN
	      HP=new HorizontalPanel();
	      label= new Label("Group: ");
	      HP.add(label);
	     
	      
	      group = new ListBox();
	      group.setName("Group");
	      group.addItem("Engineering");
	      group.addItem("Finance");
	      group.addItem("Front Office");
	      group.addItem("Management");
	      group.addItem("IT");
	      group.addItem("Sales");
	      
	      HP.add(group);
	      panel.add(HP);
	    
	      
	      //MANAGER CHECKBOX
	      
	      check= new CheckBox("Manager");
	      check.setValue(false);
	      panel.add(check);
	      
	      		  buttonPanel.clear();
			      Button submit=new Button("Submit");
			      buttonPanel.add(submit);
			      
			      Button cancel=new Button("Cancel");
			      buttonPanel.add(cancel);
			      buttonPanel.setSpacing(10);
			      panel.add(buttonPanel);
			      
			      submit.addStyleDependentName("paddedHorizontalPanel");
			      cancel.addStyleDependentName("paddedHorizontalPanel");
				     
			      addPanel.add(panel);
			      
			      
				 
			      dialog.addStyleName("displayed");
			      dialog.add(panel);
			      
				  addPanel.add(dialog);
				  
				  
				  dialog.show();
				  dialog.center();
				     
				  dialog.addStyleDependentName("style");
				  newSymbolTextBox.setFocus(true);
			      
				 //ONClick Method for Cancel Button
				  
				  cancel.addClickHandler(new ClickHandler() {
			    	  
				         public void onClick(ClickEvent event) {
				        	 
				        	 dialog.hide();
				  
				         }
				  });
	  
				  
				  // ONClick method for SUBMIT BUTTON
				  
				  submit.addClickHandler(new ClickHandler() {
			    	  
				         public void onClick(ClickEvent event) {
				        	 
				        	 dialog.hide();
				        	 
				        	 
				        	 if (newSymbolTextBox.getText().length() == 0 || job.getText().length() == 0  ) {
				        		 if (newSymbolTextBox.getText().length() == 0)
				        		 {
				        			 Window.alert("The Name Field must not be empty");
				        		 }       
				        		 else
				        		 {
				        			 Window.alert("The Job Field must not be empty");
				        		 }
				        	}
		 
				        	else
				        	{ 
				        	 
				        		final String names= newSymbolTextBox.getText();
				        		final String jobs= job.getText();
				        		final String age= lb.getSelectedItemText();
				        		final String gr=group.getSelectedItemText();
				        		String manager= "N";
					   	     if (check.getValue())
					   	     {
					   	    	 final String val= "Y";
					   	    	 manager= val;
					   	     }
					   	     else
					   	     {
					   	    	final String val= "N";
					   	    	manager= val;
						   	 }
					   		if (Sorted.containsKey(names))
								{
									Window.alert("Contact Already Present");
								}
				        	else
				        	{
				        		contacts=parsearraylist(jobs,age,gr,manager);
				        			Sorted.put(names, contacts);
				        			contactsFlexTable.clear();
				        			int row=1;
				        		for(String key : Sorted.keySet())
				        		{
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
				        	}	
				        }		
				    }
		     });
	  }
	 
	  	// Data Structure Update....
	  		public static ArrayList<String> parsearraylist(String a, String b, String c,String d) {
			contacts= new ArrayList<String>();
		  	contacts.add(a);
			contacts.add(b);
			contacts.add(c);
			contacts.add(d);
			return contacts;
			
}
	  
	  		
	  // Delete Button Method
	  public static void putdelete(int r)
	  {
		  int row= r;
		  Button removecontactButton = new Button("Delete");
		  removecontactButton.addStyleDependentName("style");
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
	  public static void putedit(int r)
	  {
		  int row= r;
		  Button editcontactButton = new Button("Edit");
		  editcontactButton.addStyleDependentName("style");
		  editcontactButton.addClickHandler(new ClickHandler() {
		  public void onClick(ClickEvent event) {
			    int rowIndex = contactsFlexTable.getCellForEvent(event).getRowIndex();
		        final String edit= contactsFlexTable.getFlexCellFormatter().getElement(rowIndex, 0).getInnerHTML();
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
			      for (int i=15;i<=100;i++)
			      {
			    	  String ll= ""+i;
			    	  lbedit.addItem(ll);
			      }
			     lbedit.setWidth("220");
			      int k= lbedit.getItemCount();
			      
			      for (int i=0;i<k;i++ )
			      {	    	  
			    	  if(contacts.get(1)==lbedit.getItemText(i))
			    	  {
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
			      for (int i=0;i<k;i++ )
			      {
			    	  if(contacts.get(2)==groupedit.getItemText(i))
			    	  {
			    		  groupedit.setSelectedIndex(i);
			    	  }
			      }
			      checkedit= new CheckBox("Manager");
			      if(contacts.get(3)=="Y")
			      {
			    	  checkedit.setValue(true);	  
			      }
			      else
			      {
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
						        	 dialogedit.hide();
						         }
						  });
			  
						  
					       
						  submit.addClickHandler(new ClickHandler() {
					    	  
						         public void onClick(ClickEvent event) {
						        	 
						        	 dialogedit.hide();
						        	 
						        	 Sorted.remove(edit);
						        	 
						        	 if (newTextBox.getText().length() == 0 || jobedit.getText().length() == 0  ) {
						        		 if (newTextBox.getText().length() == 0)
						        		 {
						        			 Window.alert("The Name Field must not be empty");
						        		 }       
						        		 else
						        		 {
						        			 Window.alert("The Job Field must not be empty");
						        		 }
						        	}
				 
						        	 else
						        	 { 
						        	 
						        		 final String names= newTextBox.getText();
						        		 final String jobs= jobedit.getText();
						        		 final String age= lbedit.getSelectedItemText();

						        		 final String gredit= groupedit.getSelectedItemText();
						        		 String manager= "N";
							   	     if (checkedit.getValue())
							   	     {
							   	    	 final String val= "Y";
							   	    	 manager= val;
							   	     }
							   	     else
							   	     {
							   	    	 final String val= "N";
							   	    	 manager= val;
								   	 }
							   	    if (Sorted.containsKey(names))
										{
											Window.alert("Contact Already Present");
										}
						        	else
						        	{
						        		contacts=parsearraylist(jobs,age,gredit,manager);
						        		Sorted.put(names, contacts);
						     
						        		contactsFlexTable.clear();
						        		
						        		int row=1;
						        		for(String key : Sorted.keySet()) 
						        		{
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
						        	}	
							   	 }		
							}
				     });
		      }  
		    });
		    contactsFlexTable.setWidget(row, 5, editcontactButton);
	  }
	  	  	
}


