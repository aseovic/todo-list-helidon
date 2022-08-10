/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */

package com.oracle.coherence.examples.todo.server.api;

import com.oracle.coherence.examples.todo.server.Task;
import com.oracle.coherence.examples.todo.server.TaskRepository;
import com.oracle.coherence.examples.todo.server.ToDoListService;
import com.tangosol.net.Cluster;
import com.tangosol.net.Member;

import java.util.Collection;

import java.util.function.Consumer;
import javax.annotation.PostConstruct;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.json.JsonObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

/**
 * REST facade for To Do list API.
 */
@Path("/api/tasks")
@ApplicationScoped
public class ToDoListRestApi
    {
    // TODO: add implementation here
    }
