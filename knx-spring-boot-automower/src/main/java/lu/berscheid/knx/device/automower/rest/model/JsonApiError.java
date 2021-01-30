package lu.berscheid.knx.device.automower.rest.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A primary error object compliant with the JSON API Specification.
 */
@ApiModel(description = "A primary error object compliant with the JSON API Specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
		date = "2021-01-17T12:31:35.503362800+01:00[Europe/Luxembourg]")

public class JsonApiError {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("detail")
	private String detail = null;

	public JsonApiError id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A unique identifier for this particular occurrence of the problem.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "f41d9bbd-abc3-4c4b-b68c-b0079bb10820",
			value = "A unique identifier for this particular occurrence of the problem.")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JsonApiError status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * The HTTP status code applicable to this problem, expressed as a string value.
	 * 
	 * @return status
	 **/
	@ApiModelProperty(example = "nnn",
			value = "The HTTP status code applicable to this problem, expressed as a string value.")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JsonApiError code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * An application specific error code, expressed as a string value.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(example = "some.error.code",
			value = "An application specific error code, expressed as a string value.")

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public JsonApiError title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * A short, human readable summary of the problem that should not change from occurrence to
	 * occurrence of the problem, except for purposes of localization.
	 * 
	 * @return title
	 **/
	@ApiModelProperty(example = "Some summary of the problem",
			value = "A short, human readable summary of the problem that should not change from occurrence to occurrence of the problem, except for purposes of localization.")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JsonApiError detail(String detail) {
		this.detail = detail;
		return this;
	}

	/**
	 * A human readable explanation specific to this occurrence of the problem. Like title, this
	 * value can be localized.
	 * 
	 * @return detail
	 **/
	@ApiModelProperty(example = "Some details about the specific problem.",
			value = "A human readable explanation specific to this occurrence of the problem. Like title, this value can be localized.")

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JsonApiError jsonApiError = (JsonApiError) o;
		return Objects.equals(this.id, jsonApiError.id)
				&& Objects.equals(this.status, jsonApiError.status)
				&& Objects.equals(this.code, jsonApiError.code)
				&& Objects.equals(this.title, jsonApiError.title)
				&& Objects.equals(this.detail, jsonApiError.detail);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status, code, title, detail);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JsonApiError {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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
