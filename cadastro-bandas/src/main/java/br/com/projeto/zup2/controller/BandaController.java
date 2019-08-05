package br.com.projeto.zup2.controller;

import br.com.projeto.zup2.model.BandaModel;
import br.com.projeto.zup2.repository.BandasRepository;
import br.com.projeto.zup2.request.CreateBandaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("bandas")
public class BandaController extends Exception {

    @Autowired
    private BandasRepository bandasRepository;

    public BandaController(BandasRepository bandasRepository) {
        this.bandasRepository = bandasRepository;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public String Create(@RequestBody @Valid CreateBandaRequest request) {

        try {
            if (!request.getStyle().contains("Rock")) {
                return "Se não é rock, nem vem!";
            }

            BandaModel bandaModel = BandaModel.builder().name(request.getName()).style(request.getStyle()).song(request.getSong()).build();

            BandaModel save = bandasRepository.save(bandaModel);

            return "Banda Cadastrada com suceso!";

        } catch (Exception e) {
            return "Erro ao cadastrar! Valide o Json";
        }

    }

    @GetMapping("list/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BandaModel> FindAll(@PathVariable String name) {
        List<BandaModel> localizado = bandasRepository.findByName(name);
        return localizado;
    }

    @GetMapping("list")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BandaModel> FindAll() {
        List<BandaModel> todos = bandasRepository.findAll();
        return todos;
    }


}
