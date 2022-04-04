package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
package com.examly.springapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examly.springapp.serviceimpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	private Logger loggers=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		loggers.info(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
				
			}catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				loggers.info("jwt token has expired");
				
			}catch(Exception e) {
				
				e.printStackTrace();
				loggers.info("error");
			}
			
		}else
		{
			loggers.info("Inavlid token , not start with bearer string");
		}
		
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails)))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			loggers.info("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}
	
}
