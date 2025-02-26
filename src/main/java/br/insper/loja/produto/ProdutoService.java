package br.insper.loja.produto;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoService {

    public Produto getProduto(String id) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate
                    .getForEntity("http://localhost:8080/api/produto/" + id,
                            Produto.class)
                    .getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Produto putProduto(String id, Integer qtd) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            HttpEntity<String> requestEntity = new HttpEntity<>(qtd.toString(), headers);

            return restTemplate
                    .exchange("http://localhost:8080/api/produto/" + id,
                            HttpMethod.PUT,
                            requestEntity,
                            Produto.class)
                    .getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}