# ContactApplication
ReadMe

1. The complete application is build using gwt techniques.
	I have made 3 basic methods for the 3 basic buttons:  Add Contact, Edit and Delete. The three methods are as follows : 

	a. addindata : This method is invoked when we add data to our database. I have created a TREEMAP which sorts and puts the name(key) in the data base. The values associated with this key are stored in an ARRAYLIST. 

	b. putdelete : This deletes the dataentry and updates the database accordingly.

	c. putedit : This method is used to edit a previously stored contact and update the database accordingly.

	Every time we use any of these 3 functions we change the database and display the updated version. 

2. Styling and UI : 

I have used CSS to style the elements according to my liking. The code is in the .CSS file.


3.	The File Structure that you proposed didnt work out well for me. I have the build.xml file in the contactapplication folder, and when you run ant build on the terminal in that directory it successfully builds, however i am not too sure what all files you require for your structure thats why i am really sorry but i have kept this structure: 

Directory structure:
------------------
ContactApplication/
  build.xml
------------------

after you run that or before you run it i have provided my application output in the following directory: 

Directory structure:
----------------------------
ContactApplication/
	war/
  ContactApplication.html
---------------------------

4. I hope you find the application satisfactory and i am glad i got to learn so much while building the same. Let me know where all i can improve and if i went wrong. 

NOTE: 
I also tried implementing the SAFEHTMLUTIL features for security measures. I understand how important security is for such web applications , but unfortunately i could implement it without hindering some of the other features, in short i could not find the bug that kept me from doing it. Kindly accept my apologies for not being able to do so, but i would definitely keep working on it.


Thank You,
Rutvij Dhotey. :) 
