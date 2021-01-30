package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * A primary data object compliant with the JSON API Specification.
 */
@ApiModel(description = "A primary data object compliant with the JSON API Specification.")
@Validated
@Data
public class JsonApiData {

	@JsonProperty("type")
	@ApiModelProperty(example = "mower", value = "The type of the data object.")
	private String type = null;

	@JsonProperty("id")
	@ApiModelProperty(example = "256b2365-33a7-46fe-a9fb-e67e84f4ac01",
			value = "The identity of the data object")
	private String id = null;

	@JsonProperty("attributes")
	@ApiModelProperty(value = "")
	@Valid
	private MowerData attributes = null;

	public JsonApiData() {
	}

	public JsonApiData(String type) {
		this(type, null);
	}

	public JsonApiData(String type, MowerData attributes) {
		this.type = type;
		this.attributes = attributes;
	}
}
