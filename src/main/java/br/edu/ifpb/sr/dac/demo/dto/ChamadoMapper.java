package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    GetChamadoDTO toDto(Chamado chamado);

    Chamado toEntity(GetChamadoDTO dto);

    PostChamadoDTO toPostChamadoDto(Chamado chamado);

    Chamado toChamadoEntity(PostChamadoDTO dto);
}
