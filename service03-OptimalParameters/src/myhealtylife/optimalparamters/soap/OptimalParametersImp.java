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
	public ParametersList readOptimalParametersByAgeAndSex(Integer age, String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParametersList readOptimalParametersByNameAgeAndSex(Integer age, String parameterName, String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parameter createParameter(Parameter p) {
		Parameter p1=Parameter.saveParameter(p);
		return p1;
	}

	@Override
	public Parameter updateParameter(Parameter p) {
		Parameter stored=Parameter.getParameterById(p.getIdParameter());
		stored.setAgeRange(p.getAgeRange());
		stored.setParameterName(p.getParameterName());
		stored.setSex(p.getSex());
		stored.setValue(p.getValue());
		return Parameter.updateParameter(stored);
	}

	@Override
	public long deleteParameter(long parameterId) {
		Parameter p=Parameter.getParameterById(parameterId);
		
		if(p==null)
			return -1L;
		
		Parameter.removeParameter(parameterId);
		return parameterId;
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
	public long deleteAgeRange(long ageRangeId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
