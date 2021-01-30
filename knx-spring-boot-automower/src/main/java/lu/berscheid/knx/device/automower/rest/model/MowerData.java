package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * A mower data object.
 */
@ApiModel(description = "A mower data object.")
@Validated
@Data
public class MowerData {

	@JsonProperty("system")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private System system = null;

	@JsonProperty("battery")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private Battery battery = null;

	@JsonProperty("mower")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private MowerApp mower = null;

	@JsonProperty("calendar")
	@ApiModelProperty(value = "")
	private Calendar calendar = null;

	@JsonProperty("planner")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private Planner planner = null;

	@JsonProperty("metadata")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private Metadata metadata = null;
}
