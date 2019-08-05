package br.com.projeto.zup2.repository;

import br.com.projeto.zup2.model.BandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BandasRepository extends JpaRepository<BandaModel, Long> {

    List<BandaModel> findByName(String Name);
}
