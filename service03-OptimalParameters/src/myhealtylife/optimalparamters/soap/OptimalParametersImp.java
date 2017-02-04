package myhealtylife.optimalparamters.soap;

import javax.jws.WebService;

import myhealtylife.optimalparamters.model.ParametersList;
import myhealtylife.optimalparamters.model.entity.Parameter;

@WebService(endpointInterface="myhealtylife.optimalparamters.soap.OptimalParameters",
serviceName="OptimalParamteres")
public class OptimalParametersImp implements OptimalParameters {

	@Override
	public ParametersList readOptimalParameters() {
		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAll());
		return list;
	}

}
