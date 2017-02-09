package myhealtylife.optimalparamters.soap;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParameterList;

import myhealtylife.optimalparamters.model.AgeRangeList;
import myhealtylife.optimalparamters.model.ParametersList;
import myhealtylife.optimalparamters.model.entity.AgeRange;
import myhealtylife.optimalparamters.model.entity.Parameter;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface OptimalParameters {

	@WebMethod(operationName="readOptimalParameters")
	@WebResult(name="parametersList")
	/**
	 * get the list of available parameters.
	 * @return
	 */
	public ParametersList readOptimalParameters();
	
	@WebMethod(operationName="readOptimalParametersBySex")
	@WebResult(name="parametersList")
	/**
	 * this method returns the list of paramters filtered by sex;
	 * @return
	 */
	public ParametersList readOptimalParametersBySex(String sex);
	
	@WebMethod(operationName="readOptimalParametersBySexAngAgeRange")
	@WebResult(name="parametersList")
	/**
	 * this method returns the list of paramters filtered by sex and the ageRange
	 * @param sex
	 * @param ageFrom
	 * @return
	 */
	public ParametersList readOptimalParametersBySexAngAgeRange(String sex, int ageFrom, int ageTo);
	
	@WebMethod(operationName="readOptimalParametersByAgeAndSex")
	@WebResult(name="parametersList")
	/**
	 * returns a list of Parameter object filtered by sex and age
	 * @param age
	 * @param sex "M" for male of "F" for female
	 * @return
	 */
	public ParametersList readOptimalParametersByAgeAndSex(Integer age, String sex);
	
	@WebMethod(operationName="readOptimalParametersByNameAgeAndSex")
	@WebResult(name="parametersList")
	/**
	 * returns a list of Parameter object filtered by sex, age and name of the parameter.
	 * @param age
	 * @param parameterName
	 * @param sex
	 * @return
	 */
	public ParametersList readOptimalParametersByNameAgeAndSex(Integer age,String parameterName ,String sex);
	
	@WebMethod(operationName="createParameter")
	@WebResult(name="parameter")
	/**
	 * Save a new parameter into the database.
	 * @param p the parameter to save.
	 * @return
	 */
	public Parameter createParameter(Parameter p);
	
	@WebMethod(operationName="updateParameter")
	@WebResult(name="parameter")
	/**
	 * Update an already existing parameter
	 * @param p parameter to update
	 * @return
	 */
	public Parameter updateParameter(Parameter p);
	
	@WebMethod(operationName="deleteParameter")
	@WebResult(name="idParameter")
	/**
	 * delete a parameter from database
	 * @param parameterId
	 * @return
	 */
	public long deleteParameter(long parameterId);
	
	@WebMethod(operationName="readAgeRanges")
	@WebResult(name="AgeRangeList")
	/**
	 * returns the list of available AgeRange
	 * @return
	 */
	public AgeRangeList readAgeRanges();
	
	@WebMethod(operationName="createAgeRange")
	@WebResult(name="AgeRange")
	/**
	 * create a new AgeRange
	 * @param ag AgeRange which will be saved into the database
	 * @return
	 */
	public AgeRange createAgeRange(AgeRange ag);
	
	@WebMethod(operationName="updateAgeRange")
	@WebResult(name="AgeRange")
	/**
	 * update an already existing AgeRange
	 * @param ag AgeRange which will be updated
	 * @return
	 */
	public AgeRange updateAgeRange(AgeRange ag);
	
	@WebMethod(operationName="deleteAgeRange")
	@WebResult(name="idAgeRange")
	/**
	 * delete an AgeRange
	 * @param ageRangeId
	 * @return
	 */
	public long deleteAgeRange(long ageRangeId);
	
	
}
