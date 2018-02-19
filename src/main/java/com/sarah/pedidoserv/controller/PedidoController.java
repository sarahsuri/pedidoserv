package com.sarah.pedidoserv.controller;

import com.sarah.pedidoserv.domain.Pedido;
import com.sarah.pedidoserv.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/list")
    public Iterable<Pedido> list() {
        return pedidoService.list();
    }

    @GetMapping("/consultaControle")
    public Pedido consultaNumeroControle(){
        return pedidoService.consultaNumeroControle();
    }
    @GetMapping("/consultaData")
    public Pedido consultaNumeroControle(){
        return pedidoService.consultaData();
    }

}
