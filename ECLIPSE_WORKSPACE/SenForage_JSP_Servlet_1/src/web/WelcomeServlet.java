package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ViewRenderer;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet( name = "Home", description = "Main Home Servlet", urlPatterns = { "/home" }, loadOnStartup = 1 )
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Add this In all Servlet to tell the renderer where we are
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

        ViewRenderer.render( this.currentClass, request, response, "Admin Dashboard - SEN FORAGE",
                "home" );

    }

}
