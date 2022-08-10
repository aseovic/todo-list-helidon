package com.oracle.coherence.examples.todo.server.api;

import com.oracle.coherence.examples.todo.server.Task;
import com.oracle.coherence.examples.todo.server.TaskRepository;
import com.oracle.coherence.examples.todo.server.ToDoListService;

import io.grpc.stub.StreamObserver;

import io.helidon.microprofile.grpc.core.Grpc;
import io.helidon.microprofile.grpc.core.GrpcMarshaller;
import io.helidon.microprofile.grpc.core.ServerStreaming;
import io.helidon.microprofile.grpc.core.Unary;

import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * gRPC facade for To Do List API that uses JSON marshaller.
 *
 * @author Aleks Seovic  2021.02.28
 */
@Grpc(name = "examples.json.ToDoList")
@GrpcMarshaller("json")
@ApplicationScoped
public class ToDoListGrpcApi
    {
    // TODO: add implementation here

    // ---- request messages ------------------------------------------------

    public static class UpdateDescriptionRequest
        {
        public String id;
        public String description;
        }

    public static class UpdateCompletionStatusRequest
        {
        public String id;
        public boolean completed;
        }
    }
