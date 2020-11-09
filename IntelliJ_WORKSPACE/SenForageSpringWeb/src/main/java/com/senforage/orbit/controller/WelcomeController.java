package com.senforage.orbit.controller;
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

import com.senforage.orbit.dao.IClientDao;
import com.senforage.orbit.dao.IUserDao;
import com.senforage.orbit.dao.IVillageDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    private final IClientDao clientRepository;
    private final IVillageDao villageRepository;
    private final IUserDao userRepository;

    public WelcomeController(IClientDao clientRepository, IVillageDao villageRepository, IUserDao userRepository) {
        this.clientRepository = clientRepository;
        this.villageRepository = villageRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public ModelAndView index(){
        String pageTitle = "SEN FORAGE - Dashboard";
        String role = "SUPER_ADMIN";

        Long nbClient = clientRepository.count();
        Long nbVillage = villageRepository.count();
        Long nbUser = userRepository.count();

        ModelAndView render = new ModelAndView("template/OrbitLayout");

        render.addObject("pageTitle", pageTitle);
        render.addObject("role", role);
        render.addObject("view", "home");
        render.addObject("nbClient", nbClient);
        render.addObject("nbVillage", nbVillage);
        render.addObject("nbUser", nbUser);

        return render;
    }
}
