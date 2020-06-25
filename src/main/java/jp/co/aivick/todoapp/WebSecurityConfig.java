package jp.co.aivick.todoapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "index.html", "/signup", "/login", "/password/*")  
						  // ここまでは全員閲覧可能
			.permitAll()  // それ以外は認証が必要
			.antMatchers("/admin/**")
			.hasAuthority("ADMIN")
			.anyRequest() // その他は認証済み
			.authenticated();
		http
			.formLogin()
			.loginPage("/login")		    //ログイン画面
			.loginProcessingUrl("/login")   //認証処理
			.defaultSuccessUrl("/tasks/top")		//ログイン成功後の遷移先
			.usernameParameter("login_id")	//usernameのパラメーター
			.passwordParameter("password")	//passwordのパラメーター
			.failureUrl("/login");			//ログイン失敗時の遷移先
		http
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login");	//ログアウト成功時の遷移先
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery(
				"SELECT login_id, password, enabled from users where login_id = ?")
			.authoritiesByUsernameQuery("SELECT login_id, role from users where login_id = ?")
			.passwordEncoder(passwordEncoder());
			
		}
}
