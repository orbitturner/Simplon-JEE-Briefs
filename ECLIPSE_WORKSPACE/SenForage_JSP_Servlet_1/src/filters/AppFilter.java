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

/**
 * Servlet Filter implementation class AppFilter
 */
@WebFilter( "/*" )
public class AppFilter implements Filter {
    private static final Boolean DEBUG_MODE = false;

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

        // Auth
        // Boolean pass = true;

        /* Non-filtrage des ressources statiques */
        String chemin = req.getRequestURI().substring(
                req.getContextPath().length() );
        if ( chemin.startsWith( "/resources" ) ) {
            chain.doFilter( req, resp );
            return;
        }

        // pass the request along the filter chain
        if ( !DEBUG_MODE ) {
            chain.doFilter( req, resp );
        } else {
            resp.sendRedirect( req.getContextPath() + "/index.jsp" );
        }
        //
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init( FilterConfig fConfig ) throws ServletException {
        // TODO Auto-generated method stub
    }

}
