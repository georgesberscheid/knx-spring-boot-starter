package lu.berscheid.knx.device.automower.rest.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the planner
 */
@ApiModel(description = "Information about the planner")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class Planner {

	@JsonProperty("nextStartTimestamp")
	private Long nextStartTimestamp = null;

	@JsonProperty("override")
	private PlannerOverride override = null;

	/**
	 * Gets or Sets restrictedReason
	 */
	public enum RestrictedReasonEnum {

		NONE("NONE"),

		WEEK_SCHEDULE("WEEK_SCHEDULE"),

		PARK_OVERRIDE("PARK_OVERRIDE"),

		SENSOR("SENSOR"),

		DAILY_LIMIT("DAILY_LIMIT");

		private String value;

		RestrictedReasonEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static RestrictedReasonEnum fromValue(String text) {
			for (RestrictedReasonEnum b : RestrictedReasonEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("restrictedReason")
	private RestrictedReasonEnum restrictedReason = null;

	public Planner nextStartTimestamp(Long nextStartTimestamp) {
		this.nextStartTimestamp = nextStartTimestamp;
		return this;
	}

	/**
	 * Timestamp for the next auto start in milliseconds since 1970-01-01T00:00:00 in local time. If
	 * the mower is charging then the value is the estimated time when it will be leaving the
	 * charging station. If the value is 0 then the mower should start now. NOTE! This timestamp is
	 * in local time for the mower and is coming directly from the mower.
	 * 
	 * @return nextStartTimestamp
	 **/
	@ApiModelProperty(example = "0",
			required = true,
			value = "Timestamp for the next auto start in milliseconds since 1970-01-01T00:00:00 in local time.  If the mower is charging then the value is the estimated time when it will be leaving the charging station.  If the value is 0 then the mower should start now.  NOTE! This timestamp is in local time for the mower and is coming directly from the mower.")
	@NotNull

	public Long getNextStartTimestamp() {
		return nextStartTimestamp;
	}

	public void setNextStartTimestamp(Long nextStartTimestamp) {
		this.nextStartTimestamp = nextStartTimestamp;
	}

	public Planner override(PlannerOverride override) {
		this.override = override;
		return this;
	}

	/**
	 * Get override
	 * 
	 * @return override
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public PlannerOverride getOverride() {
		return override;
	}

	public void setOverride(PlannerOverride override) {
		this.override = override;
	}

	public Planner restrictedReason(RestrictedReasonEnum restrictedReason) {
		this.restrictedReason = restrictedReason;
		return this;
	}

	/**
	 * Get restrictedReason
	 * 
	 * @return restrictedReason
	 **/
	@ApiModelProperty(example = "PARK_OVERRIDE", required = true, value = "")
	@NotNull

	public RestrictedReasonEnum getRestrictedReason() {
		return restrictedReason;
	}

	public void setRestrictedReason(RestrictedReasonEnum restrictedReason) {
		this.restrictedReason = restrictedReason;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Planner planner = (Planner) o;
		return Objects.equals(this.nextStartTimestamp, planner.nextStartTimestamp)
				&& Objects.equals(this.override, planner.override)
				&& Objects.equals(this.restrictedReason, planner.restrictedReason);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nextStartTimestamp, override, restrictedReason);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Planner {\n");

		sb.append("    nextStartTimestamp: ").append(toIndentedString(nextStartTimestamp))
				.append("\n");
		sb.append("    override: ").append(toIndentedString(override)).append("\n");
		sb.append("    restrictedReason: ").append(toIndentedString(restrictedReason)).append("\n");
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
