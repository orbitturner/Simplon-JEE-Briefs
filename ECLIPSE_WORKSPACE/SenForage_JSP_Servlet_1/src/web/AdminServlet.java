package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ViewRenderer;

/**
 * Servlet implementation class Admin
 */
@WebServlet( name = "Admin", description = "Manage Admin Portal", urlPatterns = { "/admin" } )
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final HttpServlet currentClass     = this;

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // Gets The Method Called From The URL
        String action = request.getServletPath();

        // METHOD SWITCHER
        switch ( action ) {
        case "/admin": {
            ViewRenderer.render( this.currentClass, request, response, "Admin Dashboard - SEN FORAGE",
                    "admin/dashboard" );
            // yield type;
        }
        default:
            // throw new IllegalArgumentException( "Unexpected value: " + action
            // );
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
