package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FilmeTest {
	@Test
	public void criaFilmeComNome() throws Exception {
		Filme filme = new Filme("Loucasso");
		assertEquals("Loucasso", filme.getTitulo());
	}
	
	@Test
	public void filmeToString() throws Exception {
		Filme filme = new Filme("Loucasso");
		Ator ator = new Ator("Louco");
		filme.inserirAtor(ator);
		assertEquals("Titulo: Loucasso\nElenco: Louco",filme.toString());
	}

	@Test
	public void elencoTemIssoNoNome() throws Exception {
		Filme filme = new Filme("Loucasso");
		Ator ator = new Ator("Louco");
		filme.inserirAtor(ator);
		ArrayList<Ator> esperado = new ArrayList<>();
		esperado.add(ator);
		assertEquals(esperado,filme.temIssoNoNome("Louco"));
	}
	
}