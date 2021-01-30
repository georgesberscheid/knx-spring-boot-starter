package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DurationAttributes
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DurationAttributes {

	@JsonProperty("duration")
	@ApiModelProperty(required = true, value = "")
	@NotNull
	private Long duration = null;
}
