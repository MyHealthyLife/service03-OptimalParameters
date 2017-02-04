package myhealtylife.optimalparamters.document.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.eclipse.persistence.jpa.config.DataService;

import myhealtylife.optimalparamters.model.entity.Parameter;
import myhealtylife.optimalparamters.soap.OptimalParameters;


public class TestClient {
	
	public static void main(String args[]) throws MalformedURLException{
		URL url = new URL("http://127.0.1.1:6901/ws/optimal_paramters?wsdl");
	  	//URL url = new URL("https://service01-dataservice.herokuapp.com/ws/data_service?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.optimalparamters.myhealtylife/", "OptimalParamteres");
        Service service = Service.create(url, qname);

        OptimalParameters op = service.getPort(OptimalParameters.class);
        
        Parameter p=new Parameter();
        p.setParameterName("prova");
        p.setValue(127.0);
        p=op.createParameter(p);
        
        System.out.println(p.getIdParameter()+" "+p.getValue());
        
        p.setValue(2.0);
        op.updateParameter(p);
        
        System.out.println(p.getIdParameter()+" "+p.getValue());
	}

}
