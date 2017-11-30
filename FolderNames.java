import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;




class FolderNames
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
		        String startingLetter="u";  //provide starting letter here
		        String xmlFilePath="folder.xml"; //place the xml file  in same directory as FolderNames.java

		        FolderNames fdn= new FolderNames();
		        ArrayList<String> folderNamesWithStartingLetter = new ArrayList<String>();

		        folderNamesWithStartingLetter= fdn.folderNames(startingLetter, xmlFilePath);
		        
		              if(!folderNamesWithStartingLetter.isEmpty())
		              	{System.out.println(String.format("Folder name(s) with starting letter %s:", startingLetter));
					        for (String eachFolderNameWithStartingLetter : folderNamesWithStartingLetter) {
					           System.out.println(eachFolderNameWithStartingLetter);
					        }
				    }
				      else
				      	System.out.println(String.format("Folder(s) with start letter %s cannot  be found",startingLetter));
    
      
    }

    public ArrayList<String> folderNames(String startingLetter, String  xmlFilePath){
                
        //Populated XML String....
        
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		ArrayList<String> attribute= new ArrayList<String>();
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
        NodeList nList = document.getElementsByTagName("folder");
        
	    
		        for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);


				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//Get the folder name and check with startletter
		            String folderNameWithStartingLetter = eElement.getAttribute("name");
				    if(folderNameWithStartingLetter.charAt(0)==startingLetter.replaceAll("\\s","").charAt(0) )
							   attribute.add(folderNameWithStartingLetter);


						}  

			}
	          
	    }

	  catch (Exception ex) {
         ex.printStackTrace();
      }

		return attribute;                
		                
   }    
    
}

