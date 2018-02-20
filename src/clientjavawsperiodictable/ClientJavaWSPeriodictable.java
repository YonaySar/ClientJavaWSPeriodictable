/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavawsperiodictable;

/**
 *
 * @author entrar
 */
public class ClientJavaWSPeriodictable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     ClientJavaWSPeriodictable client = new  ClientJavaWSPeriodictable();
     String ATN= client.AtomicNumber("Gold");
     String Atoms= client.GetAtoms();
     String AW=client.AtomicWeight("Gold");
     String Symbol=client.GetSymbol("Gold");
     if (!ATN.equals("<NewDataSet />")) {
            String atomicNumber = parseResponse(ATN, "</AtomicNumber>");
            System.out.println("Gold atomic number is: " + atomicNumber);
        }

     if (!Symbol.equals("<NewDataSet />")) {
            String elementSymbol = parseResponse(Symbol, "</Symbol>");
            System.out.println("Gold element symbol is: " + elementSymbol );

        }
     if (!AW.equals("<NewDataSet />")) {
            String elementSymbol = parseResponse(AW, "</AtomicWeight>");
            System.out.println("Gold element symbol is: " + elementSymbol );

        }
       if (!Atoms.equals("<NewDataSet />")) {
            String ElementName = parseResponse(Atoms, "</ElementName>");
            System.out.println("Elements names: " + ElementName);
        }
    }
    public String GetSymbol(String element){
        String symbol =getElementSymbol(element);
       return symbol;
    }
    public String GetAtoms(){
        return getAtoms();
    }
    public String AtomicWeight(String element){
        String AtomicWeight= getAtomicWeight(element);
        return AtomicWeight;
    }
    public String AtomicNumber(String element){
      
        String  AtomicNumber=getAtomicNumber(element);
        return AtomicNumber;
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getAtomicWeight(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtoms() {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
     private static String parseResponse(String response, String endTag) {
        String beginTag = endTag.replace("/", "");
        final int from = response.indexOf(beginTag);
        final int to = response.lastIndexOf(endTag);
        final String beginTagAndContent = response.substring(from, to);
        return beginTagAndContent.substring(beginTagAndContent.indexOf(">") + 1);
    }
}
