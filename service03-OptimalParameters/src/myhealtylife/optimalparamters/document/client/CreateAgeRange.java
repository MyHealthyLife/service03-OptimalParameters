package myhealtylife.optimalparamters.document.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.soap.OptimalParameters;

public class CreateAgeRange {
	public static void main(String args[]) throws MalformedURLException{
		//URL url = new URL("http://127.0.1.1:6901/ws/optimal_paramters?wsdl");
	  	URL url = new URL("https://service03-optimalparameters.herokuapp.com/ws/optimal_paramters?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.optimalparamters.myhealtylife/", "OptimalParamteres");
        Service service = Service.create(url, qname);

        OptimalParameters op = service.getPort(OptimalParameters.class);
        
        
        
        int ranges[][]={{0,10},{11,20},{21,30},{31,40},{41,50},{51,70},{71,110}};
        
        for(int i=0;i<ranges.length;i++){
        	AgeRange ag=new AgeRange();
        	ag.setFromAge(ranges[i][0]);
        	ag.setToAge(ranges[i][1]);
        	op.createAgeRange(ag);
        	System.out.print(".");
        }
        System.out.println("\ndone");
	}
}
