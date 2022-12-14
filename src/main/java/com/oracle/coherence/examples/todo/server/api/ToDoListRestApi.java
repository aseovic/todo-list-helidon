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
    @Inject
    private ToDoListService api;

    @Inject
    private TaskRepository tasks;

    @Inject
    private Cluster cluster;

    @Context
    private Sse sse;
    private SseBroadcaster broadcaster;

    @PostConstruct
    void createBroadcaster()
        {
        this.broadcaster = sse.newBroadcaster();

        tasks.addListener(
                tasks.listener()
                     .onInsert(this::sendInsert)
                     .onUpdate(this::sendUpdate)
                     .onRemove(this::sendDelete)
                     .build());
        }

    private void sendInsert(Task task)
        {
        broadcaster.broadcast(createEvent("insert", task));
        }

    private void sendUpdate(Task task)
        {
        broadcaster.broadcast(createEvent("update", task));
        }

    private void sendDelete(Task task)
        {
        broadcaster.broadcast(createEvent("delete", task));
        }

    private OutboundSseEvent createEvent(String name, Task task)
        {
        return sse.newEventBuilder()
                    .name(name)
                    .data(Task.class, task)
                    .mediaType(APPLICATION_JSON_TYPE)
                    .build();
        }

    @GET
    @Path("events")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void registerEventListener(@Context SseEventSink eventSink)
        {
        broadcaster.register(eventSink);

        Member member = cluster.getLocalMember();
        eventSink.send(sse.newEvent("begin", member.toString()));
        }

    @POST
    @Consumes(APPLICATION_JSON)
    public Task createTask(JsonObject task)
        {
        return api.createTask(task.getString("description"));
        }

    @GET
    @Produces(APPLICATION_JSON)
    public Collection<? extends Task> getTasks(@QueryParam("completed") Boolean completed)
        {
        return api.getTasks(completed);
        }

    @DELETE
    @Path("{id}")
    public Task deleteTask(@PathParam("id") String id)
        {
        return api.deleteTask(id);
        }

    @DELETE
    public boolean deleteCompletedTasks()
        {
        return api.deleteCompletedTasks();
        }

    @PUT
    @Path("{id}")
    @Consumes(APPLICATION_JSON)
    public Task updateTask(@PathParam("id") String id, Task task)
        {
        Task result = null;

        String  description = task.getDescription();
        Boolean completed   = task.getCompleted();

        if (description != null)
            {
            result = api.updateDescription(id, description);
            }
        else if (completed != null)
            {
            result = api.updateCompletionStatus(id, completed);
            }

        return result == null
               ? api.findTask(id)
               : result;
        }
    }
