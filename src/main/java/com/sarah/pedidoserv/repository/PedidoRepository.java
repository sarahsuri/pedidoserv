package com.sarah.pedidoserv.repository;

import org.springframework.data.repository.CrudRepository;
import com.sarah.pedidoserv.domain.Pedido;

public interface PedidoRepository extends CrudRepository <Pedido, Long> {

}
