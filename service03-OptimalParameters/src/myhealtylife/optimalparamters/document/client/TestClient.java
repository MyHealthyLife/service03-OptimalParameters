package myhealtylife.optimalparamters.document.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.eclipse.persistence.jpa.config.DataService;

import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.model.entity.Parameter;
import myhealtylife.optimalparamters.soap.OptimalParameters;


public class TestClient {
	
	public static void main(String args[]) throws MalformedURLException{
		URL url = new URL("http://127.0.1.1:6901/ws/optimal_paramters?wsdl");
	  	//URL url = new URL("https://service03-optimalparameters.herokuapp.com/ws/optimal_paramters?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.optimalparamters.myhealtylife/", "OptimalParamteres");
        Service service = Service.create(url, qname);

        OptimalParameters op = service.getPort(OptimalParameters.class);
        
        Parameter p=new Parameter();
        p.setParameterName("test");
        p.setValue(127.0);
        p=op.createParameter(p);
        
        System.out.println(p.getIdParameter()+" "+p.getValue());
        
        p.setValue(2.0);
        p.setSex("M");
        op.updateParameter(p);
        
        System.out.println(p.getIdParameter()+" "+p.getValue());
        
        //op.deleteParameter(2L);
        
        AgeRange ag=new AgeRange();
        ag.setFromAge(10);
        ag.setToAge(200);
        
        ag=op.createAgeRange(ag);
        
        System.out.println(ag.getIdRange());
        
        System.out.println(op.readAgeRanges().getAgeRanges().size());
        
        ag.setFromAge(50);
        
        ag=op.updateAgeRange(ag);
        
        System.out.println(ag.getFromAge());
        
        //op.deleteAgeRange(152);
        
        p.setAgeRange(ag);
        
        op.updateParameter(p);
        
        System.out.println(op.readOptimalParameters().getParameters().size());
        
        System.out.println(op.readOptimalParametersByAgeAndSex(199, "M").getParameters().size());
        
        System.out.println(op.readOptimalParametersByNameAgeAndSex(199, "Mela", "M").getParameters().size());
	}

}
