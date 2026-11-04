package it.homebanking.homebanking_lite;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.homebanking.homebanking_lite.model.Cliente;
import it.homebanking.homebanking_lite.model.Conto;
import it.homebanking.homebanking_lite.model.Movimento;
import it.homebanking.homebanking_lite.service.ClienteService;
import it.homebanking.homebanking_lite.service.ContoService;
import it.homebanking.homebanking_lite.service.MovimentoService;

@Controller
public class HomeController {

	private final ClienteService clienteService;
	private final ContoService contoService;
	private final MovimentoService movimentoService;


	public HomeController(ClienteService clienteService, ContoService contoService, MovimentoService movimentoService) {
		this.clienteService = clienteService;
		this.contoService = contoService;
		this.movimentoService = movimentoService;
	}

	/**
	 * Visualizza la dashboard del cliente autenticato, recuperando conti, saldo
	 * totale e movimenti.
	 */
	
	@GetMapping("/")
	public String home(Authentication authentication, Model model) {

		if (authentication != null && authentication.isAuthenticated()
				&& !AuthorityUtils.authorityListToSet(authentication.getAuthorities()).contains("ROLE_ANONYMOUS")) {

			String username = authentication.getName();

			Cliente cliente = clienteService.trovaPerUsername(username).orElse(null);

			if (cliente != null) {
				model.addAttribute("cliente", cliente);

				List<Conto> conti = contoService.trovaPerIdCliente(cliente.getIdCliente());
				model.addAttribute("conti", conti);

				BigDecimal saldoTotale = BigDecimal.ZERO;

				for (Conto conto : conti) {

					saldoTotale = saldoTotale.add(conto.getSaldo());
				}

				model.addAttribute("saldoTotale", saldoTotale);

				List<Movimento> movimenti = movimentoService.trovaPerIdCliente(cliente.getIdCliente());

				model.addAttribute("movimenti", movimenti);
			}
		}

		return "index";
	}

	/**
	 * Visualizza i movimenti del cliente autenticato, con la possibilità di
	 * filtrare per conto.
	 */
	@GetMapping("/movimenti")
	public String movimenti(Authentication authentication, @RequestParam(required = false) Long contoId, Model model) {

		if (authentication != null && authentication.isAuthenticated()
				&& !AuthorityUtils.authorityListToSet(authentication.getAuthorities()).contains("ROLE_ANONYMOUS")) {

			String username = authentication.getName();

			Cliente cliente = clienteService.trovaPerUsername(username).orElse(null);

			if (cliente != null) {

				model.addAttribute("cliente", cliente);

				List<Conto> conti = contoService.trovaPerIdCliente(cliente.getIdCliente());
				model.addAttribute("conti", conti);

				List<Movimento> movimenti;

				if (contoId == null) {

					movimenti = movimentoService.trovaPerIdCliente(cliente.getIdCliente());

				} else {

					boolean contoAppartieneAlCliente = false;

					for (Conto conto : conti) {
						if (conto.getIdConto().equals(contoId)) {
							contoAppartieneAlCliente = true;
							break;
						}
					}

					if (!contoAppartieneAlCliente) {
						return "redirect:/movimenti";
					}

					movimenti = movimentoService.trovaPerIdConto(cliente.getIdCliente(), contoId);
				}

				model.addAttribute("movimenti", movimenti);
				model.addAttribute("contoId", contoId);

				return "movimenti";
			}
		}

		return "redirect:/login";
	}
}