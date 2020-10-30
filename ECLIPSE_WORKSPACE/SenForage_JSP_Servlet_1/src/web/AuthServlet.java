package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import forms.LoginForm;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet( name = "Login", description = "Authentication (Login/Logout) Servlet", urlPatterns = { "/login",
        "/logout" } )
public class AuthServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private final String        LOGIN_PAGE       = "/index.jsp";
    private static final String USER_SESS_DATA   = "actualUser";

    @Override
    public void init() throws ServletException {
        super.init();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // Form Initialisation
        request.setAttribute( "form", null );
        request.setAttribute( "user", null );
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        /*
         * if ( session.getAttribute( USER_SESS_DATA ) == null ) {
         * response.sendRedirect( "home" ); }
         */
        // Gets The Method Called From The URL
        String action = request.getServletPath();

        // METHOD SWITCHER
        switch ( action ) {
        case "/login":
            response.setHeader( "Cache-Control", "no-cache, no-store, must-revalidate" ); // HTTP
                                                                                          // 1.1.
            response.setHeader( "Pragma", "no-cache" ); // HTTP 1.0.
            response.setDateHeader( "Expires", 0 ); // Proxies.
            this.getServletContext().getRequestDispatcher( LOGIN_PAGE ).forward(
                    request, response );
            break;
        case "/logout":
            // clear the cache on logout
            response.setHeader( "Cache-Control", "no-cache" );
            response.setHeader( "Cache-Control", "no-store" );
            response.setDateHeader( "Expires", 0 );
            response.setHeader( "Pragma", "no-cache" );

            /* destruction de la session en cours */
            // clear session
            request.getSession().setAttribute( USER_SESS_DATA, null );
            // DEsTROY
            session.invalidate();

            /* Affichage de la page de connexion */
            // this.getServletContext().getRequestDispatcher( LOGIN_PAGE
            // ).forward( request, response );
            response.sendRedirect( "login" );
            break;
        default:
            // throw new IllegalArgumentException( "Unexpected value: " + action
            // );
            break;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        LoginForm form = new LoginForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User utilisateur = form.LoginUser( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() && utilisateur != null ) {
            session.setAttribute( USER_SESS_DATA, utilisateur );
            response.sendRedirect( "home" );
        } else {
            session.setAttribute( USER_SESS_DATA, null );
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "user", utilisateur );

            this.getServletContext().getRequestDispatcher( LOGIN_PAGE ).forward( request, response );
        }
    }

}
