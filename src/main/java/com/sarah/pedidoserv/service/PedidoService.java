package com.sarah.pedidoserv.service;


import com.sarah.pedidoserv.domain.Pedido;
import com.sarah.pedidoserv.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Service
public class PedidoService {


    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Iterable<Pedido> list() {
        return pedidoRepository.findAll();
    }
    public Pedido consultaNumeroControle(int numeroControle){
        return pedidoRepository.findOne((long) numeroControle);
    }

    public Pedido consultaData(String dataCadastro){
        return pedidoRepository.findOne(Long.valueOf(dataCadastro));
    }
    public Pedido save(Pedido pedidos) {
            // condições para aceitação do arquivo
        if (pedidos.getNumeroControle() == pedidos.getNumeroControle()) {
            System.out.println("Número de controle duplicado. Pedido inválido");
        } else {
            if (pedidos.getDataCadastro() == null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date data = new Date();
                String dateData = dateFormat.format(data);
                pedidos.setDataCadastro(dateData);
                return pedidoRepository.save(pedidos);
            } else if (pedidos.getQuantidade() == 0) {
                pedidos.setQuantidade(1);
                return pedidoRepository.save(pedidos);
            } else if (pedidos.getQuantidade() >= 5 && pedidos.getQuantidade() < 10) {
                float x = ((pedidos.getValor() * 5) / 100);
                pedidos.setValor(x);
                return pedidoRepository.save(pedidos);
            } else if (pedidos.getQuantidade() >= 10) {
                float x = ((pedidos.getValor() * 10) / 100);
                pedidos.setValor(x);
                return pedidoRepository.save(pedidos);
            }
            return pedidoRepository.save(pedidos);
        }


        return pedidos;
    }
}
