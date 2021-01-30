package lu.berscheid.knx.device.automower.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lu.berscheid.knx.device.automower.rest.config.FeignClientConfiguration;
import lu.berscheid.knx.device.automower.rest.model.JsonApiDataDocument;
import lu.berscheid.knx.device.automower.rest.model.JsonApiDataListDocument;
import lu.berscheid.knx.device.automower.rest.model.JsonApiErrorDocument;

@Api(value = "Mower", description = "the Mower API")
@FeignClient(contextId = "MowerApiClient",
		name = "mower",
		url = "${automowerConnect_.url:https://api.amc.husqvarna.dev/v1}",
		configuration = FeignClientConfiguration.class)
public interface MowerApi {

	@ApiOperation(value = "List data for all mowers linked to a user.",
			nickname = "mowersGet",
			notes = "List data for all mowers linked to the user associated with the access token.",
			response = JsonApiDataListDocument.class,
			authorizations = { @Authorization(value = "APIKeyHeader"),
					@Authorization(value = "Provider"), @Authorization(value = "Token") },
			tags = { "Mower", })
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					message = "Success, response body contains data.",
					response = JsonApiDataListDocument.class),
			@ApiResponse(code = 400,
					message = "Failure, bad request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 403,
					message = "Failure, unauthorized request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 404,
					message = "Failure, requested resource not found.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 500,
					message = "Error, unknown internal server error.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 503,
					message = "Error, unavailable internal server.",
					response = JsonApiErrorDocument.class) })
	@RequestMapping(value = "/mowers",
			produces = "application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json",
			method = RequestMethod.GET)
	ResponseEntity<JsonApiDataListDocument> mowersGet();

	@ApiOperation(value = "Get data for a mower linked to a user.",
			nickname = "mowersIdGet",
			notes = "Get data for a mower linked to the user associated with the access token.",
			response = JsonApiDataDocument.class,
			authorizations = { @Authorization(value = "APIKeyHeader"),
					@Authorization(value = "Provider"), @Authorization(value = "Token") },
			tags = { "Mower", })
	@ApiResponses(value = { @ApiResponse(code = 200,
			message = "Success, response body contains data. Empty if valid mower id but mower id could not be found",
			response = JsonApiDataDocument.class),
			@ApiResponse(code = 400,
					message = "Failure, bad request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 403,
					message = "Failure, unauthorized request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 404,
					message = "Failure, requested resource not found.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 500,
					message = "Error, unknown internal server error.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 503,
					message = "Error, unavailable internal server.",
					response = JsonApiErrorDocument.class) })
	@RequestMapping(value = "/mowers/{id}",
			produces = "application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json",
			method = RequestMethod.GET)
	ResponseEntity<JsonApiDataDocument> mowersIdGet(@ApiParam(value = "Identity of the mower.",
			required = true) @PathVariable("id") String id);

}
