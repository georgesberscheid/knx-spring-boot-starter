package lu.berscheid.knx.device.automower.rest.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * System information about a mower
 */
@ApiModel(description = "System information about a mower")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class System {

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("model")
	private String model = null;

	@JsonProperty("serialNumber")
	private String serialNumber = null;

	public System name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name given to the mower by the user
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "My Mower",
			required = true,
			value = "The name given to the mower by the user")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public System model(String model) {
		this.model = model;
		return this;
	}

	/**
	 * The model of the mower
	 * 
	 * @return model
	 **/
	@ApiModelProperty(example = "450x", required = true, value = "The model of the mower")
	@NotNull

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public System serialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	/**
	 * The serial number for the mower
	 * 
	 * @return serialNumber
	 **/
	@ApiModelProperty(example = "701009001",
			required = true,
			value = "The serial number for the mower")
	@NotNull

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		System system = (System) o;
		return Objects.equals(this.name, system.name) && Objects.equals(this.model, system.model)
				&& Objects.equals(this.serialNumber, system.serialNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, model, serialNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class System {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    model: ").append(toIndentedString(model)).append("\n");
		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
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
