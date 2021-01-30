package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Information about the battery in the mower
 */
@ApiModel(description = "Information about the battery in the mower")
@Validated
@Data
public class Battery {

	@JsonProperty("batteryPercent")
	@ApiModelProperty(example = "77",
			required = true,
			value = "The current battery level percentage")
	@NotNull
	@Min(0)
	@Max(100)
	private Integer batteryPercent = null;

}
