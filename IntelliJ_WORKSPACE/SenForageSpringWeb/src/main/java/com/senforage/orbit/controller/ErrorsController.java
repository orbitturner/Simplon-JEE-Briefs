package com.senforage.orbit.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/* === 🌌 WELCOME TO ORBIT SPACESHIP 🌌  ===
 *
 *     Project : SenForageSpringWeb
 *	  By :
 *
 *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗
 *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
 *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
 *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
 *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
 *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
 *
 *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal
 *                              GITHUB : /orbitturner    -   Website: http://orbitturner.com/
 */
@Controller
public class ErrorsController implements ErrorController {

    /**
     * Handle every Http Request and do the Corresponding Job
     * @param httpRequest
     * @return ModelAndView
     */
    @GetMapping("/error")
    public ModelAndView orbitErrorHandler(HttpServletRequest httpRequest) {
        //================= SETUP OF VIEW LOADER =================
        ModelAndView errorPage = new ModelAndView();
        String errorMsg = "";
        String viewName = "/home";
        //========================================================
        // Get The Http Request Code Generated
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            // handle HTTP 400 Bad Request error
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                viewName = "error/400";
                break;
            }
            // handle HTTP 403 Forbidden error
            case 403: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                viewName = "error/403";
                break;
            }
            // handle HTTP 404 Not Found error
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                viewName = "error/404";
                break;
            }
            // handle HTTP 500 Internal Server error
            /*case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                viewName = "error/500";
                break;
            }*/
            default:{
                return new ModelAndView("redirect:/home");
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.setViewName(viewName);

        return errorPage;
    }

    /**
     * Gets The Error code Generated in the Requesr
     * @param httpRequest
     * @return Integer
     */
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }

    @Override
    @Deprecated
    public String getErrorPath() {
        return null;
    }
}
