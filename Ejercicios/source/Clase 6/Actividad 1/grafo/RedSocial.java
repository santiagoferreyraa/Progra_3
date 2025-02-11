package grafo;

import java.util.*;
import java.util.Map.Entry;

import models.Usuario;

public class RedSocial {
	private Map<Usuario, ArrayList<Usuario>> grafo;
	
	public RedSocial() {
		grafo = new HashMap<>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		ArrayList<Usuario> seguidores = new ArrayList<>();
		grafo.put(usuario, seguidores);
	}
	
	public void seguir(Usuario seguidor, Usuario seguido) {
		if(!grafo.containsKey(seguidor)) {
			agregarUsuario(seguidor);
		}
		if(!grafo.containsKey(seguido)){
			agregarUsuario(seguido);
		}
		grafo.get(seguidor).add(seguido);
	}
	
	public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
		if(!grafo.containsKey(seguidor)) {
			throw new IllegalArgumentException("Usuario seguidor inexistente");
		}
		if(!grafo.containsKey(seguido)){
			throw new IllegalArgumentException("Usuario seguido inexistente");
		}
		if(!grafo.get(seguidor).contains(seguido)) {
			throw new IllegalArgumentException("El usuario seguidor no sigue al usuario seguido");
		}
		grafo.get(seguidor).remove(seguido);
	}
	
	public ArrayList<Usuario> listaSeguidores(Usuario usuario){
		return grafo.get(usuario);
	}
	
	public List<Usuario> listaSeguidoresDe(Usuario usuario) {
        List<Usuario> seguidores = new ArrayList<>();
        for (Entry<Usuario, ArrayList<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }
}
