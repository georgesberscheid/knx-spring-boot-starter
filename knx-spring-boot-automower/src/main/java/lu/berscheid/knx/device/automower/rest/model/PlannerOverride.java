package lu.berscheid.knx.device.automower.rest.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 */
@ApiModel(description = "TODO")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class PlannerOverride {

	/**
	 * Gets or Sets action
	 */
	public enum ActionEnum {

		NOT_ACTIVE("NOT_ACTIVE"),

		FORCE_PARK("FORCE_PARK"),

		FORCE_MOW("FORCE_MOW");

		private String value;

		ActionEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ActionEnum fromValue(String text) {
			for (ActionEnum b : ActionEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("action")
	private ActionEnum action = null;

	public PlannerOverride action(ActionEnum action) {
		this.action = action;
		return this;
	}

	/**
	 * Get action
	 * 
	 * @return action
	 **/
	@ApiModelProperty(example = "FORCE_MOW", required = true, value = "")
	@NotNull

	public ActionEnum getAction() {
		return action;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlannerOverride plannerOverride = (PlannerOverride) o;
		return Objects.equals(this.action, plannerOverride.action);
	}

	@Override
	public int hashCode() {
		return Objects.hash(action);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlannerOverride {\n");

		sb.append("    action: ").append(toIndentedString(action)).append("\n");
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
