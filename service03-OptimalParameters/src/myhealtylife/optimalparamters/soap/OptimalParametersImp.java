package myhealtylife.optimalparamters.soap;

import javax.jws.WebService;

import myhealtylife.optimalparamters.model.AgeRangeList;
import myhealtylife.optimalparamters.model.ParametersList;
import myhealtylife.optimalparamters.model.entity.AgeRange;
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

	@Override
	public ParametersList readOptimalParameters(Integer age, String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParametersList readOptimalParameters(Integer age, String parameterName, String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parameter createParameter(Parameter p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parameter updateParameter(Parameter p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteParameter(Long parameterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeRangeList readAgeRanges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeRange createAgeRange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeRange updateAgeRange(AgeRange ag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteAgeRange(Long idAgeRange) {
		// TODO Auto-generated method stub
		return null;
	}

}
