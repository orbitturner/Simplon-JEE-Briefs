package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AppFilter
 */
@WebFilter( { "/*", "/" } )
public class AppFilter implements Filter {
    // Adding Debug Mode - True => Pass
    private static final Boolean DEBUG_MODE     = false;
    private static final String  USER_SESS_DATA = "actualUser";
    private static final String  LOGIN          = "/login";

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
            throws IOException, ServletException {

        /* Cast des objets request et response */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        /* Non-filtrage des ressources statiques */
        String chemin = req.getRequestURI().substring( req.getContextPath().length() );
        if ( chemin.startsWith( "/resources" ) ) {
            chain.doFilter( req, resp );
            return;
        }

        // String action = req.getServletPath();
        // if ( chemin != null ) {
        // if ( chemin.contains( "/resources" ) ) {
        // chain.doFilter( req, resp );
        // return;
        // }
        // }
        /* Création ou récupération de la session */
        HttpSession session = req.getSession();

        // pass the request along the filter chain
        if ( !DEBUG_MODE ) {
            // If we don't have data on the actual Connected user in session
            if ( session.getAttribute( USER_SESS_DATA ) == null ) {
                /* Redirection vers la page publique */
                req.getRequestDispatcher( LOGIN ).forward( req, resp );
            } else {
                /*
                 * if ( chemin != null && chemin.startsWith( "/login" ) ) { //
                 * resp.sendRedirect( "home" ); // req.getRequestDispatcher(
                 * "home" ).forward( req, resp ); } else { chain.doFilter( req,
                 * resp ); }
                 */
                chain.doFilter( req, resp );
            }
        } else {
            // IF WE ARE IN DEBUG MODE
            // resp.sendRedirect( "admin/" );
            chain.doFilter( req, resp );
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init( FilterConfig fConfig ) throws ServletException {
        // TODO Auto-generated method stub
    }

}
