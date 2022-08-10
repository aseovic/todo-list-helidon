/*
 * Copyright (c) 2021, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */

package com.oracle.coherence.examples.todo.server.api;

import com.oracle.coherence.examples.todo.server.Task;
import com.oracle.coherence.examples.todo.server.ToDoListService;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

/**
 * GraphQL facade for To Do list API.
 *
 * @author Tim Middleton
 */
@GraphQLApi
@ApplicationScoped
public class ToDoListGraphQLApi
    {
    // TODO: add implementation here
    }
