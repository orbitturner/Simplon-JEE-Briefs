package com.senforage.orbit.security;
/* === 🌌 WELCOME TO ORBIT SPACESHIP 🌌  ===
 *
 *     Project : SenForageSpringWeb
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
 *                              GITHUB : /orbitturner    -   Website: http://orbitturner.com/
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * GetThe Actual Datasource Configs
     */
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Specify & Get The DataSource where The Users Are
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bcpe = getBCPE();
        System.out.println(bcpe.encode("@Respclient1"));
        //# ==============================================================
        //# = Manage Auth with DATASOURCE
        //# ==============================================================
        auth.jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery("SELECT email as principal, password as credentials, state FROM User WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT u.email as principal, r.libelle as role FROM User u, Roles r WHERE u.id_role = r.id AND u.email = ?")
                .rolePrefix("ROLE_")
                .passwordEncoder(getBCPE());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin(); //pour afficher un formulaire de connexion par defaut
        try {
            http.formLogin().loginPage("/auth/login").permitAll();  //personnaliser le form de login
//            http.formLogin();  //personnaliser le form de login

            http.authorizeRequests().antMatchers("/assets/**", "/css/**","/images/**", "/js/**", "/login/**", "/main-dark/**", "/errors/**", "/auth/**").permitAll();
            http.authorizeRequests().antMatchers("/home/**").hasAnyRole("SUPERADMIN","RESPCLIENT");
            http.authorizeRequests().antMatchers("/villages/**").hasRole("RESPCLIENT");
            http.authorizeRequests().antMatchers("/users/**","/Roles/**").hasRole("SUPERADMIN");
            http.exceptionHandling().accessDeniedPage("/auth/403")
                    .and().logout().invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/auth/login?logout=true").permitAll().and()
                    .csrf()
                    .disable();
            http.authorizeRequests().anyRequest().authenticated();
//            http.csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
