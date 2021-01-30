package lu.berscheid.knx.device.automower.rest.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Information about the mowers current status
 */
@ApiModel(description = "Information about the mowers current status")
@Validated
@Data
public class MowerApp {

	/**
	 * Gets or Sets mode
	 */
	public enum ModeEnum {

		MAIN_AREA("MAIN_AREA"),

		SECONDARY_AREA("SECONDARY_AREA"),

		HOME("HOME"),

		DEMO("DEMO"),

		UNKNOWN("UNKNOWN");

		private String value;

		ModeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ModeEnum fromValue(String text) {
			for (ModeEnum b : ModeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("mode")
	@ApiModelProperty(example = "MAIN_AREA", required = true, value = "")
	@NotNull
	private ModeEnum mode = null;

	/**
	 * Gets or Sets activity
	 */
	public enum ActivityEnum {

		UNKNOWN("UNKNOWN"),

		NOT_APPLICABLE("NOT_APPLICABLE"),

		MOWING("MOWING"),

		GOING_HOME("GOING_HOME"),

		CHARGING("CHARGING"),

		LEAVING("LEAVING"),

		PARKED_IN_CS("PARKED_IN_CS"),

		STOPPED_IN_GARDEN("STOPPED_IN_GARDEN");

		private String value;

		ActivityEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ActivityEnum fromValue(String text) {
			for (ActivityEnum b : ActivityEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("activity")
	@ApiModelProperty(example = "MOWING", required = true, value = "")
	@NotNull
	private ActivityEnum activity = null;

	/**
	 * Gets or Sets state
	 */
	public enum StateEnum {

		UNKNOWN("UNKNOWN"),

		NOT_APPLICABLE("NOT_APPLICABLE"),

		PAUSED("PAUSED"),

		IN_OPERATION("IN_OPERATION"),

		WAIT_UPDATING("WAIT_UPDATING"),

		WAIT_POWER_UP("WAIT_POWER_UP"),

		RESTRICTED("RESTRICTED"),

		OFF("OFF"),

		STOPPED("STOPPED"),

		ERROR("ERROR"),

		FATAL_ERROR("FATAL_ERROR"),

		ERROR_AT_POWER_UP("ERROR_AT_POWER_UP");

		private String value;

		StateEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StateEnum fromValue(String text) {
			for (StateEnum b : StateEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("state")
	@ApiModelProperty(example = "IN_OPERATION", required = true, value = "")
	@NotNull
	private StateEnum state = null;

	@JsonProperty("errorCode")
	@ApiModelProperty(example = "0", value = "")
	@Min(0)
	private Integer errorCode = null;

	@JsonProperty("errorCodeTimestamp")
	@ApiModelProperty(example = "0",
			value = "Timestamp for the last error code in milliseconds since 1970-01-01T00:00:00 in local time. NOTE! This timestamp is in local time for the mower and is coming directly from the mower.")
	@Min(0L)
	private Long errorCodeTimestamp = null;

}
