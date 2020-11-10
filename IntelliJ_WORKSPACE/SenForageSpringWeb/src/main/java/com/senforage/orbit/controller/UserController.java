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

import com.senforage.orbit.dao.IRolesDao;
import com.senforage.orbit.dao.IUserDao;
import com.senforage.orbit.entities.Roles;
import com.senforage.orbit.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    //================ DAO ACCESS ================
    private final IUserDao userRepository;
    private final IRolesDao roleRepository;
    ModelAndView render;
    // Simulatin du Role de L'utilisateur
    String role = "SUPER_ADMIN";
    //================ TEMPLATE AND VIEW PARAMETERS ================
    private String pageTitle = "SEN FORAGE • LIST OF USERS";
    private String view = "user/list";
    // LIST OF ENTITIES NEEDED IN THE VIEW
    private List<Roles> rolesList;
    private List<User> usersList;


    /**
     * Replace Autowired
     *
     * @param userRepository
     * @param roleRepository
     */
    public UserController(IUserDao userRepository, IRolesDao roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.rolesList = roleRepository.findAll();

        // INSTANCIATION DU TEMPLATE
        this.render = new ModelAndView("template/OrbitLayout");
    }

    /**
     * Loads The User List View
     *
     * @return
     */
    @GetMapping({"/", ""})
    public ModelAndView index() {
        //======================== FEEDING THE SPA TEMPLATE =============================
        pageTitle = "SEN FORAGE • LIST OF USERS";
        view = "user/list";
        //======================== ------------------------ =============================

        // Get All Users - Refreshed everyTime
        this.usersList = userRepository.findAll();

        // Passing Data To The View
        render.addObject("usersList", this.usersList);
        render.addObject("view", view);
        render.addObject("pageTitle", pageTitle);
        render.addObject("role", role);

        //=====RENDERING======
        return render;
        //----------------------
    }

    /**
     * Loads The User Creation Form
     *
     * @return ModelAndView
     */
    @GetMapping("/new")
    public ModelAndView create() {
        //======================== FEEDING THE SPA TEMPLATE =============================
        pageTitle = "SEN FORAGE • CREATE USER";
        view = "user/create";
        //======================== ------------------------ =============================

        // Passing Data To The View
        render.addObject("user", new User());
        render.addObject("rolesList", rolesList);
        render.addObject("view", view);
        render.addObject("pageTitle", pageTitle);
        render.addObject("role", role);

        //=====RENDERING======
        return render;
        //----------------------
    }

    /**
     * Add the User Posted in the Form
     *
     * @return ModelAndView
     */
    @PostMapping("/new")
    public ModelAndView persist(@ModelAttribute User newUser, BindingResult bindingResult) {
        // Testing if Form Has No Error
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/users/new");
        }

        // GETTING DATE TIME
        Date date = new Date();
        String strDateFormat = "dd/MM/yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        // SETTING CREATED_AT DATE TIME TO NOW FOR THE USER
        newUser.setCreated_at(formattedDate);

        // PERSIST ON NO_ERRORS
        userRepository.saveAndFlush(newUser);

        //=====RENDERING======
        return new ModelAndView("redirect:/users/");
        //----------------------
    }
}
