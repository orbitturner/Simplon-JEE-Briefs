/**
 * 
 */
package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fichier;
import services.UploadForm;

/* === 🌌 WELCOME TO ORBIT JEE REMIX 🌌  ===
*                     
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
*                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/ 
*/
/**
 * @author shado Upload File
 *         https://openclassrooms.com/fr/courses/626954-creez-votre-application-web-avec-java-ee/623527-formulaires-lenvoi-de-fichiers
 */
public class Upload extends HttpServlet {
    /**
     * 
     */
    private static final long  serialVersionUID = 1L;

    public static final String CHEMIN           = "chemin";

    public static final String ATT_FICHIER      = "fichier";
    public static final String ATT_FORM         = "form";

    public static final String VUE              = "/WEB-INF/upload.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'upload */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /* Préparation de l'objet formulaire */
        UploadForm form = new UploadForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Fichier fichier = form.enregistrerFichier( request, chemin );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_FICHIER, fichier );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
