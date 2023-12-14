import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
class AddressBook {
    
ArrayList<PersonInfo> persons;
public AddressBook() {
    persons = new ArrayList<PersonInfo>();
    createFileIfNotExists();
    loadPersons();
}
public void addPerson( ) {
String name = JOptionPane.showInputDialog("Enter name");
String add = JOptionPane.showInputDialog("Enter address"); 
String pNum =JOptionPane.showInputDialog("Enter phone number");
PersonInfo p = new PersonInfo(name, add, pNum);
persons.add(p);
}
public void searchPerson (String n) {
    for (int i=0; i< persons.size(); i++) {
PersonInfo p = (PersonInfo)persons.get(i);
if ( n.equals(p.getName()) ) {
p.print();
}
} 
} 
public void deletePerson (String n) {
for (int i=0; i< persons.size(); i++) {
PersonInfo p = (PersonInfo)persons.get(i);
if ( n.equals(p.getName()))
{
persons.remove(i);
}
}
}
public void savePersons ( ){

try{
    PersonInfo p;
    String Line;
    FileWriter fw= new FileWriter("persons.txt");
    PrintWriter pw=new PrintWriter(fw);
    for(int i=0; i<persons.size();i++){
        p=(PersonInfo)(persons.get(i));
        Line=p.getName()+","+p.getAddress()+","+p.getPhoneNum()+"\n";
        pw.write(Line);
    } 
    pw.flush();
    pw.close();
    fw.close();
}
   catch(IOException ioEx){
System.out.println(ioEx);
}

}
public void loadPersons ( ){
    String name;
    String add;
   String ph;
    String Tokens[]=null;
    try{
        
        FileReader fr =new FileReader ("persons.txt");
        BufferedReader br = new BufferedReader(fr);

        String Line=br.readLine();
        while(Line!=null){
            Tokens=Line.split(",");
            name=Tokens[0];
            add=Tokens[1];
            ph=Tokens[2];
            PersonInfo p=new PersonInfo(name, add, ph);
            persons.add(p);
            Line=br.readLine();
        }
        br.close();
        fr.close();
    }
    catch(IOException ioEx){
System.out.println(ioEx);
}
}


private void createFileIfNotExists() {
    File file = new File("persons.txt");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e);
        }
    }
}

} 