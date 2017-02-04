package myhealtylife.optimalparamters.soap;

import javax.jws.WebService;

import myhealtylife.optimalparamters.model.ParametersList;

@WebService(endpointInterface="myhealtylife.optimalparamters.soap.OptimalParameters",
serviceName="OptimalParamteres")
public class OptimalParametersImp implements OptimalParameters {

	@Override
	public ParametersList readOptimalParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
