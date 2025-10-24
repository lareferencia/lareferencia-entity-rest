package org.lareferencia.app.rest.controller;

import java.util.List;

import org.lareferencia.core.entity.indexing.service.IEntity;
import org.lareferencia.core.entity.search.service.IEntitySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "Search", tags = "default")
@RequestMapping("/search")
@Configuration
public class EntitySearchController {

    // Commented out to avoid Solr dependency issues
    // @Autowired
    // @Qualifier("entitySearchServiceSolrImpl")
    // IEntitySearchService service;

    // @ApiOperation(value = "Returns a list of entities for a certain {type}")
    // @ApiResponses(value = { @ApiResponse(code = 200, message = "Returns a list of
    // entities for a certain {type}") })
    // @RequestMapping(value = "/lis/{type}", method = RequestMethod.GET)
    // HttpEntity<Page<? extends IEntity>> persons(@PathVariable("type") String
    // entityType, Pageable pageable) {
    //
    // Page<? extends IEntity> entities = service.listEntitiesByType(entityType,
    // pageable);
    // return new ResponseEntity<>(entities, HttpStatus.OK);
    // }

    // Commented out to avoid Solr dependency issues
    /*
    @ApiOperation(value = "Returns a list of entities for a certain {type} with entity fields containing {expressions}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of entities for a certain {type} with entity fields containing {expressions}") })
    @RequestMapping(value = "/entity/{type}", method = RequestMethod.GET)
    @ApiImplicitParams({ @ApiImplicitParam(name = "sort", value = "Sorting criteria in the format: property,(asc|desc) "
            + "Default sort order is ascending. "
            + "Multiple sort criteria are supported.", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of records per page.", defaultValue = "10", dataType = "integer", required = false, paramType = "query"),
            @ApiImplicitParam(name = "page", value = "Results page you want to retrieve (0..N)", defaultValue = "0", dataType = "integer", required = false, paramType = "query"), })
    HttpEntity<Page<? extends IEntity>> searchEntitiesByTypeAndFieldExpresions(@PathVariable("type") String entityType,
            @RequestParam(required = false) List<String> fieldExpressions,
            @ApiIgnore("Ignored because swagger ui shows the wrong params, "
                    + "instead they are explained in the implicit params") @NonNull @PageableDefault() Pageable pageable) {

        Page<? extends IEntity> entities = service.searchEntitiesByTypeAndFields(entityType, fieldExpressions,
                pageable);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
    */

   

}
