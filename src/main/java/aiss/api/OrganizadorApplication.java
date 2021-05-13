package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.ListaResource;
import aiss.api.resources.PlaylistResource;
import aiss.api.resources.SongResource;
import aiss.api.resources.TareaResource;

public class OrganizadorApplication extends Application {
	


	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public OrganizadorApplication() {

		singletons.add(ListaResource.getInstance());
		singletons.add(TareaResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

