package com.algaworks.gerenciador.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/*
 * classe utilizada para multi tenancy
 */
@RequestScoped
public class TenantProducer {

	@Produces
	@RequestScoped
	@TenantInject
	public Tenant create() {
		String requestURL = getRequest().getRequestURL().toString();//pega a url do browser
		String tenantId = requestURL.substring(7).replaceAll("\\..+", "");//remove todos os http:// e tudo depois do primeiro . (ponto)
		return new Tenant(tenantId);
	}
	
	private HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
}
