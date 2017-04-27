package myhealtylife.optimalparamters.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.entity.Parameter;

/**
 * This class is used in order to encapsulate a list of paramaters in a object
 * @author stefano
 *
 */
@XmlRootElement(name="parametersList")
public class ParametersList {
	private List<Parameter> parameters;

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
}
