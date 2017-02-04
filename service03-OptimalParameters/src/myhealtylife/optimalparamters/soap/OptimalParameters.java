package myhealtylife.optimalparamters.soap;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import myhealtylife.optimalparamters.model.AgeRangeList;
import myhealtylife.optimalparamters.model.ParametersList;
import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.model.entity.Parameter;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface OptimalParameters {

	@WebMethod(operationName="readOptimalParameters")
	@WebResult(name="parametersList")
	public ParametersList readOptimalParameters();
	
	@WebMethod(operationName="readOptimalParametersByAgeAndSex")
	@WebResult(name="parametersList")
	public ParametersList readOptimalParametersByAgeAndSex(Integer age, String sex);
	
	@WebMethod(operationName="readOptimalParametersByNameAgeAndSex")
	@WebResult(name="parametersList")
	public ParametersList readOptimalParametersByNameAgeAndSex(Integer age,String parameterName ,String sex);
	
	@WebMethod(operationName="createParameter")
	@WebResult(name="parameter")
	public Parameter createParameter(Parameter p);
	
	@WebMethod(operationName="updateParameter")
	@WebResult(name="parameter")
	public Parameter updateParameter(Parameter p);
	
	@WebMethod(operationName="deleteParameter")
	@WebResult(name="idParameter")
	public Long deleteParameter(Long parameterId);
	
	@WebMethod(operationName="readAgeRanges")
	@WebResult(name="AgeRangeList")
	public AgeRangeList readAgeRanges();
	
	@WebMethod(operationName="createAgeRange")
	@WebResult(name="AgeRange")
	public AgeRange createAgeRange();
	
	@WebMethod(operationName="updateAgeRange")
	@WebResult(name="AgeRange")
	public AgeRange updateAgeRange(AgeRange ag);
	
	@WebMethod(operationName="deleteAgeRange")
	@WebResult(name="idAgeRange")
	public Long deleteAgeRange(Long ageRangeId);
	
	
}
