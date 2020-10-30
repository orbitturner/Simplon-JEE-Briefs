package services;

//<!-- /* === 🌌 WELCOME TO ORBIT WP REMIX 🌌  === -->
//<!-- *                      -->
//<!-- *    By : -->
//<!-- * -->
//<!-- *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗  -->
//<!-- *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗ -->
//<!-- *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝ -->
//<!-- *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗ -->
//<!-- *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║ -->
//<!-- *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ -->
//<!-- *           -->
//<!-- *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal -->
//<!-- *                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/  -->
//<!-- */ -->
/**
 *
 * @author OrbitTurner
 */
public class MyValidator {

    public static boolean isEmail( String email ) {
        boolean stricterFilter = true;
        String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
        String emailRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( emailRegex );
        java.util.regex.Matcher m = p.matcher( email );
        return m.matches();
    }

    private static boolean isTel( String tel ) {
        boolean stricterFilter = true;
        String stricterFilterString = "[0-9]{9}";
        String laxString = "";
        String telRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( telRegex );
        java.util.regex.Matcher m = p.matcher( tel );
        return m.matches();

    }

    public static boolean isNom( String nom ) {
        boolean stricterFilter = true;
        String stricterFilterString = "[A-Za-zéèçàê]{2,50}";
        String laxString = "";
        String nomRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( nomRegex );
        java.util.regex.Matcher m = p.matcher( nom );
        return m.matches();
    }

    public static boolean isNomWhithWhiteEspace( String nom ) {
        boolean stricterFilter = true;
        String stricterFilterString = "^[a-zA-Z éèçàêôÔïÏ]{2,50}+";
        String laxString = "";
        String nomRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( nomRegex );
        java.util.regex.Matcher m = p.matcher( nom );
        return m.matches();
    }

    public static boolean isPassword( String pwd ) {
        boolean stricterFilter = true;
        String stricterFilterString = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}";
        String laxString = "";
        String passwordRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( passwordRegex );
        java.util.regex.Matcher m = p.matcher( pwd );
        return m.matches();
    }

    public static boolean isAlphaNumeric( String alphanumerique ) {
        boolean stricterFilter = true;
        String stricterFilterString = "^[a-zA-Z0-9 ]+";
        String laxString = "";
        String alphanumeriqueRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( alphanumeriqueRegex );
        java.util.regex.Matcher m = p.matcher( alphanumerique );
        return m.matches();
    }

    public static boolean isAlphaNumericAndHyphen( String alphanumerique ) {
        boolean stricterFilter = true;
        String stricterFilterString = "^[a-zA-Z0-9-_/]+$";
        String laxString = "";
        String alphanumeriqueRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( alphanumeriqueRegex );
        java.util.regex.Matcher m = p.matcher( alphanumerique );
        return m.matches();
    }

    public static boolean isPositifNumber( String number ) {
        boolean stricterFilter = true;
        String stricterFilterString = "^\\d+$";
        String laxString = "";
        String numberRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( numberRegex );
        java.util.regex.Matcher m = p.matcher( number );
        return m.matches();
    }

    public static boolean isSenegaleseCallNumber( String numero ) {
        boolean aide = true;

        if ( isTel( numero ) ) {
            if ( numero.matches( "77(.*)" ) == true || numero.matches( "78(.*)" ) == true
                    || numero.matches( "76(.*)" ) == true || numero.matches( "70(.*)" ) == true ) {

            } else {
                aide = false;
            }
        } else {
            aide = false;
        }

        return aide;

    }

    public static boolean isSenegaleseFixeNumber( String numero ) {
        boolean aide = true;

        if ( isTel( numero ) ) {
            if ( numero.matches( "33(.*)" ) == true ) {

            } else {
                aide = false;
            }
        } else {
            aide = false;
        }

        return aide;

    }

    public static int calculatePasswordStrength( String password ) {

        // total score of password
        int iPasswordScore = 0;

        if ( password.length() < 8 ) {
            return 0;
        } else if ( password.length() >= 10 ) {
            iPasswordScore += 2;
        } else {
            iPasswordScore += 1;
        }

        // if it contains one digit, add 2 to total score
        if ( password.matches( "(?=.[0-9])." ) ) {
            iPasswordScore += 2;
        }

        // if it contains one lower case letter, add 2 to total score
        if ( password.matches( "(?=.[a-z])." ) ) {
            iPasswordScore += 2;
        }

        // if it contains one upper case letter, add 2 to total score
        if ( password.matches( "(?=.[A-Z])." ) ) {
            iPasswordScore += 2;
        }

        // if it contains one special character, add 2 to total score
        if ( password.matches( "(?=.[~!@#$%^&()_-]).*" ) ) {
            iPasswordScore += 2;
        }

        return iPasswordScore;

    }

    public static boolean isWithoutSemicolon( String alphanumerique ) {
        boolean stricterFilter = true;
        String stricterFilterString = "^[a-zA-Z0-9-_ éèçàêôÔïÏ@,/]+$";
        String laxString = "";
        String alphanumeriqueRegex = stricterFilter ? stricterFilterString : laxString;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile( alphanumeriqueRegex );
        java.util.regex.Matcher m = p.matcher( alphanumerique );
        return m.matches();
    }

}
