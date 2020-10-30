/**
 * 
 */
package forms;

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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import dao.DAOException;
import dao.RolesDao;
import dao.RolesDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entities.Roles;
import entities.User;
import services.MyValidator;

/**
 * @author shado
 *
 */
public final class InscriptionForm {
    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_PASS       = "password";
    private static final String CHAMP_CONF       = "confirmpass";
    private static final String CHAMP_NOM        = "nom";
    private static final String CHAMP_ROLE       = "role";

    private static final String CHAMP_PRENOM     = "prenom";
    private static final String CHAMP_STATUT     = "status";
    private static final String CHAMP_UNAME      = "username";

    private static final String FORMAT_DATE      = "dd/MM/yyyy HH:mm:ss";

    // private static final String CHAMP_ROLE = "role";

    private static final String ALGO_CHIFFREMENT = "SHA-256";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();
    private UserDao             utilisateurDao   = new UserDaoImpl();
    private RolesDao            roledao          = new RolesDaoImpl();

    public InscriptionForm() {

    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public User inscrireUtilisateur( HttpServletRequest request ) {
        // RECUPERATION DES CHAMPS DU FORMULAIRE
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        int state = Integer.parseInt( getValeurChamp( request, CHAMP_STATUT ) );
        String username = getValeurChamp( request, CHAMP_UNAME );
        long idRole = Integer.parseInt( getValeurChamp( request, CHAMP_ROLE ) );

        // Recuperation Du Role Choisi dans le Formulaire
        Roles role = null;

        try {
            role = roledao.find( idRole );
        } catch ( DAOException e ) {
            setErreur( CHAMP_ROLE, e.getMessage() );
        }

        /* Récupération de la date dans un DateTime Joda. */
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern( FORMAT_DATE );
        String dateCreation = fmt.print( dt );

        User utilisateur = new User();
        try {
            // NETTOYAGE & TRAITEMENT DES CHAMPS
            traiterEmail( email, utilisateur );
            traiterMotsDePasse( motDePasse, confirmation, utilisateur );
            traiterNom( nom, utilisateur );

            if ( erreurs.isEmpty() ) {
                // CREATION
                utilisateur.setCreated_at( dateCreation );
                utilisateur.setPrenom( prenom );
                utilisateur.setState( state );
                utilisateur.setUsername( username );
                utilisateur.setRole( role );

                utilisateurDao.create( utilisateur );

                resultat = "Succés de l'inscription.";
            } else {
                resultat = "Echec de l'inscription.";
                utilisateur = null;
            }
        } catch ( DAOException e ) {
            resultat = "Echec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";

            e.printStackTrace();
            utilisateur = null;
        }

        return utilisateur;
    }

    /*
     * Appel Ã la validation de l'adresse email reÃ§ue et initialisation de la
     * propriÃ©tÃ© email du bean
     */
    private void traiterEmail( String email, User utilisateur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
    }

    /*
     * Appel Ã la validation des mots de passe reÃ§us, chiffrement du mot de
     * passe et initialisation de la propriÃ©tÃ© motDePasse du bean
     */
    private void traiterMotsDePasse( String motDePasse, String confirmation, User utilisateur ) {
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }

        /*
         * Utilisation de la bibliothéque Jasypt pour chiffrer le mot de passe
         * efficacement.
         * 
         * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
         * aléatoire et un grand nombre d'itérations de la fonction de hashage.
         * 
         * La String retournée est de longueur 56 et contient le hash en Base64.
         */
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );

        utilisateur.setPassword( motDePasseChiffre );
    }

    /*
     * Appel à la validation du nom reÃ§u et initialisation de la propriÃ©tÃ©
     * nom du bean
     */
    private void traiterNom( String nom, User utilisateur ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
    }

    /* Validation de l'adresse email */
    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null ) {
            if ( !MyValidator.isEmail( email ) ) {
                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( utilisateurDao.getUserbyParams( email ) != null ) {
                throw new FormValidationException(
                        "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir une adresse mail." );
        }
    }

    /* Validation des mots de passe */
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws FormValidationException {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new FormValidationException(
                        "Les mots de passe entrés sont différents, merci de les saisir à  nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caractéres." );
            } else if ( !MyValidator.isPassword( motDePasse ) ) {
                throw new FormValidationException( "Le Mot de Passe ne Respecte pas les Spécifications de Sécurité." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /* Validation du nom */
    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractéres." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spÃ©cifiÃ© Ã la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * MÃ©thode utilitaire qui retourne null si un champ est vide, et son
     * contenu sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        // DEBUG
        // String valeur = (String) request.getAttribute( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}