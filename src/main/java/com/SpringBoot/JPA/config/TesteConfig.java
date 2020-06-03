package com.SpringBoot.JPA.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.SpringBoot.JPA.entities.Categoria;
import com.SpringBoot.JPA.entities.OrdemItem;
import com.SpringBoot.JPA.entities.Order;
import com.SpringBoot.JPA.entities.Pagamento;
import com.SpringBoot.JPA.entities.Produto;
import com.SpringBoot.JPA.entities.User;
import com.SpringBoot.JPA.entities.enums.OrderStatus;
import com.SpringBoot.JPA.repository.CategoriaRepository;
import com.SpringBoot.JPA.repository.OrdemItemRepository;
import com.SpringBoot.JPA.repository.OrderRepository;
import com.SpringBoot.JPA.repository.ProdutoRepository;
import com.SpringBoot.JPA.repository.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private OrdemItemRepository ordemItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELADO, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAGO, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrdemItem oi1 = new OrdemItem(o1, p1, 2, p1.getPrice()); // oi1 é do pedido "o1" produto 1 "p1" e quanridade 2,
																	// e o preço está reproduzindo do P1
		OrdemItem oi2 = new OrdemItem(o1, p3, 1, p3.getPrice());
		OrdemItem oi3 = new OrdemItem(o2, p3, 2, p3.getPrice());
		OrdemItem oi4 = new OrdemItem(o3, p5, 2, p5.getPrice());

		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPagamento(pag1);
		
		orderRepository.save(o1);
		
		
	}
}
