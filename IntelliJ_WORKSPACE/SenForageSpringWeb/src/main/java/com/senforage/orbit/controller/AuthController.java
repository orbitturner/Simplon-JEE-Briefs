package com.senforage.orbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/auth")
public class AuthController {

    private ModelAndView render = new ModelAndView ();

    //	request for the security configuration
    @GetMapping(value= {"/login"})
    public ModelAndView getLoginPage() {
        this.render.setViewName("login");
        return this.render;
    }

    @GetMapping(value= {"/logout"})
    public ModelAndView getLogout() {
        this.render.setViewName("login");
        return this.render;
    }
    /*@RequestMapping("logon")
    public String logon(){
        //methode 1 : Recuperation du username (ou princiapl)
        String user = req.getRemoteUser();
        System.out.println("Principal is : " + user);
        //methode 2 : Recuperation du username (ou principal)
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Principal is : " + name);

        if(user != null)
            return "client/addClient";
        else
            return "user/login";
    }*/

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, )

//    @RequestMapping(value="/403")
//    public String error() {
//        return "error/403";
//    }
}
