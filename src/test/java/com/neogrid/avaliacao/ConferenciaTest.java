package com.neogrid.avaliacao;

import java.io.File;
import java.util.List;

import com.neogrid.avaliacao.config.ConferenciaConfig;
import com.neogrid.avaliacao.model.Conferencia;
import com.neogrid.avaliacao.model.Palestra;
import com.neogrid.avaliacao.service.ConferenciaService;

import junit.framework.TestCase;

public class ConferenciaTest extends TestCase {

    
	public void testConferencias() throws Exception {
		
		File arquivo = new File(getDirNameFile());
		int numeroConferiasDiaEsperado = 2;
		int numeroPalestrasEsperado = 10;
		String ultimaPalestraStr = ConferenciaConfig.NETWORKING_STR;
		ConferenciaService service = new ConferenciaService();
		List<Conferencia> conferenciasList = service.gerarConferencia();
		
		System.out.println(conferenciasList.get(0).getPalestrasList().size());
		
		assertTrue(arquivo.exists());
		assertNotNull(conferenciasList);
		assertEquals(numeroConferiasDiaEsperado,conferenciasList.size());
		assertNotNull(conferenciasList.get(0).getPalestrasList());
		assertEquals(numeroPalestrasEsperado,conferenciasList.get(0).getPalestrasList().size());
	
		Palestra ultimaPalestra = conferenciasList.get(0).getPalestrasList().get(conferenciasList.get(0).getPalestrasList().size() -1);
		assertEquals(ultimaPalestraStr,ultimaPalestra.getNome());
	
	}
	
	private String getDirNameFile() {
		return System.getProperty("user.dir") + 
				System.getProperty("file.separator") + 
				ConferenciaConfig.FILE_NAME;
	}
}
