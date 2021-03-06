package UMA_PermissionEndpoint;

import UMA_PermissionEndpoint.dto.*;
import UMA_PermissionEndpoint.PermissionApiService;
import UMA_PermissionEndpoint.factories.PermissionApiServiceFactory;

import io.swagger.annotations.ApiParam;

import UMA_PermissionEndpoint.dto.PTFailDTO;
import UMA_PermissionEndpoint.dto.PTSuccessDTO;
import UMA_PermissionEndpoint.dto.ResourceDetailsDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/permission")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/permission", description = "the permission API")
public class PermissionApi  {

   private final PermissionApiService delegate = PermissionApiServiceFactory.getPermissionApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Permission Endpoint.", notes = "This API is used by Resource Server to request permissions on Client's Behalf With Authorization Server.\n", response = PTSuccessDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Bad Request") })

    public Response registerPermission(@ApiParam(value = "" ,required=true )@HeaderParam("patToken") String patToken,
    @ApiParam(value = "The requested resource."  ) ResourceDetailsDTO requestedResource)
    {
    return delegate.registerPermission(patToken,requestedResource);
    }
}

