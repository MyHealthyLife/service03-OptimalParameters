package myhealtylife.optimalparamters.document.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.model.entity.Parameter;
import myhealtylife.optimalparamters.soap.OptimalParameters;

public class CreateParameters {
	
	public static void main(String args[]) throws MalformedURLException{
			//URL url = new URL("http://127.0.1.1:6901/ws/optimal_paramters?wsdl");
		  	URL url = new URL("https://service03-optimalparameters.herokuapp.com/ws/optimal_paramters?wsdl");
	        //1st argument service URI, refer to wsdl document above
	        //2nd argument is service name, refer to wsdl document above
	        QName qname = new QName("http://soap.optimalparamters.myhealtylife/", "OptimalParamteres");
	        Service service = Service.create(url, qname);

	        OptimalParameters op = service.getPort(OptimalParameters.class);
	        
	        
	        
	        List<AgeRange> ageRanges=op.readAgeRanges().getAgeRanges();
	        
	        Iterator<AgeRange> it=ageRanges.iterator();
	        
	        while(it.hasNext()){
	        	AgeRange ag=it.next();
	        	
	        	Parameter p=new Parameter();
	        	p.setAgeRange(ag);
	        	p.setParameterName("height");
	        	p.setSex("M");
	        	p.setValue(new Double(50));
	        	
	        	op.createParameter(p);
	        	
	        	p.setSex("F");
	        	
	        	op.createParameter(p);
	        	
	        	System.out.print(".");
	        	
	        	p=new Parameter();
	        	p.setAgeRange(ag);
	        	p.setParameterName("weight");
	        	p.setSex("M");
	        	p.setValue(new Double(50));
	        	
	        	op.createParameter(p);
	        	
	        	p.setSex("F");
	        	
	        	op.createParameter(p);
	        	
	        	System.out.print(".");
	        	
	        	p=new Parameter();
	        	p.setAgeRange(ag);
	        	p.setParameterName("steps");
	        	p.setSex("M");
	        	p.setValue(new Double(5000));
	        	
	        	op.createParameter(p);
	        	
	        	p.setSex("F");
	        	
	        	op.createParameter(p);
	        	
	        	System.out.print(".");
	        	
	        	
	        	
	        	
	        }
	        
	        System.out.println("\ndone");
		}
	

}
