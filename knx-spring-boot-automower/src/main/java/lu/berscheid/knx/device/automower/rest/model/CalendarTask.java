package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * CalendarTask
 */
@Validated
@Data
public class CalendarTask {

	@JsonProperty("start")
	@ApiModelProperty(example = "420",
			required = true,
			value = "Start time expressed in minutes after midnight.")
	@NotNull
	@Min(0)
	@Max(1439)
	private Integer start = null;

	@JsonProperty("duration")
	@ApiModelProperty(example = "780",
			required = true,
			value = "Duration time expressed in minutes.")
	@NotNull
	@Min(1)
	@Max(1440)
	private Integer duration = null;

	@JsonProperty("monday")
	@ApiModelProperty(required = true, value = "Enabled on Mondays")
	private Boolean monday = null;

	@JsonProperty("tuesday")
	@ApiModelProperty(required = true, value = "Enabled on Tuesdays")
	private Boolean tuesday = null;

	@JsonProperty("wednesday")
	@ApiModelProperty(required = true, value = "Enabled on Wednesdays")
	private Boolean wednesday = null;

	@JsonProperty("thursday")
	@ApiModelProperty(required = true, value = "Enabled on Thursdays")
	private Boolean thursday = null;

	@JsonProperty("friday")
	@ApiModelProperty(required = true, value = "Enabled on Fridays")
	private Boolean friday = null;

	@JsonProperty("saturday")
	@ApiModelProperty(required = true, value = "Enabled on Saturdays")
	private Boolean saturday = null;

	@JsonProperty("sunday")
	@ApiModelProperty(required = true, value = "Enabled on Sundays")
	private Boolean sunday = null;
}
