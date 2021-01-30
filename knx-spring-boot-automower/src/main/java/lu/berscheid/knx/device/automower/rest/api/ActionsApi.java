package lu.berscheid.knx.device.automower.rest.api;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lu.berscheid.knx.device.automower.rest.config.FeignClientConfiguration;
import lu.berscheid.knx.device.automower.rest.model.JsonApiErrorDocument;

@Api(value = "Actions", description = "the Actions API")
@FeignClient(contextId = "ActionsApiClient",
		name = "actions",
		url = "${automowerConnect_.url:https://api.amc.husqvarna.dev/v1}",
		configuration = FeignClientConfiguration.class)
public interface ActionsApi {

	@ApiOperation(value = "Accepts actions to control mowers",
			nickname = "mowersIdActionsPost",
			notes = "Accepts actions to control mowers",
			authorizations = { @Authorization(value = "APIKeyHeader"),
					@Authorization(value = "Provider"), @Authorization(value = "Token") },
			tags = { "Actions", })
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "The action was accepted and is being processed"),
			@ApiResponse(code = 400,
					message = "Failure, bad request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 403,
					message = "Failure, unauthorized request.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 500,
					message = "Error, unknown internal server error.",
					response = JsonApiErrorDocument.class),
			@ApiResponse(code = 503,
					message = "Error, unavailable internal server.",
					response = JsonApiErrorDocument.class) })
	@RequestMapping(value = "/mowers/{id}/actions",
			produces = "application/vnd.api+json,application/vnd.api+json,application/vnd.api+json,application/vnd.api+json",
			consumes = "application/json",
			method = RequestMethod.POST)
	ResponseEntity<Void> mowersIdActionsPost(
			@ApiParam(value = "Identity of the mower.", required = true) @PathVariable("id") String id,
			@ApiParam(value = "A single action", required = true) @Valid @RequestBody Object body);

}
