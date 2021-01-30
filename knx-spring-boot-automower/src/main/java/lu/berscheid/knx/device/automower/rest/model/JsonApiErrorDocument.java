package lu.berscheid.knx.device.automower.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An error document compliant with the JSON API Specification.
 */
@ApiModel(description = "An error document compliant with the JSON API Specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class JsonApiErrorDocument {

	@JsonProperty("errors")
	@Valid
	private List<JsonApiError> errors = null;

	public JsonApiErrorDocument errors(List<JsonApiError> errors) {
		this.errors = errors;
		return this;
	}

	public JsonApiErrorDocument addErrorsItem(JsonApiError errorsItem) {
		if (this.errors == null) {
			this.errors = new ArrayList<JsonApiError>();
		}
		this.errors.add(errorsItem);
		return this;
	}

	/**
	 * Get errors
	 * 
	 * @return errors
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<JsonApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<JsonApiError> errors) {
		this.errors = errors;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JsonApiErrorDocument jsonApiErrorDocument = (JsonApiErrorDocument) o;
		return Objects.equals(this.errors, jsonApiErrorDocument.errors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errors);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JsonApiErrorDocument {\n");

		sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first
	 * line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
