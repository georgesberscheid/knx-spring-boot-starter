package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * A data document compliant with the JSON API Specification.
 */
@ApiModel(description = "A data document compliant with the JSON API Specification.")
@Validated
@Data
public class JsonApiDataDocument {

	@JsonProperty("data")
	@ApiModelProperty(value = "")
	@Valid
	private JsonApiData data = null;

	public JsonApiDataDocument() {
	}

	public JsonApiDataDocument(JsonApiData data) {
		this.data = data;
	}
}
