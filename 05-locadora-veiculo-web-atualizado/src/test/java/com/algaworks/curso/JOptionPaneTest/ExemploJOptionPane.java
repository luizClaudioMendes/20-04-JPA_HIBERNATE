package com.algaworks.curso.JOptionPaneTest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;

public class ExemploJOptionPane {

	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		System.out.println("INICIANDO O INIT");
		try {
			factory = Persistence.createEntityManagerFactory("junitPU");
		}catch (Throwable e) {
			System.out.println("ERRO NO INIT");
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() {
		System.out.println("INICIANDO O SETUP");
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		System.out.println("INICIANDO O TEARDOWN");
		this.manager.close();
	}
	
	@Test
	public void buscaFoto() throws IOException {
		Carro carro = manager.find(Carro.class, 13L);
			
		if (carro.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(carro.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Carro não possui foto.");
		}
	}

	
	
}


