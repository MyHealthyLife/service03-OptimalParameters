package myhealtylife.optimalparamters.soap;

import javax.jws.WebService;

import myhealtylife.optimalparamters.model.AgeRangeList;
import myhealtylife.optimalparamters.model.ParametersList;
import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.model.entity.Parameter;

/**
 * 
 * @author stefano
 *
 */
@WebService(endpointInterface="myhealtylife.optimalparamters.soap.OptimalParameters",
serviceName="OptimalParamteres")
public class OptimalParametersImp implements OptimalParameters {

	@Override
	public ParametersList readOptimalParameters() {
		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAll()); //get all available parameters
		return list;
	}

	@Override
	public ParametersList readOptimalParametersByAgeAndSex(Integer age, String sex) {

		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAllByAgeAndSex(sex,age));//get all parameters by age and sex
		
		return list;
	}

	@Override
	public ParametersList readOptimalParametersByNameAgeAndSex(Integer age, String parameterName, String sex) {
		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAllByAgeSexName(sex, parameterName, age));//get all parameters by sex, age and parameter name
		return list;
	}

	@Override
	public Parameter createParameter(Parameter p) {
		Parameter p1=Parameter.updateParameter(p);//persist the new parameter
		return p1;
	}

	@Override
	public Parameter updateParameter(Parameter p) {
		Parameter stored=Parameter.getParameterById(p.getIdParameter());
		
		/*check of the parameter exits*/
		if(stored==null)
			return null;
		
		/*update the informations of the stored paramater with the informations available 
		 * in the updated parameter*/
		if(p.getAgeRange()!=null)
			stored.setAgeRange(p.getAgeRange());
		if(p.getParameterName()!=null)
			stored.setParameterName(p.getParameterName());
		if(p.getSex()!=null)
			stored.setSex(p.getSex());
		if(p.getValue()!=null)
			stored.setValue(p.getValue());
		
		return Parameter.updateParameter(stored);
	}

	@Override
	public long deleteParameter(long parameterId) {
		Parameter p=Parameter.getParameterById(parameterId);
		
		/*check if the parameter exists*/
		if(p==null)
			return -1L;
		
		Parameter.removeParameter(parameterId);
		return parameterId;
	}

	@Override
	public AgeRangeList readAgeRanges() {
		AgeRangeList list=new AgeRangeList();
		list.setAgeRanges(AgeRange.getAll()); // get all agerange
		return list;
	}

	@Override
	public AgeRange createAgeRange(AgeRange ag) {
		
		return AgeRange.saveAgeRange(ag);
	}

	@Override
	public AgeRange updateAgeRange(AgeRange ag) {
		AgeRange stored=AgeRange.getAgeRangeById(ag.getIdRange());
		stored.setFromAge(ag.getFromAge());
		stored.setToAge(ag.getToAge());
		return AgeRange.updateAgeRange(stored);
	}

	@Override
	public long deleteAgeRange(long ageRangeId) {
		AgeRange ag= AgeRange.getAgeRangeById(ageRangeId);
		/*check if the agerange exits*/
		if(ag==null)
			return 0;
		
		AgeRange.removeAgeRange(ageRangeId);
		return ageRangeId;
	}

	@Override
	public ParametersList readOptimalParametersBySex(String sex) {
		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAllBySex(sex));//get optimal paramters by sex
		return list;
	}

	@Override
	public ParametersList readOptimalParametersBySexAngAgeRange(String sex, int ageFrom, int ageTo) {
		ParametersList list=new ParametersList();
		list.setParameters(Parameter.getAllByAgeRangeAndSex(sex, ageFrom, ageTo)); //get all parameters by sex and ageRanges
		return list;
	}

}
