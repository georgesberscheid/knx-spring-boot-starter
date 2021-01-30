package lu.berscheid.knx.device.automower.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A data list document compliant with the JSON API Specification.
 */
@ApiModel(description = "A data list document compliant with the JSON API Specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class JsonApiDataListDocument {

	@JsonProperty("data")
	@Valid
	private List<JsonApiData> data = null;

	public JsonApiDataListDocument data(List<JsonApiData> data) {
		this.data = data;
		return this;
	}

	public JsonApiDataListDocument addDataItem(JsonApiData dataItem) {
		if (this.data == null) {
			this.data = new ArrayList<JsonApiData>();
		}
		this.data.add(dataItem);
		return this;
	}

	/**
	 * An array of primary data objects.
	 * 
	 * @return data
	 **/
	@ApiModelProperty(value = "An array of primary data objects.")
	@Valid
	public List<JsonApiData> getData() {
		return data;
	}

	public void setData(List<JsonApiData> data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JsonApiDataListDocument jsonApiDataListDocument = (JsonApiDataListDocument) o;
		return Objects.equals(this.data, jsonApiDataListDocument.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JsonApiDataListDocument {\n");

		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
