/**
 * 
 */
package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import metier.entities.User;

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
@Stateless
public class UserDao implements IUserDao {

    private static final String JPQL_SELECT_PAR_EMAIL_PWD = "SELECT u FROM User u WHERE u.email=:email and u.password=:password";
    private static final String JPQL_SELECT_PAR_EMAIL     = "SELECT u FROM User u WHERE u.email=:email";
    private static final String PARAM_EMAIL               = "email";
    private static final String PARAM_PWD                 = "password";

    private EntityManager       em;

    /**
     * Constructor
     */
    public UserDao() {
        em = EntityHelper.getManager();
    }

    /**
     * @params email, password Find User by his Email and Pwd
     * @return User
     */
    @Override
    public User getUserbyParams( String email, String password ) throws DAOException {
        User utilisateur = null;

        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL_PWD );
        requete.setParameter( PARAM_EMAIL, email );
        requete.setParameter( PARAM_PWD, password );

        try {
            utilisateur = (User) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

        return utilisateur;
    }

    /**
     * @param User
     *            Persist User
     * @return void
     */
    @Override
    public void create( User user ) throws DAOException {
        try {
            EntityHelper.create( user );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    @Override
    public User getUserbyParams( String email ) throws DAOException {
        User utilisateur = null;

        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );

        try {
            utilisateur = (User) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

        return utilisateur;
    }

    @Override
    public List<?> getAllActiveUser() throws DAOException {
        List<?> users = null;
        try {
            Query requete = em.createQuery( "select u From User u where u.state=1" );
            users = requete.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return users;
    }

}
