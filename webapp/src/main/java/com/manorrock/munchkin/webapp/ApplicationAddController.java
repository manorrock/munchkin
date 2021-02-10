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
package com.manorrock.munchkin.webapp;

import com.manorrock.munchkin.shared.MunchkinApplication;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * The controller for adding an application.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Named("applicationAdd")
@RequestScoped
public class ApplicationAddController {

    /**
     * Stores the one and only application.
     */
    @Inject
    private Application application;
    
    /**
     * Add an application.
     *
     * @param request the HTTP servlet request.
     * @param facesContext the Faces context.
     * @return /index.xhtml
     */
    public String add(HttpServletRequest request, FacesContext facesContext) {
        if (request.getParameter("name") != null) {
            MunchkinApplication app = new MunchkinApplication();
            app.setName(request.getParameter("name"));
            application.getApplications().add(app);
            try {
                facesContext.getExternalContext().redirect("/ui/");
                facesContext.responseComplete();
            } catch (IOException ioe) {
            }
        }
        return "/WEB-INF/ui/application/add.xhtml";
    }
}
