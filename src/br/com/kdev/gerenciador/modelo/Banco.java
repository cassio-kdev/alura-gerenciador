package br.com.kdev.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Banco {

	private static AtomicInteger increment = new AtomicInteger(0);
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	static {
		Banco.lista.addAll(Arrays.asList(new Empresa(increment.incrementAndGet() ,"kdev-01"),
															new Empresa(increment.incrementAndGet(),"kdev-02"),
															new Empresa(increment.incrementAndGet(),"kdev-03")));
		
		Banco.usuarios.addAll(Arrays.asList(new Usuario("teste", "1234"),
																	new Usuario("teste02", "1234")));
	}
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	public Integer getGeraId() {
		return increment.incrementAndGet();
	}
	
	public void delete(Integer id) {
		for(Iterator<Empresa> empresa = lista.iterator(); empresa.hasNext();) {
			Empresa emp = empresa.next();
			if(emp.getId() == id) {
				empresa.remove();
			}
		}
	}
	
	public void editar(Empresa empresa) {
		for (Empresa emp : lista) {
			if(emp.getId() == empresa.getId()) {
				emp.setNome(empresa.getNome());
				emp.setDataAbertura(empresa.getDataAbertura());
			}
		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for(Empresa emp : lista) {
			if(emp.getId() == id) {
				return emp;
			}
		}
		throw new IllegalArgumentException("Empresa não localizada!");
	}

	public Usuario validaUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
