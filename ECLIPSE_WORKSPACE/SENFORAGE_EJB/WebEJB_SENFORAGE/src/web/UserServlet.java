package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.IRolesDao;
import metier.dao.IUserDao;
import metier.entities.User;
import metier.forms.InscriptionForm;
import services.UrlHelper;
import services.ViewRenderer;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet( name = "User", description = "Main Users Servlet", urlPatterns = { "/users", "/users/new" } )
public class UserServlet extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    private final HttpServlet  currentClass     = this;
    public static final String ACT_USERS_LIST   = "usersList";
    // A DEPLACER VERS ROLES
    public static final String ACT_ROLES_LIST   = "rolesList";

    @EJB
    private IRolesDao          rolesdao;
    private IUserDao           userdao;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // Gets The Method Called From The URL
        String action = request.getServletPath();
        String page = "404";
        String title = "NONE";

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        /*
         * Si la Liste des clients n'existe pas en session, alors l'utilisateur
         * se connecte pour la première fois et nous devons précharger en
         * session les infos contenues dans la BDD.
         */
        if ( session.getAttribute( ACT_USERS_LIST ) == null ) {
            List<?> usersList = userdao.getAllActiveUser();
            List<?> rolesList = rolesdao.getAllRoles();
            session.setAttribute( ACT_USERS_LIST, usersList );
            session.setAttribute( ACT_ROLES_LIST, rolesList );
        }

        // METHOD SWITCHER
        switch ( action ) {
        case "/users":
            title = "Users List - SEN FORAGE";
            page = "user/list";
            break;

        case "/users/new":
            title = "Create a Users - SEN FORAGE";
            page = "user/create";
            break;

        default:
            // throw new IllegalArgumentException( "Unexpected value: " + action
            // );
            break;
        }

        ViewRenderer.render( this.currentClass, request, response, title,
                page );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User utilisateur = form.inscrireUtilisateur( request );

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( utilisateur != null ) {
            request.setAttribute( "userSuccess", true );
            response.sendRedirect( UrlHelper.getProjectBase() + "users" );
        } else {

            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "user", utilisateur );

            ViewRenderer.render( currentClass, request, response, "Create a Users - SEN FORAGE", "user/create" );
        }
    }
}
