package br.com.gamas.treinamento;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class Application {

	
	
	class Retorno {
		public Long timestamp;
		public String data;

		public Retorno(Long timestamp, String data) {
			super();
			this.timestamp = timestamp;
			this.data = data;
		}
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "Hello World!";
	}

	@RequestMapping("/horacerta")
	@ResponseBody
	public Retorno restResponse() {
		Date data = new Date();
		return new Retorno(data.getTime(), data.toString());
	}

	@RequestMapping("/horacerta/{parametro}")
	@ResponseBody
	public Retorno restRequestVar(@PathVariable("parametro") Long parametro) {
		
		if (parametro > 0) {
			Date data = new Date(parametro);
			return new Retorno(data.getTime(), data.toString());
		} else {
			Date data = new Date();
			return new Retorno(data.getTime(), data.toString());	
		}
	}

	@RequestMapping("/horacerta2")
	@ResponseBody
	public Retorno restRequestParameter(@RequestParam("parametro") Long parametro) {
		if (parametro > 0) {
			Date data = new Date(parametro);
			return new Retorno(data.getTime(), data.toString());
		} else {
			Date data = new Date();
			return new Retorno(data.getTime(), data.toString());	
		}
	}
	
	//curl -i -H "Content-Type: application/json" -X POST -d '{"id":1, "descricao":"pessoa"}' http://localhost:8081/rest-request-complexo
	
	@RequestMapping(value = "/rest-request-complexo", consumes = { "application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" }, method = { RequestMethod.POST })
	public @ResponseBody Retorno searchDocumento(@RequestBody(required = false) Request request) {
		Date data = new Date();
		return new Retorno(data.getTime(), data.toString());	
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	

}
