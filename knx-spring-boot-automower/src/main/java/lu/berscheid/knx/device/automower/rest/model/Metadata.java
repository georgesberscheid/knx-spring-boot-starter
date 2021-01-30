package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Information about the planner
 */
@ApiModel(description = "Information about the planner")
@Validated
@Data
public class Metadata {

	@JsonProperty("connected")
	@ApiModelProperty(example = "true", required = true, value = "Is the mower currently connected")
	@NotNull
	private Boolean connected = null;

	@JsonProperty("statusTimestamp")
	@ApiModelProperty(example = "0", required = true, value = "")
	@NotNull
	private Long statusTimestamp = null;
}
