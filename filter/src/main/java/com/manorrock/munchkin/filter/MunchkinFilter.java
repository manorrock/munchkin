/*
 *  Copyright (c) 2002-2020, Manorrock.com. All Rights Reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *      1. Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *
 *      2. Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 *  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 *  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 */
package com.manorrock.munchkin.filter;

import java.io.IOException;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;
import static javax.servlet.DispatcherType.ERROR;
import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.INCLUDE;
import static javax.servlet.DispatcherType.REQUEST;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * The Birman authentication filter.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@WebFilter(
        filterName = "MunchkinFilter",
        urlPatterns = {"/*"},
        dispatcherTypes = {REQUEST, FORWARD, ERROR, INCLUDE}
)
public class MunchkinFilter implements Filter {

    /**
     * Stores the logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MunchkinFilter.class.getPackage().getName());

    /**
     * Stores the filter config.
     */
    private FilterConfig config;

    /**
     * Do filter processing.
     *
     * @param request the request.
     * @param response the response.
     * @param chain the filter chain.
     * @exception IOException when an I/O error occurs.
     * @exception ServletException when a Servlet error occurs.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if (LOGGER.isLoggable(INFO)) {
            LOGGER.log(INFO, "Processing MunchkinFilter request");
        }
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            throw new ServletException(t);
        }
    }

    /**
     * Destroy the filter.
     */
    @Override
    public void destroy() {
        if (LOGGER.isLoggable(INFO)) {
            LOGGER.log(INFO, "Destroying MunchkinFilter");
        }
    }

    /**
     * Initialize the filter.
     *
     * @param config the filter config.
     */
    @Override
    public void init(FilterConfig config) {
        if (LOGGER.isLoggable(INFO)) {
            LOGGER.log(INFO, "Initializing MunchkinFilter");
        }
        this.config = config;
    }
}
