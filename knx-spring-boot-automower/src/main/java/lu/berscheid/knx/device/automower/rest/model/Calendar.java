package lu.berscheid.knx.device.automower.rest.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the planner
 */
@ApiModel(description = "Information about the planner")
@Validated
public class Calendar {

	@JsonProperty("tasks")
	@ApiModelProperty(value = "")
	@Valid
	private List<CalendarTask> tasks = null;

	public Calendar tasks(List<CalendarTask> tasks) {
		this.tasks = tasks;
		return this;
	}
}
