/*
 * Copyright (c) 2021, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */

package com.oracle.coherence.examples.todo.server;

import com.tangosol.util.Filter;

import java.util.Collection;
import java.util.Objects;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.ws.rs.NotFoundException;

import static com.tangosol.util.Filters.always;
import static com.tangosol.util.Filters.equal;
import static com.tangosol.util.Filters.isTrue;

/**
 * To Do List API implementation that can be used by all API facades.
 *
 * @author Aleks Seovic
 */
@ApplicationScoped
public class ToDoListService
    {
    @Inject
    protected TaskRepository tasks;

    // TODO: add implementation here
    }
