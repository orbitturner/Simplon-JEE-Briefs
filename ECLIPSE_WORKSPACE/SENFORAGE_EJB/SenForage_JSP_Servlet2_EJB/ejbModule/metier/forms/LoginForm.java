/**
 * 
 */
package metier.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import metier.dao.UserDao;
import metier.entities.User;
import metier.services.MyValidator;

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
 * @author shado
 *
 */
public class LoginForm {
    // Les Champs dans le Formulaire de la Vue
    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_PASS       = "password";
    private static final String ALGO_CHIFFREMENT = "SHA-256";
    private static final String CHAMP_LOG        = "state";

    private UserDao             userDao          = new UserDao();

    private String              resultat;

    private Map<String, String> erreurs          = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    /**
     * Constructeur de La CLasse
     * 
     * @param utilisateurDao
     */
    public LoginForm() {
        super();
    }

    public User LoginUser( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        User utilisateur = new User();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }

        /* CRYPTAGE DU MOT DE PASSE */
        // motDePasse = checkMotdePasse( motDePasse, utilisateur );
        User connected;
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            /* fin */
            try {
                connected = findUserAccount( email, motDePasse );
            } catch ( Exception e ) {
                setErreur( CHAMP_LOG, e.getMessage() );
                return null;
            }
        } else {
            resultat = "Échec de la connexion.";

            return null;
        }
        /* SET AND RETURN THE CONNECTED USER */
        if ( connected != null ) {
            utilisateur = connected;
            resultat = "Succès de la connexion.";
            return utilisateur;
        } else {
            resultat = "Identifiants Incorrects.";
            return null;
        }

    }

    /**
     * Valide l'adresse email saisie. En utilisant ma classe Validator
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !MyValidator.isEmail( email ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            } else if ( !MyValidator.isPassword( motDePasse ) ) {
                throw new Exception( "Le mot de passe ne Respecte Pas Le pattern spécifié." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /**
     * Fonction de Cryptage du Mot de Passe
     * 
     * @param motDePasse
     * @param utilisateur
     * @return
     */
    // private String crypterMotdePasse( String motDePasse, User utilisateur ) {
    // /*
    // * Utilisation de la bibliothéque Jasypt pour chiffrer le mot de passe
    // * efficacement.
    // *
    // * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
    // * aléatoire et un grand nombre d'itérations de la fonction de hashage.
    // *
    // * La String retournée est de longueur 56 et contient le hash en Base64.
    // */
    // ConfigurablePasswordEncryptor passwordEncryptor = new
    // ConfigurablePasswordEncryptor();
    // passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
    // passwordEncryptor.setPlainDigest( false );
    // String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse
    // );
    //
    // return motDePasseChiffre;
    // }

    private User findUserAccount( String email, String password ) throws Exception {
        User account = null;
        User verifyaccount = null;
        Boolean found = false;
        try {
            verifyaccount = userDao.getUserbyParams( email );
        } catch ( Exception e ) {
            throw new Exception( "Identifiants de Connexion Incorrectes. Merci de Réessayer." );
        }
        if ( verifyaccount != null ) {
            String accountpass = verifyaccount.getPassword();
            try {
                // Checks an unencrypted (plain) password against an encrypted
                // one (a digest) to see if they match
                ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
                passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
                String encryptedPassword = accountpass;
                found = passwordEncryptor.checkPassword( password, encryptedPassword );
            } catch ( Exception e ) {
                throw new Exception( "Erreur Lors de L'encryption." );
            }
            if ( found ) {
                account = verifyaccount;
            } else {
                setErreur( CHAMP_PASS, "Mot de Passe Incorrect !" );
            }
        } else {
            setErreur( CHAMP_EMAIL, "Votre Email n'est pas dans notre Base de Données !" );
        }

        return ( account != null ) ? account : null;
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
